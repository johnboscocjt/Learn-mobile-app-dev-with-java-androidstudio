package com.example.mathapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheatActivity extends AppCompatActivity {
    // tag that this is cheat activity and the layout to be used
    private static final String TAG = "CheatActivity";

    // define the variable called CHEAT_INDEX with value CHEAT_INDEX
    private static final String CHEAT_INDEX = "CHEAT_INDEX";

    // boolean variable isCheated equal to false to check if the user has cheated or not
    private boolean isCheated = false;

    private static final String IS_CHEATED = "IS_CHEATED";


    // when this intent is created it will also have the value i
    // passing the value integer i from the parent activity class to the cheat activity class
    public static Intent newIntent(Context context, int i ){
        // Creating a new intent object and returning it
        Intent intent = new Intent(context, CheatActivity.class);

        // pass the some value to the intent we use intent extras
        intent.putExtra(CHEAT_INDEX, i);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Log.d(TAG, "onCreate(Bundle) called in CheatActivity");

        // make use  of the value passed from the parent activity class to the cheat activity class
        int i = getIntent().getIntExtra(CHEAT_INDEX, -999);
        // Log message for received value i
        Log.d(TAG, "The value of i is: " + i);
        // Checking if cheated or not
        if(i >= 0) {
            isCheated = true;
        }







        // back to the home/main page which is a new activity apart from the cheat activity on the on create method, creating a new intent to take me to the home page
        Button cheatButton = findViewById(R.id.btn_main);
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheatActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }



    // call the local method to create answer result which can then be used to send data back to the parent activity
    public void setAnswerResult(boolean b){
        // create a new intent object
        Intent i = new Intent();
        // put the value of isCheated into the intent object
        i.putExtra(IS_CHEATED, b);
        // set the result of the activity to be RESULT_OK
        setResult(RESULT_OK, i);
    }


    //Other methods related to the lifecycle of an activity in java android studio development
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