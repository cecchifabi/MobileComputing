package com.hw1dialler;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNumber;
    private Button sd1, sd2, sd3;

    private String sdNumber1 = "", sdNumber2 = "", sdNumber3 = "";

    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_ID = "com.hw1dialler.extra.ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber = (EditText)findViewById(R.id.number);

        sd1 = (Button)findViewById(R.id.sd_1);
        sd1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Start the second activity
                Log.d("MainActivity", "Long pressed: SD1");

                Intent intent = new Intent(v.getContext(), SpeedDialActivity.class);
                intent.putExtra(EXTRA_ID, "SD1");
                startActivityForResult(intent, TEXT_REQUEST);

                return false;
            }
        });

        sd2 = (Button)findViewById(R.id.sd_2);
        sd2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Start the second activity
                Log.d("MainActivity", "Long pressed: SD2");

                Intent intent = new Intent(v.getContext(), SpeedDialActivity.class);
                intent.putExtra(EXTRA_ID, "SD2");
                startActivityForResult(intent, TEXT_REQUEST);

                return false;
            }
        });

        sd3 = (Button)findViewById(R.id.sd_3);
        sd3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Start the second activity
                Log.d("MainActivity", "Long pressed: SD3");

                Intent intent = new Intent(v.getContext(), SpeedDialActivity.class);
                intent.putExtra(EXTRA_ID, "SD3");
                startActivityForResult(intent, TEXT_REQUEST);

                return false;
            }
        });
    }

    public void btnPressed(View view) {
        String symbol = ((Button) view).getText().toString();

        Log.d("MainActivity", "Button pressed: " + symbol);

        phoneNumber.setText(phoneNumber.getText() + symbol);
    }

    public void dial(View view) {
        String n = phoneNumber.getText().toString();

        Log.d("MainActivity", "Button pressed: DIAL");

        /// Make the call
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + n));
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Permissions not granted: inform the user
                Toast.makeText(getApplicationContext(), "Permissions to call not granted", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(intent);
        }
    }

    public void canc(View view) {
        Log.d("MainActivity", "Button pressed: C");

        phoneNumber.setText("");
    }

    public void del(View view) {
        Log.d("MainActivity", "Button pressed: DEL");

        String text = phoneNumber.getText().toString();
        if(text.length() != 0) {
            phoneNumber.setText(text.subSequence(0, text.length() - 1));
        }
    }

    public void speedDial1(View view) {
        Log.d("MainActivity", "Button pressed: SD1");

        makeCall(sdNumber1);
    }

    public void speedDial2(View view) {
        Log.d("MainActivity", "Button pressed: SD2");

        makeCall(sdNumber2);
    }

    public void speedDial3(View view) {
        Log.d("MainActivity", "Button pressed: SD3");

        makeCall(sdNumber3);
    }

    public void makeCall(String number){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Permissions not granted: inform the user
                Toast.makeText(getApplicationContext(), "Permissions to call not granted", Toast.LENGTH_SHORT).show();
                return;
            }
            startActivity(intent);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String name = data.getStringExtra(SpeedDialActivity.EXTRA_NAME);
        String number = data.getStringExtra(SpeedDialActivity.EXTRA_NUMBER);
        String id = data.getStringExtra(EXTRA_ID);

        if(id.equals("SD1")) {
            sd1.setText(name);
            sdNumber1 = number;
        }
        if(id.equals("SD2")) {
            sd2.setText(name);
            sdNumber2 = number;
        }
        if(id.equals("SD3")) {
            sd3.setText(name);
            sdNumber3 = number;
        }
    }
}
