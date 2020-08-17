package com.u.e.m.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShebuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebule);

    }

    public void dayShebule(View view) {
        startActivity(new Intent(ShebuleActivity.this, DayActivity.class));
    }

    public void changeShebule(View view) {
    }

    public void mixShebule(View view) {
    }
}