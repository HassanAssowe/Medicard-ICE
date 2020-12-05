package com.hassanassowe.medxinfo_ice.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;
import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;

import java.util.ArrayList;

public class Contacts extends AppCompatActivity {
    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout relation;
    private TextInputLayout phoneNumber;

    private ArrayList<com.hassanassowe.medxinfo_ice.objects.Contacts> emergencyContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        //Initialize Material Toolbar & Set its Navigation Icon
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

        //Initialize TextInputLayouts
        firstName = findViewById(R.id.contact_title);
        lastName = findViewById(R.id.contact_lastName);
        relation = findViewById(R.id.contact_relation);
        phoneNumber = findViewById(R.id.contact_phoneNumber);

        //Initialize data
        emergencyContacts = new ArrayList<>();
        SaveLoadData.loadDataContact(this, emergencyContacts);

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
        if(firstName.getEditText().getText().toString().isEmpty())
            firstName.setError("Required");
        if(lastName.getEditText().getText().toString().isEmpty())
            lastName.setError("Required");
        if(relation.getEditText().getText().toString().isEmpty())
            relation.setError("Required");
        if(phoneNumber.getEditText().getText().toString().isEmpty())
            phoneNumber.setError("Required");
        else if(!firstName.getEditText().getText().toString().isEmpty() && !lastName.getEditText().getText().toString().isEmpty() && !relation.getEditText().getText().toString().isEmpty() && !phoneNumber.getEditText().getText().toString().isEmpty()){
            com.hassanassowe.medxinfo_ice.objects.Contacts emergencyContactobject = new com.hassanassowe.medxinfo_ice.objects.Contacts(firstName.getEditText().getText().toString(), lastName.getEditText().getText().toString(), relation.getEditText().getText().toString(), phoneNumber.getEditText().getText().toString());
            emergencyContacts.add(emergencyContactobject);
            SaveLoadData.saveDataContact(this, emergencyContacts);
            finish();
        }
        return true;
    }
}