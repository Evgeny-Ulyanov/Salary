package com.u.e.m.salary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TotalActivity extends AppCompatActivity {

    TextView totalTextView;
    String[] addresses = {"ulyanov.1992@list.ru"};
    String subject = "Результаты использования приложения.";
    String textEmail = "Здравствуйте, Евгений. Используя Ваше приложение, я смог произвести рассчет своей заработной платы.";

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.email:
                sendEmail();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, textEmail);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}