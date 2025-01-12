package com.example.fragmentadvanced;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.fragment.app.Fragment;

public class ReportFragment extends Fragment {
    // logic for the fragment
    private static final String TAG = "REPORT_FRAGMENT";

    // variable to make use of the check box you have on the layout
    private CheckBox mCheckBox;

    // variable to use the callback, variable of type interface
    OnCheckBoxSelectedListener mCallback;

    // set the interface
    public interface OnCheckBoxSelectedListener {
        //implements a method
        public void onCheckboxSelected();
    }

    // first implement the onCreateView method
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        // use check box in oncreateview and attach a listener to it
        mCheckBox = (CheckBox) v.findViewById(R.id.report_checked);
        //anonymous function
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // use the callback here
                mCallback.onCheckboxSelected();
            }
        });


        return v;
    }

    //method in this fragment, go call this method from activity
    public void calledFromActivity(){
        Log.d(TAG, "Called from Activity");
    }

    //fix bug on after checking the box
    @Override
    public void onAttach(Context activity){
        super.onAttach(activity);
            // check if attached the interface directly or not
            try{
                // converted the context into the right type
                mCallback = (OnCheckBoxSelectedListener) activity;

            }catch (ClassCastException e){
                throw new ClassCastException(activity.toString() + "should implement OnCheckboxSelectedListener");
            }

    }
}
