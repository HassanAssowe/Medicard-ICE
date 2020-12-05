package com.hassanassowe.medxinfo_ice.fragments;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.adapters.AllergiesAdapter;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.Allergy;

import java.util.ArrayList;

public class AllergiesFragment extends Fragment {

    // Add RecyclerView member
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AllergiesAdapter mAdapter;
    private ArrayList<Allergy> allergies; //Stored instances of Connected PI's
    private ConstraintLayout error,header;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_allergies, container, false);
        error = view.findViewById(R.id.allergy_error);
        header = view.findViewById(R.id.allergy_header);

        recyclerView = (RecyclerView) view.findViewById(R.id.allergies_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        allergies = new ArrayList<>();
        SaveLoadData.loadDataAllergy(getActivity(), allergies);

        if(!allergies.isEmpty()){
            error.setVisibility(View.GONE);
            header.setVisibility(View.VISIBLE);
        }

        mAdapter = new AllergiesAdapter (allergies);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}