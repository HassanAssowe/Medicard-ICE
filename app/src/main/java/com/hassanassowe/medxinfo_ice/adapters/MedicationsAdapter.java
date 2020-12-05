package com.hassanassowe.medxinfo_ice.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.objects.Medication;

import java.util.ArrayList;

public class MedicationsAdapter extends RecyclerView.Adapter<MedicationsAdapter.MedicationHolder> {
    private ArrayList<Medication> medications;

    public MedicationsAdapter(ArrayList<Medication> contacts) {
        this.medications = contacts;
    }

    @NonNull
    @Override
    public MedicationHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entity_contact, parent, false);
        return new MedicationHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicationHolder holder, int position) {
        Medication currentMedication = medications.get(position);
        holder.title.setText(currentMedication.getTitle());
        holder.dosage.setText(currentMedication.getDosage());
        holder.description.setText(currentMedication.getDescription());
        holder.vertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(view.getContext(), holder.vertButton);
                //inflating menu from xml resource
                popup.inflate(R.menu.listentity_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    Intent intent;

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                return true;

                            case R.id.delete:
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return medications.size();
    }


    class MedicationHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView dosage;
        private TextView description;
        private ImageButton vertButton;

        public MedicationHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.medication_title_entity);
            dosage = itemView.findViewById(R.id.medication_dosage_text_entity);
            description = itemView.findViewById(R.id.medication_description_text_entity);
            vertButton = itemView.findViewById(R.id.medication_vert_button);
        }
    }
}