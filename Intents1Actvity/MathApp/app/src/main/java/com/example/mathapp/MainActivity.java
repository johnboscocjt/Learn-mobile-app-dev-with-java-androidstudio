package com.example.mathapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//created the two buttons, then set the actions to these buttons
    private Button mTrueButton;
    private Button mFalseButton;

    private Button nNextButton;
    private TextView nQuestionTextView;

    //cheat button initialized
    private Button mCheatButton;

    // request code cheat
    private static final int REQUEST_CODE_CHEAT = 1;

    // private boolean variable
    private boolean mCheated;

//question bank
    private QuestionBank[] nQuestionBank = new QuestionBank[]{
    //initialize the array without giving the size explicitly, and accessing the created questions and setting the answers
        new QuestionBank(R.string.question_1,true),
        new QuestionBank(R.string.question_2,true),
        new QuestionBank(R.string.question_3,false),
        new QuestionBank(R.string.question_4,true),
        new QuestionBank(R.string.question_5,false)

};
    //current index variable, since its zero then, once screen rotates the questions start from first one
    //to overcome save the current index value, here change is made down at update question function
    private int currentIndex = 0;

//    the name for the logs on the terminal
    private static final String TAG = "MathActivity";


//    the key for the saving of the current state to avoid starting question on change of screen orientation
    private static final String KEY_INDEX = "index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//initial code generated
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log messages in the onCreate method
        Log.d(TAG, "Inside OnCreate");

//creating the text view, initialize the text
        //textview with the resource id
        nQuestionTextView = findViewById(R.id.question_text_view);

        //just before the update of the question perform check on on saved instance not to be null
        if(savedInstanceState != null){
            //key index and default value,saved the value and retrieved the value, and you will be able to receive the link
            currentIndex = savedInstanceState.getInt(KEY_INDEX, REQUEST_CODE_CHEAT);

            // handle what to do with the received value, define another boolean variable mCheated


        }


        //getting the question from the question bank, or call the method updateQuestion() to remove redundancy
        int question = nQuestionBank[currentIndex].getQuestion();
        nQuestionTextView.setText(question);


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
                      //Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();

                      //check answer
                      checkAnswer(true);
            }
        });

        //initialize the button, and use typecasting
        mFalseButton = (Button) findViewById(R.id.false_button);
        //set the listener after the initialization  of the above button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //check answer
                    checkAnswer(false);
            }
        });

        //the question's next button
        nNextButton = (Button) findViewById(R.id.next_button);
        //what happens when next button is pressed, displaying the next question
        nNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = (currentIndex + 1) % nQuestionBank.length;
                //call the method that you wanted to remove redundancy
                updateQuestion();
            }
        });

        // mCheatButton implementation to show one already looked in the cheat page and the answer
        //initialize the button, and use typecasting
        mCheatButton = (Button) findViewById(R.id.btn_cheat);
        //set the listener after the initialization  of the above button
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //what happens when cheat button is pressed, displaying the answer
            public void onClick(View view) {
                Log.d(TAG, "Cheat Button Clicked");
                // Intent intent = new Intent(MainActivity.this, CheatActivity.class);
               // startActivity(intent);

                // new way of calling the cheat activity, pass the integer value to the cheat activity, in which is stored in currentIndex
                Intent i = CheatActivity.newIntent(MainActivity.this, currentIndex);
                // start the activity
                // startActivity(i);
                startActivityForResult(i, 0);

            }
        });



        //redundancy removed by calling the method
                // new cheat page which is a new activity apart from the main activity on the on create method, creating a new intent
        //        Button cheatButton = findViewById(R.id.btn_cheat);
        //        cheatButton.setOnClickListener(new View.OnClickListener() {
        //            @Override
        //            public void onClick(View v) {
        //                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
        //                startActivity(intent);
        //            }
        //        });



    }

        //Screen rotation start from question one error fixed
        @Override
        public void onSaveInstanceState(Bundle savedInstanceState){
            super.onSaveInstanceState(savedInstanceState);
            Log.i(TAG, "Inside onSaveInstance");

            //bundle saves the values as key-value pairs
            // saving the current index value, this will save the value of the current index
            savedInstanceState.putInt(KEY_INDEX, currentIndex);
        }

        //to avoid the redundancy, create the private method, and call it when needed
        private void updateQuestion(){
            int question = nQuestionBank[currentIndex].getQuestion();
            nQuestionTextView.setText(question);

        }

        //method to check the user's answer and match to the current true or false object to determine the correct answer
        private void checkAnswer(boolean userPressedTrue){
            boolean answerIsTrue = nQuestionBank[currentIndex].istrueQuestion();

        //declare the variable message id and check what the user checked
            int messageResid = 0;
            if(userPressedTrue == answerIsTrue){
                messageResid = R.string.correct_toast;
            }else{
                messageResid = R.string.incorrect_toast;
            }
            Toast.makeText(this, messageResid, Toast.LENGTH_SHORT).show();
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