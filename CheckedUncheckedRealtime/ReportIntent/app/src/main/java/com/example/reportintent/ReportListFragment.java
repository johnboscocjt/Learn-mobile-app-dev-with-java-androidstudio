package com.example.reportintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportListFragment extends Fragment {

    private RecyclerView mReportRecyclerView;

    //access the adapter created
    private ReportAdapter mAdapter;

    //override onCreateView method
    //inflate the layout
    //return the view
    //initialize the recycler view
    //return the view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate the layout
        View view = inflater.inflate(R.layout.fragment_report_list, container, false);

        //initialize the recycler view
        mReportRecyclerView = (RecyclerView) view
                .findViewById(R.id.report_recycler_view);
        //set the layout manager
        mReportRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //update ui, implement later, abstract method
        updateUI();

        //return the view
        return view;
    }

    //override onResume method
    public void onResume(){
        super.onResume();
        //update the ui
        updateUI();
    }

    //update the ui implementation, updateUI();
    private void updateUI(){
        //get the report store
        ReportStore reportStore = ReportStore.get(getActivity());
        //get the reports
        List<MainReport> reports = reportStore.getReports();

        //check if the adapter is null
        if (mAdapter == null) {

            //create a new adapter
            mAdapter = new ReportAdapter(reports);
            //set the adapter
            mReportRecyclerView.setAdapter(mAdapter);
        }else {
            //notify the adapter
            mAdapter.notifyDataSetChanged();
        }
    }




    // create a view holder class
    private class ReportHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private MainReport mReport;
        //create a text view
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mResolvedCheckBox;

        //constructor
        public ReportHolder(View itemView){
            super(itemView);
            //set the onclick listener
            itemView.setOnClickListener(this);

            //initialize the text view
            mTitleTextView = (TextView)
                    itemView.findViewById(R.id.list_item_report_title_text_view);

            mDateTextView = (TextView)
                    itemView.findViewById(R.id.list_item_report_date_text_view);

            mResolvedCheckBox = (CheckBox)
                    itemView.findViewById(R.id.list_report_resolved_check_box);
        }

        //listener for the checkbox
        @Override
            //        public void onClick(View v){
            //            Toast.makeText(getActivity(),
            //                    mReport.getTitle() + " clicked!", Toast.LENGTH_SHORT)
            //                    .show();
            //        }
            //start the report activity
        public void onClick(View v){
            //start the report activity
            //Intent intent = new Intent(getActivity(), MainActivity.class);
            //pass the id using extra when sending the intent data
            Intent intent = MainActivity.newIntent(getActivity(), mReport.getId());
            startActivity(intent);
        }




        //bind the report
        private void bindReport(MainReport report){
            //set the report
            mReport = report;
            //set the title
            mTitleTextView.setText(mReport.getTitle());
            //set the date
            mDateTextView.setText(mReport.getDate().toString());
            //set the checkbox
            mResolvedCheckBox.setChecked(mReport.isResolved());
        }

    }





    // create an adapter class as a inner class
    private class ReportAdapter extends RecyclerView.Adapter<ReportHolder>{
        //create a list of reports
            private List<MainReport> mReport;

        //constructor
        public ReportAdapter(List<MainReport> reports){
            mReport = reports;
        }

        //override onCreateViewHolder method
        @Override
        public ReportHolder onCreateViewHolder(ViewGroup parent, int viewType){
            //create a layout inflater
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            //inflate the layout
            View view = layoutInflater.inflate(R.layout.list_item_report, parent, false);
            //return the view
            return new ReportHolder(view);
        }

        //override onBindViewHolder method
        @Override
        public void onBindViewHolder(ReportHolder holder, int position){
            //get the report
            MainReport report = mReport.get(position);
            //set the title
            //holder.mTitleTextView.setText(report.getTitle());

            holder.bindReport(report);
        }

        //override getItemCount method
        @Override
        public int getItemCount(){
            return mReport.size();
        }
    }









}
