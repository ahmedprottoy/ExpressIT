package com.example.expressit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    Animation ExAnim,ItAnim;
    TextView txt1,txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ExAnim = AnimationUtils.loadAnimation(this,R.anim.express_animation);
        ItAnim = AnimationUtils.loadAnimation(this,R.anim.it_animation);

        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);

        txt1.setAnimation(ExAnim);
        txt2.setAnimation(ItAnim);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent1 = new Intent(MainActivity.this,Home.class);
                startActivity(intent1);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}