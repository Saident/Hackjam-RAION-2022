package com.example.hackjam2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button home, ticket, search, history, profile;
    TextView tv_name;
    FirebaseUser user;
    FirebaseAuth mAuth;
    private String userID;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        home = findViewById(R.id.bt_home);
        home.setOnClickListener(this);
        ticket = findViewById(R.id.bt_ticket);
        ticket.setOnClickListener(this);
        search = findViewById(R.id.bt_search);
        search.setOnClickListener(this);
        history = findViewById(R.id.bt_history);
        history.setOnClickListener(this);
        profile = findViewById(R.id.bt_profile);
        profile.setOnClickListener(this);

        tv_name = findViewById(R.id.tv_name);
        getUserName();

    }

    private void getUserName(){
        user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        TextView tv_name = findViewById(R.id.tv_name);
        database.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                if (user != null){
                    String fullname = user.fullname;
                    tv_name.setText(fullname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "Something wrong happened!", Toast.LENGTH_SHORT);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_home:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case R.id.bt_ticket:
                startActivity(new Intent(this, TicketActivity.class));
                break;
            case R.id.bt_search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.bt_history:
                startActivity(new Intent(this, HistoryActivity.class));
                break;
            case R.id.bt_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }
}