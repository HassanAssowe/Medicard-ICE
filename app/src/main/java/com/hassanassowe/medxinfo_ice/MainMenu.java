package com.hassanassowe.medxinfo_ice;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.hassanassowe.medxinfo_ice.activities.Allergies;
import com.hassanassowe.medxinfo_ice.activities.Conditions;
import com.hassanassowe.medxinfo_ice.activities.Contacts;
import com.hassanassowe.medxinfo_ice.activities.Medications;
import com.hassanassowe.medxinfo_ice.activities.PersonalInformation;
import com.hassanassowe.medxinfo_ice.activities.Settings;
import com.hassanassowe.medxinfo_ice.classes.ZoomOutPageTransformer;
import com.hassanassowe.medxinfo_ice.fragments.AllergiesFragment;
import com.hassanassowe.medxinfo_ice.fragments.ConditionsFragment;
import com.hassanassowe.medxinfo_ice.fragments.ContactsFragment;
import com.hassanassowe.medxinfo_ice.fragments.MedicationsFragment;
import com.hassanassowe.medxinfo_ice.fragments.PersonalInformationFragment;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainMenu extends AppCompatActivity {

    private static final int[] layouts = new int[]{
            R.layout.fragment_information,
            R.layout.fragment_conditions,
            R.layout.fragment_medication,
            R.layout.fragment_allergies,
            R.layout.fragment_contacts};

    private ViewPager viewPager;
    private ViewPagerAdapter myViewPagerAdapter;
    private static final int NUM_PAGES = 5;
    private static final int COUNTDOWN_TIMER = 10000;


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        changeStatusBarColor();


        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationListener);
        viewPager = findViewById(R.id.fragment_container);
        viewPager.setOffscreenPageLimit(1);
        myViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new PersonalInformationFragment()).commit();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.setAdapter(null);
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

            bottomNavigationView.getMenu().getItem(position).setChecked(true);

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }


        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    };

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    return new PersonalInformationFragment();
                case 1:
                    return new ConditionsFragment();
                case 2:
                    return new MedicationsFragment();
                case 3:
                    return new AllergiesFragment();
                case 4:
                    return new ContactsFragment();
                default:
                    return new Fragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.page_1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.page_2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.page_3:
                    viewPager.setCurrentItem(2);
                    break;

                case R.id.page_4:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.page_5:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return true;
        }
    };

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public void notifyContacts(View v){
        AlertDialog dialogBuilder = new AlertDialog.Builder(this, R.style.AlertDialogTheme_Center)
                .setTitle(R.string.notifying_contacts)
                .setMessage("")
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialogBuilder.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                TextView body = (TextView) dialogBuilder.findViewById(android.R.id.message);
                final Button defaultButton = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEGATIVE);
                new CountDownTimer(COUNTDOWN_TIMER, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        body.setText(String.format(
                                Locale.getDefault(), "%d",
                                TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) + 1));
                    }
                    @Override
                    public void onFinish() {
                        if (((AlertDialog) dialog).isShowing()) {
                            dialog.dismiss();
                        }
                    }
                }.start();
            }
        });
        dialogBuilder.show();
    }

    public void findHospital(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Hospitals");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void personalInformation(View v) {
        Intent intent = new Intent(this, PersonalInformation.class);
        startActivity(intent);
    }

    public void contacts(View v) {
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);
    }

    public void allergies(View v) {
        Intent intent = new Intent(this, Allergies.class);
        startActivity(intent);
    }

    public void conditions(View v) {
        Intent intent = new Intent(this, Conditions.class);
        startActivity(intent);
    }

    public void medications(View v) {
        Intent intent = new Intent(this, Medications.class);
        startActivity(intent);
    }

    public void settings(View v) {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }

}