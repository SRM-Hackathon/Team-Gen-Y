package com.srm.srmhack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreferenceActivity extends AppCompatActivity {

    Button continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        continueButton = findViewById(R.id.preferenceButton);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: Send Fata to backend of saved priority
                startActivity(new Intent(PreferenceActivity.this , HomeActivity.class));
            }
        });
    }
}
