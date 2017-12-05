package com.example.orazoulay.requestapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Readme extends AppCompatActivity {
    Button exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readme);

        exitButton=findViewById(R.id.Readme_Exit_B);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Readme.this ,MainActivity.class );
                startActivity(intent);
            }
        });
    }
}
