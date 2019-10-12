package com.srm.srmhack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class TripActivity extends AppCompatActivity {

    Toolbar toolbar;

    ListView listView;

    ArrayList<String> arrayList = new ArrayList<>();
    EditText name;


    ArrayList<String> orderList = new ArrayList<>();
    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> costList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);
        toolbar = findViewById(R.id.toolbarTrip);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.43.88:"+getResources().getString(R.string.port)+"/itenary/generateTrip", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i= 0;i<jsonArray.length() ; i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        orderList.add(jsonObject.getString("order"));
                        nameList.add(jsonObject.getString("name"));
                        costList.add(jsonObject.getString("cost"));

                    }
                    listView.setAdapter(new CustomAdapter());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        MySending.getInstance(TripActivity.this).addToRequestQueue(stringRequest);

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

        name = findViewById(R.id.name);
        listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter());

    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return orderList.size();
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
                convertView = getLayoutInflater().inflate(R.layout.location_card_list, null);
                ImageView imageView = convertView.findViewById(R.id.editImage);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TripActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.details_dialog, null);
                        builder.setView(view);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();

                        LinearLayout deleteLayout  = view.findViewById(R.id.deleteEvent);
                        deleteLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, "192.168.43.88:5555", new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }){
                                    @Override
                                    protected Map<String, String> getParams() throws AuthFailureError {
                                        return super.getParams();
                                    }
                                };

                                MySending.getInstance(TripActivity.this).addToRequestQueue(stringRequest);
                            }
                        });

                    }
                });
            } else if (arrayList.get(position).equals("link")) {
                convertView = getLayoutInflater().inflate(R.layout.time_list, null);
                RelativeLayout relativeLayout = convertView.findViewById(R.id.plusButton);
                relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TripActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.add_event , null);
                        builder.setView(view);
                        builder.show();
                    }
                });


            } else if (arrayList.get(position).equals("Stay")) {
                convertView = getLayoutInflater().inflate(R.layout.stay_card_list, null);
                ImageView imageView = convertView.findViewById(R.id.stayImage);
                Glide.with(TripActivity.this).load("https://upload.wikimedia.org/wikipedia/commons/b/b3/Everest_North_Face_toward_Base_Camp_Tibet_Luca_Galuzzi_2006_%28square%29.jpg").into(imageView);
                ImageView editImage = convertView.findViewById(R.id.editImage);
                editImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(TripActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.details_dialog, null);
                        builder.setView(view);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                });
            }
            return convertView;
        }
    }
}
