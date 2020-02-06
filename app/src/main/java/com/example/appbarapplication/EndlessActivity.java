package com.example.appbarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class EndlessActivity extends AppCompatActivity {
    private final static String siteUrl="http://myfile.org/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endless);

        init();
    }

    public void init() {
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonForvard = findViewById(R.id.buttonForvard);
        TextView outView = findViewById(R.id.outView);

        Random rand = new Random();
        outView.setText(siteUrl + rand.nextInt(100));

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buttonForvard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndlessActivity.this, EndlessActivity.class);
                startActivity(intent);
            }
        });
    }
}
