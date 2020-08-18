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
        int days = Integer.parseInt(dayWorkEditText.getEditText().getText().toString());
        int daysMore = Integer.parseInt(dayMoreEditText.getEditText().getText().toString());
        int daysAllovance = Integer.parseInt(allowanceEditText.getEditText().getText().toString());
        int daysPrize = Integer.parseInt(prizeEditText.getEditText().getText().toString());
        intent.putExtra("days", days);
        intent.putExtra("daysMore", daysMore);
        intent.putExtra("daysAllovance", daysAllovance);
        intent.putExtra("daysPrize", daysPrize);
        startActivity(intent);
    }
}

//        txtView.setText("Оклад " + (hours*stavka)  +
//        "\nПремия " + (hours*stavka)*0.3f +
//        "\nНадбавка " + nadbavka +
//        "\nДо НДФЛ " + ((hours*stavka)*1.3f+nadbavka) +
//        "\nЧистыми " + ((hours*stavka)*1.3f+nadbavka)*0.87f);

//    public void onClick(View view) {
//        Intent intent = new Intent();
//        int hour = Integer.parseInt(editHours.getText().toString());
//        float stavka = Float.parseFloat(editStavka.getText().toString());
//        int Nadbavka = Integer.parseInt(editPNadbavka.getText().toString());
//        intent.putExtra("hours", hour);
//        intent.putExtra("stavka", stavka);
//        intent.putExtra("nadbavka", Nadbavka);
//        setResult(RESULT_OK, intent);
//        finish();
//    }