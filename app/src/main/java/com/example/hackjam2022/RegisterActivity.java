package com.example.hackjam2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_fullname, et_email, et_password, et_confpassword;
    private ImageView logo;
    private Button register;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        et_fullname = findViewById(R.id.et_fullname);
        et_confpassword = findViewById(R.id.et_confpassword);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        logo = findViewById(R.id.iv_logo);

        register = findViewById(R.id.bt_register);

        progressBar = findViewById(R.id.progressBar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}

