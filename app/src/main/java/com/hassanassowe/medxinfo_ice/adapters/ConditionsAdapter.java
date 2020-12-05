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
import com.hassanassowe.medxinfo_ice.objects.Condition;

import java.util.ArrayList;

public class ConditionsAdapter extends RecyclerView.Adapter<ConditionsAdapter.ConditionHolder> {
    private ArrayList<Condition> conditions;

    public ConditionsAdapter (ArrayList<Condition> contacts) {
        this.conditions = contacts;
    }

    @NonNull
    @Override
    public ConditionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entity_contact, parent, false);
        return new ConditionsAdapter.ConditionHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ConditionsAdapter.ConditionHolder holder, int position) {
        Condition currentCondition = conditions.get(position);
        holder.title.setText(currentCondition.getTitle());
        holder.symptoms.setText(currentCondition.getSymptoms());
        holder.medications.setText(currentCondition.getMedication());
        holder.doctorSpecialst.setText(currentCondition.getDoctorSpecialst());

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
        return conditions.size();
    }


    class ConditionHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView symptoms;
        private TextView medications;
        private TextView doctorSpecialst;
        private ImageButton vertButton;

        public ConditionHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.condition_title_entity);
            symptoms = itemView.findViewById(R.id.condition_symptoms_text_entity);
            medications = itemView.findViewById(R.id.condition_medications_text_entity);
            doctorSpecialst = itemView.findViewById(R.id.condition_doctor_text_entity);
            vertButton = itemView.findViewById(R.id.condition_vert_button);

        }
    }
}
