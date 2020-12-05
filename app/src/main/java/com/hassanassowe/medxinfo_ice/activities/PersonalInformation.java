package com.hassanassowe.medxinfo_ice.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textfield.TextInputLayout;
import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.Contacts;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PersonalInformation extends AppCompatActivity {
    TextInputLayout fullName;
    TextInputLayout dateOfBirth;
    TextInputLayout height, heightMetric;
    TextInputLayout weight, weightMetric;
    TextInputLayout bloodGroup;
    TextInputLayout organDonorStatus;
    TextInputLayout address;
    TextInputLayout phoneNumber;



    private com.hassanassowe.medxinfo_ice.objects.PersonalInformation information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        //Initialize Material Toolbar & Set its Navigation Icon
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

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
        switch (item.getItemId()){
            case R.id.home:
                finish();
                break;
            case R.id.save:
                saveData();
            default:
                return false;
        }
        return true;
    }

    public Boolean saveData(){
        if(!fullName.getEditText().getText().toString().isEmpty()){
            String[] temp = fullName.getEditText().getText().toString().split(" ");
            information.setFirstName(temp[0]);
            information.setLastName(temp[1]);
        }
        if(!dateOfBirth.getEditText().getText().toString().isEmpty()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                information.setDate(LocalDate.parse(dateOfBirth.getEditText().getText().toString()));
            }
        }

        if(!height.getEditText().getText().toString().isEmpty()){
            information.setWeight(Double.parseDouble(height.getEditText().getText().toString()));
        }

        if(!weight.getEditText().getText().toString().isEmpty()){
            information.setHeight(Double.parseDouble(weight.getEditText().getText().toString()));
        }

        if(!address.getEditText().getText().toString().isEmpty()){
            information.setAddress(address.getEditText().getText().toString());
        }

        if(!phoneNumber.getEditText().getText().toString().isEmpty()){
            information.setPhoneNumber(phoneNumber.getEditText().getText().toString());
        }

        SaveLoadData.saveDataPersonal(this, information);

        return true;
    }
}
