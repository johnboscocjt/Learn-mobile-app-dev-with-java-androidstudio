package com.example.fragmentbasics;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BasicFragment extends Fragment {
    //    the name for the logs on the terminal
    private static final String TAG = "BASIC_FRAGMENT";

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "Inside onCreateView");

        View v = inflater.inflate(R.layout.fragment_basic, container, false);

        // return the view
        return v;

    }



    // Other methods related to the lifecycle of a fragment in java android studio development
    @Override
    public void onStart(){
        //use super to override the onStart method
        super.onStart();
        Log.d(TAG, "Inside onStart");
    }

    @Override
    public void onPause(){
        //use super to override the onPause method
        super.onPause();
        Log.d(TAG, "Inside onPause");
    }

    @Override
    public void onResume(){
        //use super to override the onResume method
        super.onResume();
        Log.d(TAG, "Inside onResume");
    }

    @Override
    public void onStop(){
        //use super to override the onStop method
        super.onStop();
        Log.d(TAG, "Inside onStop");
    }

    @Override
    public void onDestroy(){
        //use super to override the onDestroy method
        super.onDestroy();
        Log.d(TAG, "Inside onDestroy");
    }

    @Override
    public void onDestroyView(){
        //use super to override the onDestroyView method
        super.onDestroyView();
        Log.d(TAG, "Inside onDestroyView");
    }

    @Override
    public void onDetach(){
        //use super to override the onDetach method
        super.onDetach();
        Log.d(TAG, "Inside onDetach");
    }

    @Override
    public void onAttach(@NonNull Context context){
        //use super to override the onAttach method
        super.onAttach(context);
        Log.d(TAG, "Inside onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        //use super to override the onCreate method
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Inside onCreate");
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        //use super to override the onViewCreated method
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "Inside onViewCreated");
    }


// same as onViewCreated
//    @Override
//    public void onActivityCreated(Bundle savedInstanceState){
//        //use super to override the onActivityCreated method
//        super.onActivityCreated(savedInstanceState);
//        Log.d(TAG, "Inside onActivityCreated");
//    }


}

