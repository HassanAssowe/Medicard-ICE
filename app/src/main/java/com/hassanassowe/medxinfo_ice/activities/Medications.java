
package com.hassanassowe.medxinfo_ice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;
import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.Medication;

import java.util.ArrayList;

public class Medications extends AppCompatActivity {

    private TextInputLayout title;
    private TextInputLayout dosage;
    private TextInputLayout description;

    private ArrayList<Medication> medications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medications);

        //Initialize Material Toolbar & Set its Navigation Icon
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

        //Initialize TextInputLayouts
        title = findViewById(R.id.medication_title);
        dosage = findViewById(R.id.medication_dosage);
        description = findViewById(R.id.medication_description);

        //Initialize data
        medications = new ArrayList<>();
        SaveLoadData.loadDataMedication(this, medications);

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
        else if(!title.getEditText().getText().toString().isEmpty()){
            Medication medication = new Medication(title.getEditText().getText().toString(), dosage.getEditText().getText().toString(), description.getEditText().getText().toString());
            medications.add(medication);
            SaveLoadData.saveDataMedication(this, medications);
            finish();
        }
        return true;
    }
}