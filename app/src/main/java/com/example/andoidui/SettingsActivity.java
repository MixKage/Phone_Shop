package com.example.andoidui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void darkTheme(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Да, она всё ещё не работает...",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    
}