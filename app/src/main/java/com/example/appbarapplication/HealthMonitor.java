package com.example.appbarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarapplication.logicClass.HealthValue;

import java.util.ArrayList;

public class HealthMonitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_health);
        init();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shapka, menu);
        return true;
    }
    public void init(){
        final TextView weigth=findViewById(R.id.weigthInput);
        final TextView steps=findViewById(R.id.steps);

        final ArrayList<HealthValue> healthValues=new ArrayList<>();
        Button toCardClient = findViewById(R.id.toCardClient);
        toCardClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toCC","OnClick button toCardClient");
                Intent intent = new Intent(HealthMonitor.this, ClientCard.class);
                startActivity(intent);
            }
        });
        Button toPressureMonitor=findViewById(R.id.toPressureMonitorButton);
        toPressureMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toPM","OnClick button toPressureMonitor");
                Intent intent = new Intent(HealthMonitor.this, PressureMonitor.class);
                startActivity(intent);
            }
        });
        Button saveBut=findViewById(R.id.saveButton);
        saveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button Save","OnClick button Save");
                if(checkForm(weigth,steps)){
                    healthValues.add(new HealthValue(
                            Double.valueOf(weigth.getText().toString()),Integer.valueOf(steps.getText().toString())));
                }
            }
        });
    }
    public boolean checkForm(TextView weigth,TextView steps){
        if(weigth.getText().equals("") || steps.getText().equals("")){
            return false;
        }
        return true;
    }
}
