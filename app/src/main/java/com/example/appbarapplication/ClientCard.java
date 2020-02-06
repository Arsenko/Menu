package com.example.appbarapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbarapplication.logicClass.Namespace;

import java.util.ArrayList;

public class ClientCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_client);
        init();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shapka, menu);
        return true;
    }

    public void init(){

        final ArrayList<Namespace> names=new ArrayList<Namespace>();
        final TextView surname=findViewById(R.id.surname);
        final TextView name=findViewById(R.id.name);
        final TextView lastname=findViewById(R.id.lastname);
        final TextView age=findViewById(R.id.age);
        Button toHealthMonitor= findViewById(R.id.toHealthMonitorButton);
        toHealthMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toHM","OnClick button toHealthMonitor");
                Intent intent = new Intent(ClientCard.this, HealthMonitor.class);
                startActivity(intent);
            }
        });
        Button toPressureMonitor=findViewById(R.id.toPressureMonitorButton);
        toPressureMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button toPM","OnClick button toPressureMonitor");
                Intent intent = new Intent(ClientCard.this, PressureMonitor.class);
                startActivity(intent);
            }
        });
        Button saveButton=findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("OnClick button save","OnClick button save");
                if(checkForm(surname,name,lastname,age)){
                    names.add(new Namespace(surname.getText().toString(),name.getText().toString(),
                            lastname.getText().toString(),
                            Integer.valueOf(age.getText().toString())));
                }
            }
        });
    }
    public boolean checkForm(TextView surname,TextView name,TextView lastname,TextView age){
        if(surname.getText().equals("") || name.getText().equals("") ||
                lastname.getText().equals("") || age.getText().equals("")){
            return false;
        }
        return true;
    }
}
