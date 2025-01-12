package com.example.reportintent;

import java.util.Date;
import java.util.UUID;

public class MainReport {
    // making sure ech report has unique id
    private UUID mId;
    private String mTitle;

    private Date mDate;
    private boolean mResolved;

    //constructor for the class
    public MainReport(){
        // assign mId to unique id from UUID class
        mId = UUID.randomUUID();

        //also initialize date
        mDate = new Date();

    }

    //some getters and setters
    public UUID getId(){
        return mId;
    }

    public String getTitle(){
        return mTitle;
    }
    public void setTitle(String title){
        mTitle = title;
    }


    public Date getDate() {
        return mDate;
    }
    public void setDate(Date mDate) {
        this.mDate = mDate;
    }


    public boolean isResolved() {
        return mResolved;
    }
    public void setResolved(boolean mResolved) {
        this.mResolved = mResolved;
    }
}
