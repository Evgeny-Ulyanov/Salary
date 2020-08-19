package com.u.e.m.salary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        setTitle("Итог");

        totalTextView = findViewById(R.id.totalTextView);

        Intent totalIntent = getIntent();
        String reguestCodeTotal = totalIntent.getStringExtra("reguestCode");
        switch (reguestCodeTotal) {
            case "1":
                String hours = totalIntent.getStringExtra("days");
                String hoursMore = totalIntent.getStringExtra("daysMore");
                String allowance = totalIntent.getStringExtra("daysAllovance");
                String prize = totalIntent.getStringExtra("daysPrize");

                float oneHours = 132.28f;
                int hoursInt = Integer.parseInt(hours) * 8;// часов всего
                int hoursMoreInt = Integer.parseInt(hoursMore) * 8; //часов переработки
                int allowanceInt = Integer.parseInt(allowance); //персональная надбавка
                int prizeInt = Integer.parseInt(prize); //разовая премия

                totalTextView.setText("Оклад " + (hoursInt * oneHours) +
                        "\nНадбавка " + allowanceInt +
                        "\nПремия " + ((hoursMoreInt + hoursInt) * oneHours) * 0.3f +
                        "\nРазовая премия " + prizeInt +
                        "\nПереработано " + (hoursMoreInt * 2) * oneHours +
                        "\nДо вычета НДФЛ " + ((((hoursInt + (hoursMoreInt * 2)) * oneHours) + allowanceInt + prizeInt) +
                        (((hoursMoreInt + hoursInt) * oneHours) * 0.3f)) +
                        "\nПосле вычета НДФЛ " + (((((hoursInt + (hoursMoreInt * 2)) * oneHours) + allowanceInt + prizeInt) +
                        ((((hoursMoreInt + hoursInt) * oneHours) * 0.3f))) * 0.87f));

                break;
            case "2":
                break;
            case "3":
                break;
            default:
                break;
        }


    }
}

//        ("Оклад " + (hours*stavka)  +
//        "\nПремия " + (hours*stavka)*0.3f +
//        "\nНадбавка " + nadbavka +
//        "\nДо НДФЛ " + ((hours*stavka)*1.3f+nadbavka) +
//        "\nЧистыми " + ((hours*stavka)*1.3f+nadbavka)*0.87f);