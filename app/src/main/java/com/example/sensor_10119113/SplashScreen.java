package com.example.sensor_10119113;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=2000;
    SliderManager sliderManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        sliderManager = new SliderManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(sliderManager.isFirstTime())
                {
                    sliderManager.setFirstTime(false);
                    startActivity(new Intent(getApplicationContext(), Slider.class));
                }else
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
}

//NIM : 10119113
//Nama : Dafa Rizky Fahreza
//Kelas : IF3