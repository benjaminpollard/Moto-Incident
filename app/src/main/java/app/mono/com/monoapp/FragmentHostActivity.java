package app.mono.com.monoapp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Controller.ReportController;
import Fragments.DescriptionFragment;
import Fragments.DriverInfoFragment;
import Fragments.GalleryFragment;
import Fragments.LocationFragment;
import Helpers.ModelBuilderHelper;
import Models.LocationModel;

public class FragmentHostActivity extends AppCompatActivity implements LocationFragment.OnLocationFragmentSubmitted , DriverInfoFragment.OnDriverInfoFragmentInteractionListener
 , DescriptionFragment.OnDescriptionFragmentInteractionListener {

    public static final String SET_PAGE = "PAGEE";
    public static final String SET_EXTRA = "extrasforfragmenthost";
    public static final String INCDIENT_TYPE_THEIFT = "INCDIENT_TYPE_THEIFT";
    public static final String INCDIENT_TYPE_COLLSION = "INCDIENT_TYPE_COLLSION";
    public static final String INCDIENT_TYPE_CTYLE = "INCDIENT_TYPE_CTYLE";
    public static final String INCDIENT_TYPE_BREAKDOWN = "INCDIENT_TYPE_BREAKDOWN";

    private ReportController controller;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);


        Intent intent = getIntent();
        String incidentType = intent.getStringExtra(SET_EXTRA);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),GetFragmentsForIncidentType(incidentType));

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(intent.getIntExtra(SET_PAGE,0));



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private List<Fragment> GetFragmentsForIncidentType(String incidentType) {

        List<Fragment> fragments = new ArrayList<Fragment>();
        //all the same but most lightly will change in time
        switch (incidentType)
        {
            case INCDIENT_TYPE_THEIFT :
            case INCDIENT_TYPE_COLLSION :
            case INCDIENT_TYPE_CTYLE :
            case INCDIENT_TYPE_BREAKDOWN :
                fragments.add(DescriptionFragment.newInstance());
                fragments.add(DriverInfoFragment.newInstance());
                fragments.add(LocationFragment.newInstance());
                break;

            default:
                return fragments;
        }
        return fragments;
    }
    private int GetFragmentsStarttingPos(String incidentType) {

       int startingPos = 0;
        //all the same but most lightly will change in time
        switch (incidentType)
        {
            case INCDIENT_TYPE_THEIFT :
                break;
            case INCDIENT_TYPE_COLLSION :
                startingPos = 1;
                break;
            case INCDIENT_TYPE_CTYLE :
                startingPos = 2;
                break;
            case INCDIENT_TYPE_BREAKDOWN :
                startingPos = 3;
                break;

            default:
             break;
        }
        return startingPos;
    }

    @Override
    public void SummitLocation(LocationModel loc) {
        controller.AddLocationModelReport(ModelBuilderHelper.locationModelBuilder(loc));
    }

    @Override
    public void onDriveInfoFragmentInteraction(String driverInfoName, String driverInfoReg, String driverInfoVec, String driverInfoModel, String driverInfoRange, String driverInfoInfo) {
        controller.AddDriverInformasionReport(ModelBuilderHelper.DescriptionModelBuilder(driverInfoName,driverInfoReg,driverInfoModel,driverInfoVec,driverInfoRange,driverInfoInfo));
    }

    @Override
    public void onDescriptionFragmentInteraction(String desc) {
        controller.AddDescriptionToReport(ModelBuilderHelper.DescriptionModelBuilder(desc));
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> fragments;

        public SectionsPagerAdapter(FragmentManager fm, List<Fragment> _fragments) {
            super(fm);
            fragments = _fragments;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
         return "";
        }
    }
}
