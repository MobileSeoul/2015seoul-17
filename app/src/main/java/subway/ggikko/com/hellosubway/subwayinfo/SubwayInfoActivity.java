package subway.ggikko.com.hellosubway.subwayinfo;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.activity.TimeManageActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

public class SubwayInfoActivity extends AppCompatActivity implements View.OnClickListener {


    //TODO : 0261102081 역사
    //0263115401 분실물
    //이메일
    private Toolbar toolbar;

    ImageView imageView;
    PhotoViewAttacher mAttacher;

    private static String stationNumber = "tel:02-6110-2081";
    private static String lostStationNumber = "tel:02-6311-5401";

    RadioGroup rdogroup_floor, rdogroup_loc;

    RadioButton btn_f1, btn_f2, btn_b1, btn_b2, btn_b4, btn_b5, btn_char, btn_esc, btn_ele, btn_lift, btn_rest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_info);


        imageView = (ImageView) findViewById(R.id.image_photo);
        mAttacher = new PhotoViewAttacher(imageView);

        rdogroup_floor = (RadioGroup) findViewById(R.id.rdogroup_floor);
        rdogroup_loc = (RadioGroup) findViewById(R.id.rdogroup_loc);

        btn_f1 = (RadioButton) findViewById(R.id.btn_f1);
        btn_f2 = (RadioButton) findViewById(R.id.btn_f2);

        btn_b1 = (RadioButton) findViewById(R.id.btn_b1);
        btn_b2 = (RadioButton) findViewById(R.id.btn_b2);
        btn_b4 = (RadioButton) findViewById(R.id.btn_b4);
        btn_b5 = (RadioButton) findViewById(R.id.btn_b5);

        btn_char = (RadioButton) findViewById(R.id.btn_char);
        btn_esc = (RadioButton) findViewById(R.id.btn_esc);
        btn_ele = (RadioButton) findViewById(R.id.btn_ele);
        btn_lift = (RadioButton) findViewById(R.id.btn_lift);
        btn_rest = (RadioButton) findViewById(R.id.btn_rest);

        btn_f1.setOnClickListener(this);
        btn_f2.setOnClickListener(this);
        btn_b1.setOnClickListener(this);
        btn_b2.setOnClickListener(this);
        btn_b4.setOnClickListener(this);
        btn_b5.setOnClickListener(this);
        btn_char.setOnClickListener(this);
        btn_esc.setOnClickListener(this);
        btn_ele.setOnClickListener(this);
        btn_lift.setOnClickListener(this);
        btn_rest.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.toolbartextcolor));
        toolbar.getSolidColor();
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.toolbartextcolor));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_subway_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.call_station) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(stationNumber));
            startActivity(intent);

            return true;
        }

        if (id == R.id.call_lostitem) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(lostStationNumber));
            startActivity(intent);
            return true;
        }

        if (id == R.id.call_time) {
            Intent intent = new Intent(SubwayInfoActivity.this, TimeManageActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        int selectedFloor = rdogroup_floor.getCheckedRadioButtonId();
        int selectedLoc = rdogroup_loc.getCheckedRadioButtonId();

        if (selectedFloor == R.id.btn_b1) {

            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b1_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b1_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b1_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b1_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b1_escal);
                imageView.setImageDrawable(b1);
            }
            

            Log.e("ggikko", "b1");
        }
        if (selectedFloor == R.id.btn_b2) {

            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b2_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b2_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b2_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b2_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b2_escal);
                imageView.setImageDrawable(b1);
            }
        }
        if (selectedFloor == R.id.btn_b4) {

            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b4_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b4_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b4_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b4_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b4_escal);
                imageView.setImageDrawable(b1);
            }
        }
        if (selectedFloor == R.id.btn_b5) {

            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b5_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b5_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b5_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b5_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.b5_escal);
                imageView.setImageDrawable(b1);
            }
            Log.e("ggikko", "b5");
        }
        if (selectedFloor == R.id.btn_f1) {
            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f1_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f1_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f1_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f1_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f1_escal);
                imageView.setImageDrawable(b1);
            }
            Log.e("ggikko", "f1");
        }
        if (selectedFloor == R.id.btn_f2) {
            if(btn_rest.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f2_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_lift.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f2_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_char.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f2_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_ele.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f2_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_esc.isChecked()) {
                Drawable b1 = getResources().getDrawable(R.drawable.f2_escal);
                imageView.setImageDrawable(b1);
            }

            Log.e("ggikko", "f2");
        }

        if (selectedLoc == R.id.btn_ele) {

            if(btn_b1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b1_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_b2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b2_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_b4.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b4_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_b5.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b5_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_f1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f1_ele);
                imageView.setImageDrawable(b1);
            }
            if(btn_f2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f2_ele);
                imageView.setImageDrawable(b1);
            }

            Log.e("ggikko", "ele");
        }

        if (selectedLoc == R.id.btn_esc) {

            if(btn_b1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b1_escal);
                imageView.setImageDrawable(b1);
            }
            if(btn_b2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b2_escal);
                imageView.setImageDrawable(b1);
            }
            if(btn_b4.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b4_escal);
                imageView.setImageDrawable(b1);
            }
            if(btn_b5.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b5_escal);
                imageView.setImageDrawable(b1);
            }
            if(btn_f1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f1_escal);
                imageView.setImageDrawable(b1);
            }
            if(btn_f2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f2_escal);
                imageView.setImageDrawable(b1);
            }


            Log.e("ggikko", "esc");
        }

        if (selectedLoc == R.id.btn_char) {

            if(btn_b1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b1_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_b2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b2_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_b4.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b4_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_b5.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b5_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_f1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f1_charger);
                imageView.setImageDrawable(b1);
            }
            if(btn_f2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f2_charger);
                imageView.setImageDrawable(b1);
            }
            Log.e("ggikko", "char");
        }

        if (selectedLoc == R.id.btn_rest) {

            if(btn_b1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b1_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_b2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b2_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_b4.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b4_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_b5.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b5_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_f1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f1_restroom);
                imageView.setImageDrawable(b1);
            }
            if(btn_f2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f2_restroom);
                imageView.setImageDrawable(b1);
            }

            Log.e("ggikko", "rest");
        }

        if (selectedLoc == R.id.btn_lift) {

            if(btn_b1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b1_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_b2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b2_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_b4.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b4_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_b5.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.b5_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_f1.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f1_lift);
                imageView.setImageDrawable(b1);
            }
            if(btn_f2.isChecked()){
                Drawable b1 = getResources().getDrawable(R.drawable.f2_lift);
                imageView.setImageDrawable(b1);
            }

            Log.e("ggikko", "lift");
        }
    }


}
