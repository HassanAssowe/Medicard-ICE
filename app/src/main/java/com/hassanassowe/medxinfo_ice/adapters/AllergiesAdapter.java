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
import com.hassanassowe.medxinfo_ice.objects.Allergy;

import java.util.ArrayList;

public class AllergiesAdapter extends RecyclerView.Adapter<AllergiesAdapter.AllergyHolder> {
    private ArrayList<Allergy> allergies;

    public AllergiesAdapter(ArrayList<Allergy> allergies) {
        this.allergies = allergies;
    }

    @NonNull
    @Override
    public AllergiesAdapter.AllergyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entity_contact, parent, false);
        return new AllergiesAdapter.AllergyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AllergiesAdapter.AllergyHolder holder, int position) {
        Allergy currentAllergy = allergies.get(position);
        holder.title.setText(currentAllergy.getName());
        holder.symptoms.setText(currentAllergy.getSymptoms());
        holder.treatment.setText(currentAllergy.getTreatmentInstructions());
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
        return allergies.size();
    }


    class AllergyHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView symptoms;
        private TextView treatment;
        private ImageButton vertButton;

        public AllergyHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.allergy_title_entity);
            symptoms = itemView.findViewById(R.id.allergy_symptoms_text_entity);
            treatment = itemView.findViewById(R.id.allergy_symptoms_text_entity);
            vertButton = itemView.findViewById(R.id.allergy_vert_button);
        }
    }
}