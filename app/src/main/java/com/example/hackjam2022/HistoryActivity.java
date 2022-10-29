package com.example.hackjam2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {

    Button home, ticket, search, history, profile;

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