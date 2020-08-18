package com.u.e.m.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

public class DayActivity extends AppCompatActivity {

    private TextInputLayout dayWorkEditText;
    private TextInputLayout dayMoreEditText;
    private TextInputLayout allowanceEditText;
    private TextInputLayout prizeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        setTitle("Дневной график");

        dayWorkEditText = findViewById(R.id.dayWorkEditText);
        dayMoreEditText = findViewById(R.id.dayMoreEditText);
        allowanceEditText = findViewById(R.id.allowanceEditText);
        prizeEditText = findViewById(R.id.prizeEditText);
    }

    public void calculationDay(View view) {

        Intent intent = new Intent(DayActivity.this, TotalActivity.class);
        String days = dayWorkEditText.getEditText().getText().toString();
        String daysMore = dayMoreEditText.getEditText().getText().toString();
        String daysAllovance = allowanceEditText.getEditText().getText().toString();
        String daysPrize = prizeEditText.getEditText().getText().toString();
        intent.putExtra("days", days);
        intent.putExtra("daysMore", daysMore);
        intent.putExtra("daysAllovance", daysAllovance);
        intent.putExtra("daysPrize", daysPrize);
        startActivity(intent);
    }
}