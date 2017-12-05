package com.example.orazoulay.requestapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    Button registerButton;
    Button readmeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        registerButton = findViewById(R.id.Register_B);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, registerActivity.class);
              startActivity(intent);
            }
        });
        readmeButton= findViewById(R.id.Readme_B);
        readmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Readme.class);
                startActivity(intent);
            }
        });



    }
}
