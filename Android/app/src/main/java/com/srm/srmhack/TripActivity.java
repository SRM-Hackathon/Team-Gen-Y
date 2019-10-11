package com.srm.srmhack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TripActivity extends AppCompatActivity {

    Toolbar toolbar;

    ListView listView;

    ArrayList<String> arrayList =new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        toolbar = findViewById(R.id.toolbarTrip);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        arrayList.add("Day");
        arrayList.add("Loc");
        arrayList.add("link");
        arrayList.add("Stay");
        arrayList.add("link");
        arrayList.add("Stay");
        arrayList.add("link");
        arrayList.add("Stay");
        arrayList.add("Day");
        arrayList.add("Loc");
        arrayList.add("link");
        arrayList.add("Stay");
        arrayList.add("link");
        arrayList.add("Stay");

        listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter());
    }

    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (arrayList.get(position).equals("Day")){
                convertView = getLayoutInflater().inflate(R.layout.day_list , null);
            }else if(arrayList.get(position).equals("Loc")) {
                convertView = getLayoutInflater().inflate(R.layout.location_card_list , null);
            }else if(arrayList.get(position).equals("link")) {
                convertView = getLayoutInflater().inflate(R.layout.time_list , null);
            }else if(arrayList.get(position).equals("Stay")) {
                convertView = getLayoutInflater().inflate(R.layout.stay_card_list , null);
            }
            return convertView;
        }
    }
}
