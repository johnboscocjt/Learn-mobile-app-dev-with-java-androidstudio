package com.example.fragmentbasics;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;


public class MainActivity extends FragmentActivity {
    //    the name for the logs on the terminal
    private static final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Inside onCreate");

        // code that will bring the segment to the layout
        // first you need fragment manager and get it
        FragmentManager fragmentManager = getSupportFragmentManager();

        // now create the segment object
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        //check if the segment is null or non-null
        if(fragment == null){
            // create a new fragment
            fragment = new BasicFragment();
            // start a transaction that will add this fragment into the activity
            fragmentManager.beginTransaction()
                    //where to add, what to add
                    .add(R.id.fragment_container, fragment)
                    //commit
                    .commit();

        }


    }


    // Other methods related to the lifecycle of an activity in java android studio development
    @Override
    protected void onStart(){
        //use super to override the onStart method
        super.onStart();
        Log.d(TAG, "Inside onStart");
    }

    @Override
    protected void onPause(){
        //use super to override the onPause method
        super.onPause();
        Log.d(TAG, "Inside onPause");
    }

    @Override
    protected void onResume(){
        //use super to override the onResume method
        super.onResume();
        Log.d(TAG, "Inside onResume");
    }

    @Override
    protected void onStop(){
        //use super to override the onStop method
        super.onStop();
        Log.d(TAG, "Inside onStop");
    }

    @Override
    protected void onRestart(){
        //use super to override the onRestart method
        super.onRestart();
        Log.d(TAG, "Inside onRestart");
    }

    @Override
    protected void onDestroy(){
        //use super to override the onDestroy method
        super.onDestroy();
        Log.d(TAG, "Inside onDestroy");
    }

}