package com.srm.srmhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.timessquare.CalendarPickerView;
import com.srm.srmhack.Fragment.DiscoverFragment;
import com.srm.srmhack.Fragment.GeneratorFragment;
import com.srm.srmhack.Fragment.GuideFragment;
import com.srm.srmhack.Fragment.ProfileFragment;
import com.srm.srmhack.Fragment.TripsFragment;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new GeneratorFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_create:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new GeneratorFragment()).commit();
                        return true;
                    case R.id.navigation_discover:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new DiscoverFragment()).commit();
                        return true;
                    case R.id.navigation_trips:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new TripsFragment()).commit();
                        return true;
                    case R.id.navigation_guid:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new GuideFragment()).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
                        return true;
                    default:
                        return false;

                }
            }
        });


//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.YEAR , 1);

//        final CalendarPickerView calendarPickerView = findViewById(R.id.calendarView);
//        calendarPickerView.init(date,calendar.getTime())
//                .inMode(CalendarPickerView.SelectionMode.RANGE)
//                .withSelectedDate(date);
//
//        calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(Date date) {
//                for(Date d: calendarPickerView.getSelectedDates()){
//                    String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(d);
//                    Log.v("TAG",selectedDate);
//                }
//            }
//
//            @Override
//            public void onDateUnselected(Date date) {
//
//            }
//        });


    }
}
