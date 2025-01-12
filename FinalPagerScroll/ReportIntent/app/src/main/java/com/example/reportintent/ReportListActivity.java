package com.example.reportintent;

import androidx.fragment.app.Fragment;

public class ReportListActivity extends SingleFragmentActivity{
    //override single fragment
    @Override
    protected Fragment createFragment(){
        return new ReportListFragment();
    }
}
