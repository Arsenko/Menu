package com.example.appbarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarapplication.logicClass.IndividualValue;

import java.util.ArrayList;
import java.util.Date;

public class PressureMonitor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_pressure);
        init();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shapka, menu);
        return true;
    }
    public void init(){
        final TextView upperPressure=findViewById(R.id.upperPressure);
        final TextView lowerPressure=findViewById(R.id.lowerPressure);
        final TextView pulse=findViewById(R.id.pulseInput);
        final CheckBox tackihardia=findViewById(R.id.tacihardiaBox);
        final TextView data=findViewById(R.id.dateOfMeasuring);
        Button toCardClient = findViewById(R.id.toCardClient);

        final ArrayList<IndividualValue> individualValues=new ArrayList<>();
        toCardClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toCC","OnClick button toCardClient");
                Intent intent = new Intent(PressureMonitor.this, ClientCard.class);
                startActivity(intent);
            }
        });
        Button toHealthMonitor=findViewById(R.id.toHealthMonitorButton);
        toHealthMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toHM","OnClick button toHealthMonitor");
                Intent intent = new Intent(PressureMonitor.this, HealthMonitor.class);
                startActivity(intent);
            }
        });
        Button saveBut=findViewById(R.id.saveButton);
        saveBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button Save","OnClick button Save");
                if(checkForm(upperPressure,lowerPressure,pulse,data)){
                    individualValues.add(new IndividualValue(
                            Integer.valueOf(upperPressure.getText().toString()),
                            Integer.valueOf(lowerPressure.getText().toString()),
                            Integer.valueOf(pulse.getText().toString()),
                            tackihardia.isChecked(),
                            new Date(data.getText().toString())));
                }
            }
        });
    }
    public boolean checkForm(TextView upperPressure, TextView lowerPressure, TextView pulse, TextView data) {
        if (upperPressure.getText().equals("") || lowerPressure.getText().equals("") ||
                pulse.getText().equals("") || data.getText().equals("")) {
            return false;
        }
        return true;
    }
}

