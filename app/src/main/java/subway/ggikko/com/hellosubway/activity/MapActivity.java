package subway.ggikko.com.hellosubway.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.blunderer.materialdesignlibrary.activities.NavigationDrawerActivity;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ActionBarSearchHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerAccountsMenuHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerBottomHandler;
import com.blunderer.materialdesignlibrary.handlers.NavigationDrawerTopHandler;
import com.blunderer.materialdesignlibrary.listeners.OnSearchListener;
import com.blunderer.materialdesignlibrary.models.Account;
import com.blunderer.materialdesignlibrary.views.ToolbarSearch;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.fragment.AlertDialogFragment;
import subway.ggikko.com.hellosubway.fragment.MadeByFragment;
import subway.ggikko.com.hellosubway.webview.NavigationFragment;
import subway.ggikko.com.hellosubway.fragment.SubwayMapFragment;
import subway.ggikko.com.hellosubway.view.MapFragment;
import subway.ggikko.com.hellosubway.viewpager.ViewPagerFragment;

public class MapActivity extends NavigationDrawerActivity{

    MapFragment mapFragment = new MapFragment();
    NavigationFragment navigationFragment = new NavigationFragment();
    SubwayMapFragment subwayMapFragment = new SubwayMapFragment();
    MadeByFragment madeByFragment = new MadeByFragment();
    LatLng ANIMATE_CAMERA_LOCATION =null;

