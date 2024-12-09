package com.example.mathapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//created the two buttons, then set the actions to these buttons
    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//initial code generated
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//setting actions to the two buttons, to show what happens when you place the buttons
        //initialize the button
        mTrueButton = (Button) findViewById(R.id.true_button);
        //set the listener after the initialization  of the above button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //some activity that gets activated when user will click a button
                //example a pop up to tell whether the answer is correct or incorrect
                    //make toast and show display, which it takes 3 parameters
                    Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();



            }
        });

        //initialize the button
        mFalseButton = (Button) findViewById(R.id.false_button);
        //set the listener after the initialization  of the above button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //some activity that gets activated when user will click a button
               //example a pop up to tell whether the answer is correct or incorrect
                    //make toast and show display, which it takes 3 parameters
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();

            }
        });







    }
}