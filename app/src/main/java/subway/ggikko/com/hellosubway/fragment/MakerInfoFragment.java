package subway.ggikko.com.hellosubway.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import subway.ggikko.com.hellosubway.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MakerInfoFragment extends Fragment {


    public MakerInfoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maker_info, container, false);



        return view;

    }


}
