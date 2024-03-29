package com.example.expressit;
import android.content.ActivityNotFoundException;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.WindowManager;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;



public class Speecch_to_text extends AppCompatActivity {


    private static final int REQUEST_CODE = 100;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speecch_to_text);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textOutput= (TextView) findViewById(R.id.textOutput);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       //getSupportActionBar().setTitle("Ygyg");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    public void onClick(View v)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException a) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textOutput.setText(result.get(0));
                }
                break;
            }

        }
    }
}