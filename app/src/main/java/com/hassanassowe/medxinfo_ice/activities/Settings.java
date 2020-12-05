package com.hassanassowe.medxinfo_ice.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadSettings;


public class Settings extends AppCompatActivity {
    private RadioGroup themeRadioGroup, tempRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        themeRadioGroup = findViewById(R.id.radioGroup_theme);

        MaterialToolbar topAppBar = findViewById(R.id.menuAppBar);
        initalizeActionBar(topAppBar); //SetUp ActionBar
        currentSelection(); //If Options were previously selected, display those options.
        themeSelection(); //Handle Theme Selection Changes

        //Apply Actionbar to our view.
        setSupportActionBar(topAppBar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Set what to do if navigation icon is pressed
        topAppBar.setNavigationOnClickListener(
                v -> finish()
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void initalizeActionBar(MaterialToolbar topAppBar) { //Method is responsible for setting up our ActionBar
        topAppBar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(topAppBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        topAppBar.setNavigationOnClickListener(v -> finish());
    }
    private void currentSelection(){ //Shows current selected settings.
        SharedPreferences sharedPreferences = getSharedPreferences("settingsKey", Context.MODE_PRIVATE); //Load our settingsKey
        String theme = sharedPreferences.getString("theme_setting", "com.hassanassowe.raspberrycam:id/system_theme"); //Get the value of "theme" from our Settings Key
        themeRadioGroup.check(getResources().getIdentifier(theme, "id", getPackageName()));
    }

    private void themeSelection() {
        themeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.i("Settings:","Passed Theme: " + getResources().getResourceName(themeRadioGroup.getCheckedRadioButtonId()));
                new SaveLoadSettings().saveData(Settings.this.getApplicationContext(), getResources().getResourceName(themeRadioGroup.getCheckedRadioButtonId())); //Save Changed Theme
                new SaveLoadSettings().loadData(Settings.this.getApplicationContext()); //Load Changed Theme
                new SaveLoadSettings().saveData(Settings.this.getApplicationContext(), getResources().getResourceName(themeRadioGroup.getCheckedRadioButtonId())); //SOME KIND OF GLITCH TEMP SOLVE? CALLING LOAD BREAKS
            }
        });

    }
}