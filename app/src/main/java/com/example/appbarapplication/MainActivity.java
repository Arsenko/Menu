package com.example.appbarapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar= findViewById(R.id.actionToolBar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_open_notes: {
                Toast.makeText(MainActivity.this, "Отркыть записную книжку", Toast.LENGTH_LONG).show();
                Intent intentNotes=new Intent(MainActivity.this,NotesActivity.class);
                startActivity(intentNotes);
                return true;
                }
            case R.id.action_settings: {
                Toast.makeText(MainActivity.this, "Открыть настройки", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.action_card_client:{
                Toast.makeText(MainActivity.this, "Открыть монитор жизнедейтельности", Toast.LENGTH_LONG).show();
                Intent intentCardClient=new Intent(MainActivity.this,ClientCard.class);
                startActivity(intentCardClient);
                return true;
            }
            case R.id.action_endless:{
                Toast.makeText(MainActivity.this, "Открыть бесконечный переход между Activity", Toast.LENGTH_LONG).show();
                Intent intentEndless=new Intent(MainActivity.this,EndlessActivity.class);
                startActivity(intentEndless);
                return true;
            }
            case R.id.action_muted_exclusive_check_box:{
                Toast.makeText(MainActivity.this, "Отркыть взаимоисключающие CheckBox", Toast.LENGTH_LONG).show();
                Intent intentMutedCB=new Intent(MainActivity.this,MutedExclusiveCheckBoxActivity.class);
                startActivity(intentMutedCB);
                return true;
            }
            case R.id.action_sub:{
                Toast.makeText(MainActivity.this, "Отркыть регистрацию", Toast.LENGTH_LONG).show();
                Intent intentSub=new Intent(MainActivity.this,SubActivity.class);
                startActivity(intentSub);
                return true;
            }
            case R.id.action_task_time:{
                Toast.makeText(MainActivity.this, "Отркыть планёр задач", Toast.LENGTH_LONG).show();
                Intent intentTask=new Intent(MainActivity.this,TaskTimeActivity.class);
                startActivity(intentTask);
                return true;
            }
            case R.id.action_logo:{
                Toast.makeText(MainActivity.this, "Отркыть лого", Toast.LENGTH_LONG).show();
                Intent intentLogo=new Intent(MainActivity.this,SplashScreenActivity.class);
                startActivity(intentLogo);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
            }

    }
}
