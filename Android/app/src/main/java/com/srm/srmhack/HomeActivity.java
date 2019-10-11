package com.srm.srmhack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR , 1);

        final CalendarPickerView calendarPickerView = findViewById(R.id.calendarView);
        calendarPickerView.init(date,calendar.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(date);

        calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                for(Date d: calendarPickerView.getSelectedDates()){
                    String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(d);
                    Log.v("TAG",selectedDate);
                }
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
    }
}
