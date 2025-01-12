package com.example.reportintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// store of multiple elements
public class ReportStore {
    // s to show its a static variable
    private static ReportStore sReportStore;

    //something to store
    private List<MainReport> mReport;


    //method that returns, constructor called from outside
    public static ReportStore get(Context context){
        //checking
        if(sReportStore == null){
            // you can create only one object
            sReportStore = new ReportStore(context);
        }
        return sReportStore;
    }

    private ReportStore(Context context){
        mReport = new ArrayList<>();

        for (int i=0; i < 100; i++){
            MainReport report = new MainReport();
            report.setTitle("Report #" + i);
            report.setResolved(i%2 == 0);
            mReport.add(report);
        }

    }

    //setter and getter
    public List<MainReport> getReports(){
        return mReport;
    }
    public MainReport getReports(UUID id){
        for(MainReport report : mReport){
            if (report.getId().equals(id)){
                return report;
            }
        }
        //otherwise
        return null;
    }

}
