package com.hassanassowe.medxinfo_ice.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.hassanassowe.medxinfo_ice.R;
import com.hassanassowe.medxinfo_ice.objects.Contacts;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactHolder> {
    private ArrayList<Contacts> contacts;

    public ContactsAdapter(ArrayList<Contacts> contacts){
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_entity_contact, parent, false);
        return new ContactHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactHolder holder, int position) {
        Contacts currentContact = contacts.get(position);
        holder.fullNameRelation.setText(currentContact.getFirstName()+" "+currentContact.getLastName()+" ("+currentContact.getRelation()+")");
        holder.phoneNumber.setText(currentContact.getPhoneNumber());
        holder.vertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a popup menu
                PopupMenu popup = new PopupMenu(view.getContext(), holder.vertButton);
                //inflating menu from xml resource
                popup.inflate(R.menu.listentity_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

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
    public int getItemCount(){
        return contacts.size();
    }


    class ContactHolder extends RecyclerView.ViewHolder{
        private TextView fullNameRelation;
        private TextView phoneNumber;
        private ImageButton vertButton;

        public ContactHolder(View itemView){
            super(itemView);
            fullNameRelation = itemView.findViewById(R.id.contact_entity_information);
            phoneNumber = itemView.findViewById(R.id.contact_entity_phoneNumber);
            vertButton = itemView.findViewById(R.id.vertButton);
        }
    }
}