    private static int FLAG_TUTORIAL = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("ggikko", "hello4");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }

    //지하철 정보 받음
    private List<String> getSubwayLocation() {
        List<String> result = new ArrayList<String>();
        AssetManager assetManager = getResources().getAssets();
        try {
            StringBuilder sb = getDataStringBuilder(assetManager);
            String jString = sb.toString();
            JSONObject jsonObject = new JSONObject(jString);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("DATA"));

            for(int i =0; i<jsonArray.length(); i++){
                result.add(jsonArray.getJSONObject(i).getString("STATION_NM").toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("ggikko", "hello");
        } catch (JSONException e) {
            e.printStackTrace();

            Log.e("ggikko", "hello1");
        }
        return result;
    }

    @NonNull
    private StringBuilder getDataStringBuilder(AssetManager assetManager) throws IOException {
        AssetManager.AssetInputStream ais = (AssetManager.AssetInputStream) assetManager.open("stationlocation.json");
        BufferedReader br = new BufferedReader(new InputStreamReader(ais));
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);
        int bufferSize = 1024 * 1024;
        char readBuf[] = new char[bufferSize];
        int resultSize = 0;
        while ((resultSize = br.read(readBuf)) != -1) {
            if (resultSize == bufferSize) {
                sb.append(readBuf);
            } else {
                for (int i = 0; i < resultSize; i++) {
                    //StringBuilder 에 append
                    sb.append(readBuf[i]);
                }
            }
        }
        return sb;
    }


    //위도, 경도 얻어옴 XPOINT_WGS , YPOINT_WGS
    public LatLng getLocation(String selectedLocationName){

        //찾는 역 위치 관리 리스트
        List<String> result = new ArrayList<String>();

        //초기값 설정
        Double xPosition =37.562020;
        Double yPosition =127.037239;

        boolean flag = false;

        //Asset 기본폴더 로드
        AssetManager assetManager = getResources().getAssets();
        try {
            StringBuilder sb = getDataStringBuilder(assetManager);
            String jString = sb.toString();
            JSONObject jsonObject = new JSONObject(jString);

            //JSON 공공 데이터
            JSONArray jsonArray = new JSONArray(jsonObject.getString("DATA"));

            for(int i =0; i<jsonArray.length(); i++){
                //해당 역 찾기
                if(selectedLocationName.equals(jsonArray.getJSONObject(i).getString("STATION_NM").toString())){
                    flag =true;
                    xPosition = Double.parseDouble(jsonArray.getJSONObject(i).getString("XPOINT_WGS").toString());
                    yPosition = Double.parseDouble(jsonArray.getJSONObject(i).getString("YPOINT_WGS").toString());
                }
            }

            //TODO : 역마다 위치 관리 매니저 만들기

            if(flag==false){
                mapFragment.moveSelectedCamera(new LatLng(37.561533, 127.037732));
                AlertDialogFragment alertDialog = new AlertDialogFragment(this);
                alertDialog.show(getSupportFragmentManager(), "My Alert");

                //showDialog(DIALOG_CUSTOM_ID);
            }

        } catch (IOException e) {

            Log.e("ggikko","gagagagaga1111111111111");
            e.printStackTrace();
        } catch (JSONException e) {
            Log.e("ggikko","gagagagaga");
            e.printStackTrace();
        }

        LatLng specificLocation = new LatLng(xPosition, yPosition);

        return specificLocation;
    }

    public void goToDefaultMap(){
        ANIMATE_CAMERA_LOCATION = new LatLng(37.561533, 127.037732);
        mapFragment.moveSelectedCamera(ANIMATE_CAMERA_LOCATION);
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {

        List<String> station = getSubwayLocation();

        return new ActionBarSearchHandler(this, new OnSearchListener() {

            //찾기 됬을 때
            @Override
            public void onSearched(String text) {
                ANIMATE_CAMERA_LOCATION = getLocation(text);

                mapFragment.moveSelectedCamera(ANIMATE_CAMERA_LOCATION);
            }
        })
                .enableAutoCompletion()
                .setAutoCompletionItems(station)
                .setAutoCompletionMode(ToolbarSearch.AutoCompletionMode.CONTAINS);
    }


    @Override
    public NavigationDrawerAccountsHandler getNavigationDrawerAccountsHandler() {
        return new NavigationDrawerAccountsHandler(this).addAccount("","",R.drawable.drawer_transparency,R.drawable.drawer_bg2);
    }

    @Override
    public NavigationDrawerAccountsMenuHandler getNavigationDrawerAccountsMenuHandler() {
        return null;
    }

    @Override
    public void onNavigationDrawerAccountChange(Account account) {

    }

    @Override
    public NavigationDrawerTopHandler getNavigationDrawerTopHandler() {
        NavigationDrawerTopHandler navigationDrawerTopHandler = new NavigationDrawerTopHandler(this)
                .addSection("인섭이")
                .addItem("지도",  mapFragment)
                .addItem("튜토리얼", new ViewPagerFragment())
                .addItem("경로검색",  navigationFragment)
                .addItem("지하철노선도", subwayMapFragment)
                .addItem("만든이", madeByFragment);

        return navigationDrawerTopHandler;
    }

    @Override
    public NavigationDrawerBottomHandler getNavigationDrawerBottomHandler() {
        return new NavigationDrawerBottomHandler(this).addItem("개발자에게 문의하기", click );
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] email = {"ggikko2@naver.com"};
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL,email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "인섭이에 관한 문의사항");
            startActivity(intent);
        }
    };

    @Override
    public boolean overlayActionBar() {
        return false;
    }

    @Override
    public boolean replaceActionBarTitleByNavigationDrawerItemTitle() {
        return true;
    }

    @Override
    public int defaultNavigationDrawerItemSelectedPosition() {

        SharedPreferences sharedPreferences = getSharedPreferences("init", Context.MODE_PRIVATE);
        String tempConstant = sharedPreferences.getString("firstTime", "0");
        FLAG_TUTORIAL = Integer.parseInt(tempConstant);

        if(firstInstalled()){
            SharedPreferences sharedPreferences2 = getSharedPreferences("init", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences2.edit();
            editor.putString("firstTime", "1" );
            editor.commit();
            FLAG_TUTORIAL =2;
        }else{
            FLAG_TUTORIAL=1;
        }

        return FLAG_TUTORIAL;
    }

    private boolean firstInstalled() {
        return FLAG_TUTORIAL ==0;
    }
}
