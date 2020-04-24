package com.hw1dialler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SpeedDialActivity extends AppCompatActivity {

    private EditText name, phoneNumber;
    private Button save, cancel;
    private String id;

    public static final String EXTRA_NAME = "com.hw1dialler.extra.NAME";
    public static final String EXTRA_NUMBER = "com.hw1dialler.extra.NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_dial);

        name = (EditText)findViewById(R.id.name);
        phoneNumber = (EditText)findViewById(R.id.number);
        save = (Button)findViewById(R.id.btn_save);
        cancel = (Button)findViewById(R.id.btn_cancel);

        Intent intent = getIntent();
        id = intent.getStringExtra(MainActivity.EXTRA_ID);
    }

    public void goBack(View view) {
        Log.d("MainActivity", "Button pressed: CANCEL");

        Intent replyIntent = new Intent();
        setResult(RESULT_CANCELED, replyIntent);
        finish();
    }

    public void save(View view) {
        Log.d("MainActivity", "Button pressed: SAVE");

        String label = name.getText().toString();
        String number = phoneNumber.getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_NAME, label);
        replyIntent.putExtra(EXTRA_NUMBER, number);
        replyIntent.putExtra(MainActivity.EXTRA_ID, id);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
