package com.srm.srmhack.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.srm.srmhack.LiveActivity;
import com.srm.srmhack.R;
import com.srm.srmhack.TripActivity;

public class TripsFragment extends Fragment {

    View mainView;
    ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = getLayoutInflater().inflate(R.layout.fragment_trips , container, false);
        listView = mainView.findViewById(R.id.listMyTrips);
        listView.setAdapter(new CustomTripAdapter());
        return mainView;
    }

    public class CustomTripAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 2;
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
            convertView = getLayoutInflater().inflate(R.layout.card_trip_each , null);
            Button start = convertView.findViewById(R.id.startTrip);
            start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getActivity() , LiveActivity.class));
                }
            });
            return convertView;
        }
    }
}
