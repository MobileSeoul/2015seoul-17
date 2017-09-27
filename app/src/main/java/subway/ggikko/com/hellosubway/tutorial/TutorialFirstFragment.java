package subway.ggikko.com.hellosubway.tutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.github.clans.fab.FloatingActionButton;

import subway.ggikko.com.hellosubway.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TutorialFirstFragment extends Fragment {


    public TutorialFirstFragment() {
        // Required empty public constructor
    }

    public static Fragment getInstance(){
        TutorialFirstFragment tutorialFirstFragment = new TutorialFirstFragment();
        return tutorialFirstFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial_first, container, false);

        return view;
    }

}
