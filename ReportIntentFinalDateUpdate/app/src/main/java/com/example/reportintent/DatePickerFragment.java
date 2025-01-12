package com.example.reportintent;

import android.app.Activity;
import android.app.AlertDialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DatePickerFragment extends DialogFragment {
    //create a string, unique because we are going to use it to pass the date in intent
    public static final String EXTRA_DATE = "com.example.reportintent.date";

    private static final String ARG_DATE = "date";

    //create datepicker
    private DatePicker mDatePicker;

    //create a new instance
    public static DatePickerFragment newInstance(Date date){
        //create a bundle
        Bundle args = new Bundle();
        //put the date
        args.putSerializable(ARG_DATE, date);

        //create a new instance
        DatePickerFragment fragment = new DatePickerFragment();
        //set the arguments
        fragment.setArguments(args);
        return fragment;
    }


    // override the method, go use it in the reportfragment
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Date date = (Date) getArguments().getSerializable(ARG_DATE);

        //create a calender
        Calendar calender = Calendar.getInstance();

        //set the date
        calender.setTime(date);

        //get the year
        int year = calender.get(Calendar.YEAR);
        //get the month
        int month = calender.get(Calendar.MONTH);
        //get the day
        int day = calender.get(Calendar.DAY_OF_MONTH);

        //add view for the dat picker
        View v = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_date, null);

        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_date_picker);
        mDatePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity())
                //add date
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int year = mDatePicker.getYear();
                        int month = mDatePicker.getMonth();
                        int day = mDatePicker.getDayOfMonth();
                        Date date = new GregorianCalendar(year, month, day).getTime();
                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();
    }

    private void sendResult(int resultCode, Date date){
        if(getTargetFragment() == null){
            return;
        }

        //create a new intent
        Intent intent = new Intent();
        //put the extra
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
