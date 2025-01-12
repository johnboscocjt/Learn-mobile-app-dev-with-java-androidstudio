package com.example.reportintent;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

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


        //override single fragment
        @Override
        protected Fragment createFragment(){
            return new ReportFragment();
        }
}