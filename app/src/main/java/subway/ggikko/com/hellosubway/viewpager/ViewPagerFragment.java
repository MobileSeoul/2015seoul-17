package subway.ggikko.com.hellosubway.viewpager;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

import subway.ggikko.com.hellosubway.tutorial.TutorialFirstFragment;
import subway.ggikko.com.hellosubway.tutorial.TutorialFourthFragment;
import subway.ggikko.com.hellosubway.tutorial.TutorialSecondFragment;
import subway.ggikko.com.hellosubway.tutorial.TutorialThridFragment;


public class ViewPagerFragment
        extends com.blunderer.materialdesignlibrary.fragments.ViewPagerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(getActivity())
                .addPage("튜토리얼", TutorialFirstFragment.getInstance())
                .addPage("튜토리얼", TutorialSecondFragment.getInstance())
                .addPage("튜토리얼", TutorialThridFragment.getInstance())
                .addPage("튜토리얼", TutorialFourthFragment.getInstance());
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 0;
    }


    @Override
    public boolean showViewPagerIndicator() {
        return true;
    }

    @Override
    public boolean replaceActionBarTitleByViewPagerPageTitle() {
        return true;
    }

}