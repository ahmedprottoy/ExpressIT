package com.example.expressit;
import android.content.ActivityNotFoundException;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;

public class Speecch_to_text extends AppCompatActivity{
    private static final int REQUEST_CODE = 100;
    private TextView textOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speecch_to_text);
        textOutput= (TextView) findViewById(R.id.textOutput);

    }


    public void onClick(View v)
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException ignored) {

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                textOutput.setText(result.get(0));
            }
        }
    }
}