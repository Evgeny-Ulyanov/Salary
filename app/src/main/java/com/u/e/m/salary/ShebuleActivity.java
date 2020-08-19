package com.u.e.m.salary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.u.e.m.salary.R.drawable.logo_splash_screen;

public class ShebuleActivity extends AppCompatActivity {
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shebule);
        mConstraintLayout =
                (ConstraintLayout)findViewById(R.id.constraintLayout);
        mConstraintLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

    }

    public void dayShebule(View view) {
        startActivity(new Intent(ShebuleActivity.this, DayActivity.class));
    }

    public void changeShebule(View view) {
        Toast.makeText(this, "Поведение кнопки не реализовано, всвязи с незначительными отличиями от рассчета по дневному графику", Toast.LENGTH_LONG).show();
    }

    public void mixShebule(View view) {
        Toast.makeText(this, "Поведение кнопки не реализовано, всвязи с незначительными отличиями от рассчета по дневному графику", Toast.LENGTH_LONG).show();
    }

    public void chempack(View view) {
        startActivity(new Intent(ShebuleActivity.this, WebActivity.class));
    }
}