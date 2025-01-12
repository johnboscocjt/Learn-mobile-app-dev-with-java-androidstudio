package com.example.reportintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.UUID;

public class ReportPagerActivity extends FragmentActivity {
    private static final String EXTRA_REPORT_ID = "com.example.reportintent.report_id";

    private ViewPager mViewPager;
    private List<MainReport> mReports;

    //create a new intent
    public static Intent newIntent(Context packageContext, UUID reportId){
        Intent intent = new Intent(packageContext, ReportPagerActivity.class);
        intent.putExtra(EXTRA_REPORT_ID, reportId);
        return intent;
    }

    //override onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState){
        //call the super class
        super.onCreate(savedInstanceState);
        //set the content view
        setContentView(R.layout.activity_report_pager);

        //get the report id
        UUID reportId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_REPORT_ID);

        //get the view pager
        mViewPager = (ViewPager) findViewById(R.id.activity_report_pager_view_pager);

        //get the reports
        mReports = ReportStore.get(this).getReports();

        //get the fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //set the adapter
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                MainReport report = mReports.get(position);
                return ReportFragment.newInstance(report.getId());
            }

            @Override
            public int getCount() {
                return mReports.size();
            }
        });

        //loop through the reports
        for (int i = 0; i < mReports.size(); i++){
            if (mReports.get(i).getId().equals(reportId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }


    }

}
