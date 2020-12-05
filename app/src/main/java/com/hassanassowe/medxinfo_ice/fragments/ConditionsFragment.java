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
import com.hassanassowe.medxinfo_ice.adapters.ConditionsAdapter;
import com.hassanassowe.medxinfo_ice.classes.SaveLoadData;
import com.hassanassowe.medxinfo_ice.objects.Condition;

import java.util.ArrayList;

public class ConditionsFragment extends Fragment {
    // Add RecyclerView member
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ConditionsAdapter mAdapter;
    private ArrayList<Condition> conditions; //Stored instances of Connected PI's
    private ConstraintLayout error,header;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conditions, container, false);
        error = view.findViewById(R.id.conditions_error);
        header = view.findViewById(R.id.conditions_header);

        recyclerView = (RecyclerView) view.findViewById(R.id.conditions_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        conditions = new ArrayList<>();
        SaveLoadData.loadDataCondition(getActivity(), conditions);

        if(!conditions.isEmpty()){
            error.setVisibility(View.GONE);
            header.setVisibility(View.VISIBLE);
        }

        mAdapter = new ConditionsAdapter(conditions);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }
}