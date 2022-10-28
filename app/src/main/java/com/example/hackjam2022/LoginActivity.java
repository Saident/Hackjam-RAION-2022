package com.example.hackjam2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_login;
    EditText etEmail, etPassword;

    TextView forgotpass, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        register = findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_login:
//                Loginuser();
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
//            case R.id.forgot:
//                break;
        }
    }
}