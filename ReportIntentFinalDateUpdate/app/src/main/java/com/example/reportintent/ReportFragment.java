package com.example.reportintent;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;
import java.util.UUID;

public class ReportFragment extends Fragment {
    private static final String ARG_REPORT_ID = "report_id";

    private static final String DIALOG_DATE = "DialogDate";

    public static final int REQUEST_DATE = 0;

    // report that created earlier in the mainreport==report
    private MainReport mReport;

    //variable to inflate fragment in editetxt xml
    private EditText mTitleField;

    //new widget from xml, make use of the widgets on oncreate method
    private Button mDateButton;

    private CheckBox mResolvedCheckBox;



    public static ReportFragment newInstance(UUID reportId){
        //inside static method  ,create a bundle
        Bundle args = new Bundle();
        args.putSerializable(ARG_REPORT_ID, reportId);

        ReportFragment fragment = new ReportFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);

         //instantiate the variable
        // mReport = new MainReport();

        //        UUID reportId = (UUID) getActivity().getIntent()
        //                .getSerializableExtra(MainActivity.EXTRA_REPORT_ID);

        //get the report id
        UUID reportId = (UUID) getArguments().getSerializable(ARG_REPORT_ID);
        mReport = ReportStore.get(getActivity()).getReports(reportId);

    }

    //fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //create a view
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        //inflating fragment to xml in edittext
        mTitleField = (EditText) v.findViewById(R.id.report_title);

        //set the value of the field
        mTitleField.setText(mReport.getTitle());

        //add a listener for event handling
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //set the value of the field
                mReport.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //use date
        mDateButton = (Button) v.findViewById(R.id.report_date);
        mDateButton.setText(mReport.getDate().toString());
        //mDateButton.setEnabled(false);
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentManager fm = getFragmentManager();
                //DatePickerFragment dialog = new DatePickerFragment();
                DatePickerFragment dialog = DatePickerFragment.newInstance(mReport.getDate());
                //set the target fragment
                dialog.setTargetFragment(ReportFragment.this, REQUEST_DATE);
                dialog.show(fm, DIALOG_DATE);
            }
        });



        //use resolved
        mResolvedCheckBox = (CheckBox) v.findViewById(R.id.report_resolved);

        //set the value of the field
        mResolvedCheckBox.setChecked(mReport.isResolved());

        mResolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mReport.setResolved(isChecked);
            }
        });

        return v;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode != getActivity().RESULT_OK){
            return;
        }

        if (requestCode == REQUEST_DATE){
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mReport.setDate(date);
            mDateButton.setText(mReport.getDate().toString());
        }
    }



}
