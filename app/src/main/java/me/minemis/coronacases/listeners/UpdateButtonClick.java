package me.minemis.coronacases.listeners;

import android.view.View;

import me.minemis.coronacases.MainActivity;
import me.minemis.coronacases.internet_utlis.DataManager;

public class UpdateButtonClick implements View.OnClickListener {

    private final MainActivity mainActivity;
    private final DataManager dataManager;

    public UpdateButtonClick(MainActivity mainActivity, DataManager dataManager) {
        this.mainActivity = mainActivity;
        this.dataManager = dataManager;
    }

    @Override
    public void onClick(View v) {
        dataManager.updateData();
    }
}
