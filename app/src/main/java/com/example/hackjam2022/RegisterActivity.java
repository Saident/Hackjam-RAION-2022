package com.example.hackjam2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity{

    private EditText et_fullname, et_email, et_password, et_confpassword;
    private ImageView logo;
    private Button register, back;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        et_fullname = findViewById(R.id.et_fullname);
        et_confpassword = findViewById(R.id.et_confpassword);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);

        logo = findViewById(R.id.iv_logo);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OnBoarding.class));
            }
        });

        register = (Button) findViewById(R.id.bt_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String fullname = et_fullname.getText().toString().trim();
        String confpass = et_confpassword.getText().toString().trim();

        if (fullname.isEmpty()){
            et_fullname.setError("Full name is required");
            et_fullname.requestFocus();
            return;
        }

        if (email.isEmpty()){
            et_email.setError("Email is required");
            et_email.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("Please use a valid email");
            et_email.requestFocus();
            return;
        }

        if (password.isEmpty()){
            et_password.setError("Password is required");
            et_password.requestFocus();
            return;
        }

        if(password.length() < 6){
            et_password.setError("Password needs to be 6 characters or longer");
            et_password.requestFocus();
            return;
        }

        if(confpass.equals(password)){
        }else{
            et_confpassword.setError("Password doesnt match");
            et_confpassword.requestFocus();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(fullname, email);

                            FirebaseDatabase.getInstance("https://hackjam-2022-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(RegisterActivity.this, "User has been created!", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                            }else{
                                                Toast.makeText(RegisterActivity.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(RegisterActivity.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}

