package subway.ggikko.com.hellosubway.tutorial;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import subway.ggikko.com.hellosubway.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialThridFragment extends Fragment {


    public TutorialThridFragment() {
        // Required empty public constructor
    }

    public static Fragment getInstance(){
        TutorialThridFragment tutorialThridFragment = new TutorialThridFragment();
        return tutorialThridFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutorial_thrid, container, false);
    }


}
