package subway.ggikko.com.hellosubway.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import subway.ggikko.com.hellosubway.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubwayMapFragment extends Fragment {

    ImageView imageView;
    PhotoViewAttacher mAttacher;

    public SubwayMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_subway_map, container, false);

        imageView = (ImageView) view.findViewById(R.id.image_subway_photo);
        BitmapDrawable drawable = (BitmapDrawable) getContext().getResources().getDrawable(R.drawable.linemap_seoulmetro);
        Bitmap img = drawable.getBitmap();
        imageView.setImageBitmap(img);
        mAttacher = new PhotoViewAttacher(imageView);

       // ((BitmapDrawable)imageView.getDrawable()).getBitmap().recycle();
        return view;
    }


}
