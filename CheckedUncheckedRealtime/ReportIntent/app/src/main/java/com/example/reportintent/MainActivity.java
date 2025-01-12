package com.example.reportintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.UUID;

//public class MainActivity extends FragmentActivity {
public class MainActivity extends SingleFragmentActivity {

        //    @Override
        //    protected void onCreate(Bundle savedInstanceState) {
        //        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_fragment);
        //
        //        //use fragment manager
        //        FragmentManager fm = getSupportFragmentManager();
        //        //use the fragment, id of the fragment container
        //        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        //
        //        //check if the segment is null or non-null
        //        if(fragment == null){
        //            // create a new fragment
        //            fragment = new ReportFragment();
        //            // start a transaction that will add this fragment into the activity
        //            fm.beginTransaction()
        //                    //where to add, what to add
        //                    .add(R.id.fragment_container, fragment)
        //                    //commit
        //                    .commit();
        //
        //        }
        //
        //    }

        // the key for the extra in the intent
        private static final String EXTRA_REPORT_ID = "com.example.reportintent.report_id";

        //create a new intent where to use extra to pass the data/info
        public static Intent newIntent(Context packageContext, UUID reportId){
            //create a new intent
            Intent intent = new Intent(packageContext, MainActivity.class);
            //put the extra
            intent.putExtra(EXTRA_REPORT_ID, reportId);
            return intent;
        }



        //override single fragment
        @Override
        protected Fragment createFragment(){
            //return new ReportFragment();

            //return new ReportListFragment();
            UUID reportId = (UUID) getIntent()
                    .getSerializableExtra(EXTRA_REPORT_ID);
            return ReportFragment.newInstance(reportId);
        }
}