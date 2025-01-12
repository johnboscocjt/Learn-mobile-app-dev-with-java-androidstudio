package com.example.reportintent;

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

public class ReportFragment extends Fragment {
    // report that created earlier in the mainreport==report
    private MainReport mReport;

    //variable to inflate fragment in editetxt xml
    private EditText mTitleField;

    //new widget from xml, make use of the widgets on oncreate method
    private Button mDateButton;

    private CheckBox mResolvedCheckBox;




    @Override
    public void onCreate(Bundle savedInstanceState){
         super.onCreate(savedInstanceState);

         //instantiate the variable
        mReport = new MainReport();

    }

    //fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //create a view
        View v = inflater.inflate(R.layout.fragment_report, container, false);

        //inflating fagment to xml in edittext
        mTitleField = (EditText) v.findViewById(R.id.report_title);
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
        mDateButton.setEnabled(false);

        //use resolved
        mResolvedCheckBox = (CheckBox) v.findViewById(R.id.report_resolved);
        mResolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mReport.setResolved(isChecked);
            }
        });

        return v;
    }


}
