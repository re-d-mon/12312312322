package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteTableLockedException;
import android.graphics.Paint;
import android.icu.text.MessagePattern;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login=findViewById(R.id.button2);
        EditText editText_login = findViewById(R.id.editTextTextPersonName);
        EditText editText_password = findViewById(R.id.editTextTextPersonName2);



        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_login=editText_login.getText().toString();
                String string_password = editText_password.getText().toString();

                if (string_login.equals("admin")&&(string_password.equals("admin")))
                {
                    Intent intent_Glavnay = new Intent();
                    intent_Glavnay.setClass(Login.this,Glavnay.class);

                    startActivity(intent_Glavnay);
                    finish();
                }
                else
                {
                    Toast toast=Toast.makeText(getApplicationContext(),"Не вырный логин или пароль",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
        editText_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    String string_login=editText_password.getText().toString();
                    if (string_login.equals("Пароль"))
                    {
                        editText_password.setText("");
                        editText_password.setInputType( InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD );
                    }
                }
                else
                {
                    String string_login=editText_password.getText().toString();
                    if (string_login.equals(""))
                    {
                        editText_password.setText("Пароль");
                        editText_password.setInputType( InputType.TYPE_NUMBER_VARIATION_PASSWORD );
                    }
                }
            }
        });
        editText_login.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (b)
                {
                    String string_login=editText_login.getText().toString();
                    if (string_login.equals("Email"))
                    {
                        editText_login.setText("");
                    }
                }
                else
                {
                    String string_login=editText_login.getText().toString();
                    if (string_login.equals(""))
                    {
                        editText_login.setText("Email");
                    }
                }
            }
        });
    }

}