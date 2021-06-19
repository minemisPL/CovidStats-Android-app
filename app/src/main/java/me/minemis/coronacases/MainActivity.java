package me.minemis.coronacases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import me.minemis.coronacases.internet_utlis.DataManager;
import me.minemis.coronacases.listeners.UpdateButtonClick;

public class MainActivity extends AppCompatActivity {

    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataManager = new DataManager(this);

        dataManager.updateData();

        Button update = findViewById(R.id.btn_update);

        update.setOnClickListener(new UpdateButtonClick(this, dataManager));
    }
}