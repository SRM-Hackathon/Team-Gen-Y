package com.srm.srmhack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LiveActivity extends AppCompatActivity {

    ArrayList arrayList;
    Toolbar toolbar;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        toolbar = findViewById(R.id.toolbarTrip);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        arrayList = new ArrayList();
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

        listView = findViewById(R.id.listMyTrips);
        listView.setAdapter(new CustomAdapter());

    }

    public class CustomAdapter extends BaseAdapter {

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
            if (arrayList.get(position).equals("Day")) {
                convertView = getLayoutInflater().inflate(R.layout.day_list, null);
            } else if (arrayList.get(position).equals("Loc")) {
                convertView = getLayoutInflater().inflate(R.layout.location_trip_list, null);
                TextView imageView = convertView.findViewById(R.id.editImage);

            } else if (arrayList.get(position).equals("link")) {
                convertView = getLayoutInflater().inflate(R.layout.time_list, null);
                RelativeLayout relativeLayout = convertView.findViewById(R.id.plusButton);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LiveActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.details_dialog, null);
                        builder.setView(view);
                        builder.create();
                        builder.show();
                    }
                });
            } else if (arrayList.get(position).equals("Stay")) {
                convertView = getLayoutInflater().inflate(R.layout.stay_trip_list, null);
                ImageView imageView = convertView.findViewById(R.id.stayImage);
                Glide.with(LiveActivity.this).load("https://upload.wikimedia.org/wikipedia/commons/b/b3/Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006_%28square%29.jpg").into(imageView);
                TextView editImage = convertView.findViewById(R.id.editImage);
            }
            return convertView;
        }
    }

}
