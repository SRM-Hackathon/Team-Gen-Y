package com.srm.srmhack.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.timessquare.CalendarPickerView;
import com.srm.srmhack.R;
import com.srm.srmhack.TripActivity;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class GeneratorFragment extends Fragment {

    LinearLayout linearLayout;
    View mainView;
    EditText dateEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = getLayoutInflater().inflate(R.layout.fragment_generator , container, false);
        linearLayout = mainView.findViewById(R.id.linearLayoutGenerator);
        Button button = mainView.findViewById(R.id.generateButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TripActivity.class));
            }
        });

        dateEditText = mainView.findViewById(R.id.dateGen);
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                View view = getLayoutInflater().inflate(R.layout.calendar_dialog , null);
                alert.setView(view);
                final AlertDialog alertDialog = alert.create();
                alertDialog.show();

                Date date = new Date();
                Calendar nextYear  = Calendar.getInstance();
                nextYear.add(Calendar.YEAR , 1);

                final CalendarPickerView calendarPickerView = view.findViewById(R.id.calendarMain);
                calendarPickerView.init(date, nextYear.getTime())
                        .inMode(CalendarPickerView.SelectionMode.RANGE)
                        .withSelectedDate(date);
                ImageView backImage = view.findViewById(R.id.backCalendar);

                backImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                RelativeLayout relativeLayout = view.findViewById(R.id.relativeMain);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (Date date1: calendarPickerView.getSelectedDates()){
                            Log.v("TAG",DateFormat.getDateInstance(DateFormat.FULL).format(date1));
                        }
                        alertDialog.dismiss();
                    }
                });

                calendarPickerView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
                    @Override
                    public void onDateSelected(Date date) {
                        String selectDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);
                        Toast.makeText(getActivity(), ""+selectDate, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDateUnselected(Date date) {

                    }
                });


            }
        });

        return mainView;
    }
}
