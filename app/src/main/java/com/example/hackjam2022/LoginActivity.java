package com.example.hackjam2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_login, back;
    EditText etEmail, etPassword;
    FirebaseAuth mAuth;

    TextView forgotpass, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        mAuth = FirebaseAuth.getInstance();

        bt_login = (Button) findViewById(R.id.bt_login);
        bt_login.setOnClickListener(this);
        back = findViewById(R.id.back);
        back.setOnClickListener(this);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bt_login:
                Loginuser();
                break;
            case R.id.back:
                startActivity(new Intent(this, OnBoarding.class));
                break;
            case R.id.forgot:
                break;
        }
    }

    private void Loginuser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError("Email is required!");
            etEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            etPassword.setError("Password is required!");
            etPassword.requestFocus();
            return;
        }
        if(password.length() < 6){
            etPassword.setError("Password needs to be 6 characters or longer");
            etPassword.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT);
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            finish();
                        }else{
                            Toast.makeText(LoginActivity.this, "Failed to login!", Toast.LENGTH_SHORT);
                            return;
                        }
                    }
                });
    }
}

