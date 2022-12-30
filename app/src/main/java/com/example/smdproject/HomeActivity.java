package com.example.smdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);


        Bundle bundle = getIntent().getExtras();
        String name = bundle.get("name").toString();

        TextView welcomeMessage = findViewById(R.id.welcome_msg);
        welcomeMessage.setText("Welcome! "+name);

        EditText anyText = findViewById(R.id.any_text);

    }
}