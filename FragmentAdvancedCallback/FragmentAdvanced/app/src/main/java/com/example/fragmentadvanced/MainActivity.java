package com.example.fragmentadvanced;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

//implement the listener for the on check box
public class MainActivity extends FragmentActivity implements ReportFragment.OnCheckBoxSelectedListener {
    private static final String TAG = "MAIN_ACTIVITY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // code that will bring the segment to the layout
        // first you need fragment manager and get it
        FragmentManager fragmentManager = getSupportFragmentManager();

        // now create the segment object
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        //check if the segment is null or non-null
        if(fragment == null){
            // create a new fragment
            fragment = new ReportFragment();
            // start a transaction that will add this fragment into the activity
            fragmentManager.beginTransaction()
                    //where to add, what to add
                    .add(R.id.fragment_container, fragment)
                    //commit
                    .commit();

        }



    }



    //method outside on create
    //onCheckedbox method
    public void onCheckboxSelected() {
        Log.d(TAG, "CALLBACK was Called");

        //report fragment
        ReportFragment mreportFragment = (ReportFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        // checking for the non null and null value
        //since method may produce null, when not null it should be called
        if(mreportFragment != null) {
            mreportFragment.calledFromActivity();
        }

        //using the backstack to replace the report fragment with the detail fragment
        // code that will bring the segment to the layout
        // first you need fragment manager and get it
        FragmentManager fragmentManager = getSupportFragmentManager();

        // now create the segment object
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);


            // create a new fragment
            fragment = new DetailFragment();
            // start a transaction that will add this fragment into the activity
            fragmentManager.beginTransaction()
                    //where to add, what to add
                    .replace(R.id.fragment_container, fragment)
                    //add to backstack
                    .addToBackStack(null)
                    //commit
                    .commit();

    }
}