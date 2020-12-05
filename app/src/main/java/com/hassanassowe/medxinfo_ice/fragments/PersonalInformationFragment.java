package com.hassanassowe.medxinfo_ice.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.PersonalInformation;

public class PersonalInformationFragment extends Fragment {
    private TextView name,weight,height;
    PersonalInformation information;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        SaveLoadData.loadDataPersonal(getActivity(),information);
        name = view.findViewById(R.id.title_name);
        weight = view.findViewById(R.id.weight_text);
        height = view.findViewById(R.id.height_text);
        try {
            name.setText(information.getFirstName() + " " + information.getLastName());
            weight.setText(Double.toString(information.getWeight()));
            height.setText(Double.toString(information.getHeight()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
