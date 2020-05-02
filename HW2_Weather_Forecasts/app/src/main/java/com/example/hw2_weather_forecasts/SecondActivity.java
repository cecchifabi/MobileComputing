package com.example.hw2_weather_forecasts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity {
    private String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        this.city = intent.getStringExtra("CITY");

        // Pass the city to FragmentB
        Toast.makeText(this, city, Toast.LENGTH_SHORT);
        displayFragment();
    }

    public void displayFragment() {
        FragmentB fB = FragmentB.newInstance(city);

        // Get the FragmentManager and start a transaction.
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Add the SimpleFragment.
        fragmentTransaction.add(R.id.fragment_container, fB).addToBackStack(null).commit();
    }
}