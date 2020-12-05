package com.hassanassowe.medxinfo_ice.classes;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hassanassowe.medxinfo_ice.objects.Allergy;
import com.hassanassowe.medxinfo_ice.objects.Condition;
import com.hassanassowe.medxinfo_ice.objects.Contacts;
import com.hassanassowe.medxinfo_ice.objects.Medication;
import com.hassanassowe.medxinfo_ice.objects.PersonalInformation;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SaveLoadData {

    public static  void saveDataContact(Context context, ArrayList<Contacts> emergencyContacts){
        SharedPreferences sharedPreferences = context.getSharedPreferences("emergencyContacts", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(emergencyContacts);
        editor.putString("contacts", json);
        editor.apply();
    }

    public static void loadDataContact(Context context, ArrayList<Contacts> instances) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("emergencyContacts", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("contacts", null);
        Type type = new TypeToken<ArrayList<Contacts>>() {
        }.getType();
        ArrayList<Contacts> load = gson.fromJson(json, type);
        if (load != null) {
            instances.addAll(load);
        }
    }

    public static  void saveDataMedication(Context context, ArrayList<Medication> medications){
        SharedPreferences sharedPreferences = context.getSharedPreferences("medications", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(medications);
        editor.putString("meds", json);
        editor.apply();
    }

    public static void loadDataMedication(Context context, ArrayList<Medication> instances) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("medications", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("meds", null);
        Type type = new TypeToken<ArrayList<Medication>>() {
        }.getType();
        ArrayList<Medication> load = gson.fromJson(json, type);
        if (load != null) {
            instances.addAll(load);
        }
    }

    public static  void saveDataCondition(Context context, ArrayList<Condition> conditions){
        SharedPreferences sharedPreferences = context.getSharedPreferences("conditions", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(conditions);
        editor.putString("condition", json);
        editor.apply();
    }

    public static void loadDataCondition(Context context, ArrayList<Condition> conditions) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("conditions", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("condition", null);
        Type type = new TypeToken<ArrayList<Condition>>() {
        }.getType();
        ArrayList<Condition> load = gson.fromJson(json, type);
        if (load != null) {
            conditions.addAll(load);
        }
    }

    public static void loadDataAllergy(Context context, ArrayList<Allergy> conditions) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("allergies", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("allergy", null);
        Type type = new TypeToken<ArrayList<Allergy>>() {
        }.getType();
        ArrayList<Allergy> load = gson.fromJson(json, type);
        if (load != null) {
            conditions.addAll(load);
        }
    }

    public static void saveDataAllergy(Context context, ArrayList<Allergy> allergies) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("allergies", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(allergies);
        editor.putString("allergy", json);
        editor.apply();
    }

    public static void loadDataPersonal(Context context, PersonalInformation information) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("information", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("info", null);
        information = gson.fromJson(json, PersonalInformation.class);
    }

    public static void saveDataPersonal(Context context, PersonalInformation information) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("information", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(information);
        editor.putString("info", json);
        editor.apply();
    }


}
