package subway.ggikko.com.hellosubway.view;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.subwayinfo.NeedUpdatedActivity;
import subway.ggikko.com.hellosubway.subwayinfo.SubwayInfoActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements GoogleMap.OnMarkerClickListener {

    static final LatLng WangShipRi = new LatLng(37.561533, 127.037732);

    LatLng tempLocation = new LatLng(37.561533, 127.037732);

    LatLng numberOne = new LatLng(37.561599, 127.035089);
    LatLng numbertwo = new LatLng(37.561577, 127.035409);
    LatLng numberthree = new LatLng(37.561213, 127.035915);
    LatLng numberfour = new LatLng(37.561420, 127.036909);
    LatLng numberfive = new LatLng(37.561363, 127.037544);
    LatLng numbersix = new LatLng(37.561114, 127.039272);
    LatLng numbersixdashone = new LatLng(37.560910, 127.037714);

    LatLng numberseven = new LatLng(37.561048, 127.036184);
    LatLng numbereight = new LatLng(37.560949, 127.035881);
    LatLng numbernine = new LatLng(37.560665, 127.035321);
    LatLng numberten = new LatLng(37.560991, 127.034938);
    LatLng numbereleven = new LatLng(37.561259, 127.034953);
    LatLng numbertwelve = new LatLng(37.561272, 127.038132);
    LatLng numberthirteen = new LatLng(37.561366, 127.038935);

    LatLng numberThreeIcon = new LatLng(37.561344, 127.036042);
    LatLng numbersixdashoneIcon = new LatLng(37.560940, 127.037791);
    LatLng numbersixIcon = new LatLng(37.560914, 127.039545);


    GoogleMap map;
    Handler handler;
    View view;
    Bundle bundle;
    Marker marker = null;

    public MapFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_map, container, false);

        MapView mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        map = mapView.getMap();
        map.setOnMarkerClickListener(this);


        //서울에 기본 마커 추가
        //   Marker seoul = map.addMarker(new MarkerOptions().position(SEOUL).title("Seoul"));

        //맵 무빙 카메라 테스트
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(WangShipRi, 18));
        // 카메라 줌인
        CameraPosition cameraPosition = new CameraPosition.Builder().target(WangShipRi).tilt(45).zoom(17).bearing(60).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        marker = map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.location_insubway)).position(WangShipRi));

        setAddMarker();

        return view;
    }

    private void setAddMarker() {
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_01)).position(numberOne));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_02)).position(numbertwo));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_03)).position(numberthree));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_04)).position(numberfour));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_05)).position(numberfive));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_06)).position(numbersix));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_61)).position(numbersixdashone));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_07)).position(numberseven));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_08)).position(numbereight));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_09)).position(numbernine));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_10)).position(numberten));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_11)).position(numbereleven));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_12)).position(numbertwelve));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.exitnumber_13)).position(numberthirteen));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.threeicon)).position(numberThreeIcon));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.sixdashoneicon)).position(numbersixdashoneIcon));
        map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.sixicon)).position(numbersixIcon));
    }

    public void replacePlace(){
        this.tempLocation = new LatLng(37.561533, 127.037732);
    }


    public void moveSelectedCamera(LatLng location) {

        tempLocation = location;
        if (location != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 17));
            // 카메라 줌인
            map.animateCamera(CameraUpdateFactory.zoomTo(17), 1000, null);

            marker.remove();
            marker = map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.location_insubway)).position(location));

        }
        if(location == null){
            this.tempLocation =  new LatLng(37.561533, 127.037732);
            marker.remove();
            marker = map.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.location_insubway)).position(location));
        }
    }

    @Override
    public boolean onMarkerClick(Marker onMarker) {

        Log.e("ggikko", String.valueOf(tempLocation.latitude) + " : " + String.valueOf(tempLocation.longitude));

        // TODO : 마커별로 찍어줘야함

        if (tempLocation.latitude == 37.561533 && tempLocation.longitude == 127.037732) {
            Intent intent = new Intent(getActivity(), SubwayInfoActivity.class);
            startActivity(intent);

        } else {
            Intent intent = new Intent(getActivity(), NeedUpdatedActivity.class);
            startActivity(intent);

        }
        return false;
    }
}
