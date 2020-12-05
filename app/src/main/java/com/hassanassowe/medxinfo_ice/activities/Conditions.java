package com.hassanassowe.medxinfo_ice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;
import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.Condition;

import java.util.ArrayList;

public class Conditions extends AppCompatActivity {
    private TextInputLayout title;
    private TextInputLayout symptoms;
    private TextInputLayout medications;
    private TextInputLayout doctorSpecialst;

    private ArrayList<Condition> conditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conditions);

        //Initialize Material Toolbar & Set its Navigation Icon
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

        //Initialize TextInputLayouts
        title = findViewById(R.id.condition_title);
        symptoms = findViewById(R.id.condition_symptoms);
        medications = findViewById(R.id.condition_medications);
        doctorSpecialst = findViewById(R.id.condition_doctor);

        //Initialize data
        conditions = new ArrayList<>();
        SaveLoadData.loadDataCondition(this, conditions);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.personal_information_top_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                finish();
                break;
            case R.id.save:
                saveData();
                break;
            default:
                break;
        }
        return true;
    }

    public Boolean saveData(){
        if(title.getEditText().getText().toString().isEmpty())
            title.setError("Required");
        else{
            com.hassanassowe.medxinfo_ice.objects.Condition condition = new com.hassanassowe.medxinfo_ice.objects.Condition(title.getEditText().getText().toString(),symptoms.getEditText().getText().toString(),medications.getEditText().getText().toString(),doctorSpecialst.getEditText().getText().toString());
            conditions.add(condition);
            SaveLoadData.saveDataCondition(this, conditions);
            finish();
        }
        return true;
    }
}