package subway.ggikko.com.hellosubway.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.blunderer.materialdesignlibrary.activities.ViewPagerWithTabsActivity;
import com.blunderer.materialdesignlibrary.handlers.ActionBarHandler;
import com.blunderer.materialdesignlibrary.handlers.ViewPagerHandler;

import java.util.List;

import subway.ggikko.com.hellosubway.R;
import subway.ggikko.com.hellosubway.fragment.HolidayFragment;
import subway.ggikko.com.hellosubway.fragment.SaturdayFragment;
import subway.ggikko.com.hellosubway.fragment.WeekdayFragment;

public class TimeManageActivity extends ViewPagerWithTabsActivity {

    @Override
    protected boolean expandTabs() {
        return true;
    }

    @Override
    protected ActionBarHandler getActionBarHandler() {
        return null;
    }

    @Override
    public ViewPagerHandler getViewPagerHandler() {
        return new ViewPagerHandler(this).addPage("평일", WeekdayFragment.newInstance())
                .addPage("토요일", SaturdayFragment.newInstance())
                .addPage("공휴일", HolidayFragment.newInstance());
    }

    @Override
    public int defaultViewPagerPageSelectedPosition() {
        return 3;
    }
}
