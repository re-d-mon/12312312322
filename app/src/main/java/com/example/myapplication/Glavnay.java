package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Glavnay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glavnay);
        TextView editText_time = findViewById(R.id.textView5);
        TextView editText_Date= findViewById(R.id.textView6);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // получаем текущее время
                    Date currentDate = new Date();
// Форматирование времени как "день.месяц.год"
                    DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
                    String dateText = dateFormat.format(currentDate);
// Форматирование времени как "часы:минуты:секунды"
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
                    String timeText = timeFormat.format(currentDate);
                    editText_time.post(new Runnable() {
                        public void run() {
                            editText_time.setText(timeText);
                        }
                    });
                    editText_Date.post(new Runnable() {
                        public void run() {
                            editText_Date.setText(dateText);
                        }
                    });
                    // отображаем в текстовом поле
                }

            }
        };
        // Определяем объект Thread - новый поток
        Thread thread = new Thread(runnable);
        // Запускаем поток
        thread.start();
    }





}



