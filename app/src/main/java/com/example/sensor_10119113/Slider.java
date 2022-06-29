package com.example.sensor_10119113;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.sensor_10119113.ui.SliderAdapter;

public class Slider extends AppCompatActivity {
    ViewPager viewPager;
    Button btn_next;
    int[] layouts;
    SliderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_slider);

        viewPager = findViewById(R.id.view_pager);
        btn_next = findViewById(R.id.btn_next);

        layouts = new int[] {
                R.layout.slider_1,
                R.layout.slider_2,
                R.layout.slider_3
        };

        adapter = new SliderAdapter(this, layouts);
        viewPager.setAdapter(adapter);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewPager.getCurrentItem()+1 < layouts.length)
                {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }else
                {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });

        viewPager.addOnPageChangeListener(viewPagerChangeListener);
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position == layouts.length-1)
            {
                btn_next.setText("Continue");
            }else
            {
                btn_next.setText("Next");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}

//NIM : 10119113
//Nama : Dafa Rizky Fahreza
//Kelas : IF3