package com.example.fragmentadvanced;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // code that will bring the segment to the layout
        // first you need fragment manager and get it
        FragmentManager fragmentManager = getSupportFragmentManager();

        // now create the segment object
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        //check if the segment is null or non-null
        if(fragment == null){
            // create a new fragment
            fragment = new ReportFragment();
            // start a transaction that will add this fragment into the activity
            fragmentManager.beginTransaction()
                    //where to add, what to add
                    .add(R.id.fragment_container, fragment)
                    //commit
                    .commit();

        }

    }
}