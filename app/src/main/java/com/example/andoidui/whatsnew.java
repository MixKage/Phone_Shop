package com.example.andoidui;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jaeger.library.StatusBarUtil;

public class whatsnew extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 8000;
    private static final TimeInterpolator GAUGE_ANIMATION_INTERPOLATOR = new DecelerateInterpolator(0.5f);
    private static final int MAX_LEVEL = 100;
    private static final long GAUGE_ANIMATION_DURATION = 8000;
    private static boolean TF = false;
    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsnew);

        StatusBarUtil.setTranslucentForImageViewInFragment(whatsnew.this, null);

        //StatusBarUtil.setTransparent(whatsnew.this);

        mProgressBar = findViewById(R.id.progressBar);

        ImageView imageView = findViewById(R.id.imageBack);
        imageView.animate().scaleX(2).scaleY(2).setDuration(SPLASH_TIME_OUT+2000);

        ObjectAnimator animator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, MAX_LEVEL);
        animator.setInterpolator(GAUGE_ANIMATION_INTERPOLATOR);
        animator.setDuration(GAUGE_ANIMATION_DURATION);
        animator.start();

        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                if(TF){
                }else{
                Intent homeIntent = new Intent(whatsnew.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }}
        },SPLASH_TIME_OUT);
    }

    public void skip_update(View view) {
        TF=true;
        Intent homeIntent = new Intent(whatsnew.this, MainActivity.class);
        startActivity(homeIntent);
        finish();

    }
}