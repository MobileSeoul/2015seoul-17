package subway.ggikko.com.hellosubway.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.blunderer.materialdesignlibrary.fragments.ListViewFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import subway.ggikko.com.hellosubway.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SaturdayFragment extends ListViewFragment {

    private List<String> mObjects;
    private ArrayAdapter<String> mAdapter;


    @Override
    public ListAdapter getListAdapter() {
        mObjects = new ArrayList<>(Arrays.asList(
                getString(R.string.waingshiplee_name),
                getString(R.string.wangshiplee1_five),
                getString(R.string.wangshiplee1_six),
                getString(R.string.wangshiplee1_seven),
                getString(R.string.wangshiplee1_eight),
                getString(R.string.wangshiplee1_nine),
                getString(R.string.wangshiplee1_ten),
                getString(R.string.wangshiplee1_eleven),
                getString(R.string.wangshiplee1_twelve),
                getString(R.string.wangshiplee1_thirteen),
                getString(R.string.wangshiplee1_fourteen),
                getString(R.string.wangshiplee1_fifteen),
                getString(R.string.wangshiplee1_sixteen),
                getString(R.string.wangshiplee1_seventeen),
                getString(R.string.wangshiplee1_eightteen),
                getString(R.string.wangshiplee1_nineteen),
                getString(R.string.wangshiplee1_twelve),
                getString(R.string.wangshiplee1_twenty),
                getString(R.string.wangshiplee1_twentyone),
                getString(R.string.wangshiplee1_twentytwo),
                getString(R.string.wangshiplee1_twentythree)
        ));
        return (mAdapter = new ArrayAdapter<>(getActivity(), R.layout.listview_row, mObjects));
    }



    public SaturdayFragment() {
        // Required empty public constructor
    }
    public static SaturdayFragment newInstance() {
        SaturdayFragment fragment = new SaturdayFragment();
        return fragment;
    }

    @Override
    public boolean useCustomContentView() {
        return false;
    }

    @Override
    public int getCustomContentView() {
        return 0;
    }

    @Override
    public boolean pullToRefreshEnabled() {
        return false;
    }

    @Override
    public int[] getPullToRefreshColorResources() {
        return new int[0];
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }
}
