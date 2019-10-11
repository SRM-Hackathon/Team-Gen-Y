package com.srm.srmhack;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PreferenceActivity extends AppCompatActivity {

    Button continueButton;

    ImageView image1;
    ImageView check1;
    ImageView image2;
    ImageView check2;
    ImageView image3;
    ImageView check3;
    ImageView image4;
    ImageView check4;
    ImageView image5;
    ImageView check5;
    ImageView image6;
    ImageView check6;
    ImageView image7;
    ImageView check7;
    ImageView image8;
    ImageView check8;
    ImageView image9;
    ImageView check9;
    ImageView image10;
    ImageView check10;
    ImageView image11;
    ImageView check11;
    ImageView image12;
    ImageView check12;

    boolean[] isChecked = new boolean[]{
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        continueButton = findViewById(R.id.preferenceButton);

        image1 = findViewById(R.id.image1);
        check1 = findViewById(R.id.check1);
        image2 = findViewById(R.id.image2);
        check2 = findViewById(R.id.check2);
        image3 = findViewById(R.id.image3);
        check3 = findViewById(R.id.check3);
        image4 = findViewById(R.id.image4);
        check4 = findViewById(R.id.check4);
        image5 = findViewById(R.id.image5);
        check5 = findViewById(R.id.check5);
        image6 = findViewById(R.id.image6);
        check6 = findViewById(R.id.check6);
        image7 = findViewById(R.id.image7);
        check7 = findViewById(R.id.check7);
        image8 = findViewById(R.id.image8);
        check8 = findViewById(R.id.check8);
        image9 = findViewById(R.id.image9);
        check9 = findViewById(R.id.check9);
        image10 = findViewById(R.id.image10);
        check10 = findViewById(R.id.check10);
        image11 = findViewById(R.id.image11);
        check11 = findViewById(R.id.check11);
        image12 = findViewById(R.id.image12);
        check12 = findViewById(R.id.check12);


        image1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[0]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check1.setVisibility(View.VISIBLE);
                    image1.setForeground(drawable);
                    isChecked[0] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check1.setVisibility(View.INVISIBLE);
                    image1.setForeground(drawable);
                    isChecked[0] = false;
                }
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[1]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check2.setVisibility(View.VISIBLE);
                    image2.setForeground(drawable);
                    isChecked[1] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check2.setVisibility(View.INVISIBLE);
                    image2.setForeground(drawable);
                    isChecked[1] = false;
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(!isChecked[2]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check3.setVisibility(View.VISIBLE);
                    image3.setForeground(drawable);
                    isChecked[2] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check3.setVisibility(View.INVISIBLE);
                    image3.setForeground(drawable);
                    isChecked[2] = true;
                }
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[3]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check4.setVisibility(View.VISIBLE);
                    image4.setForeground(drawable);
                    isChecked[3] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check4.setVisibility(View.INVISIBLE);
                    image4.setForeground(drawable);
                    isChecked[3] = false;
                }
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[4]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check5.setVisibility(View.VISIBLE);
                    image5.setForeground(drawable);
                    isChecked[4] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check5.setVisibility(View.INVISIBLE);
                    image5.setForeground(drawable);
                    isChecked[4] = false;
                }
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[5]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check6.setVisibility(View.VISIBLE);
                    image6.setForeground(drawable);
                    isChecked[5] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check6.setVisibility(View.INVISIBLE);
                    image6.setForeground(drawable);
                    isChecked[5] = false;
                }
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[6]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check7.setVisibility(View.VISIBLE);
                    image7.setForeground(drawable);
                    isChecked[6] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check7.setVisibility(View.INVISIBLE);
                    image7.setForeground(drawable);
                    isChecked[6] = false;
                }
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[7]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check8.setVisibility(View.VISIBLE);
                    image8.setForeground(drawable);
                    isChecked[7] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check8.setVisibility(View.INVISIBLE);
                    image8.setForeground(drawable);
                    isChecked[7] = false;
                }
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[8]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check9.setVisibility(View.VISIBLE);
                    image9.setForeground(drawable);
                    isChecked[8] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check9.setVisibility(View.INVISIBLE);
                    image9.setForeground(drawable);
                    isChecked[8] = false;
                }
            }
        });

        image10.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[9]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check10.setVisibility(View.VISIBLE);
                    image10.setForeground(drawable);
                    isChecked[9] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check10.setVisibility(View.INVISIBLE);
                    image10.setForeground(drawable);
                    isChecked[9] = false;
                }
            }
        });

        image11.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[10]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check11.setVisibility(View.VISIBLE);
                    image11.setForeground(drawable);
                    isChecked[10] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check11.setVisibility(View.INVISIBLE);
                    image11.setForeground(drawable);
                    isChecked[10] = false;
                }
            }
        });

        image12.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if (!isChecked[11]){
                    final int color = 0x707070FF;
                    final Drawable drawable = new ColorDrawable(color);
                    check12.setVisibility(View.VISIBLE);
                    image12.setForeground(drawable);
                    isChecked[11] = true;
                }else {
                    final int color = 0x00000000;
                    final Drawable drawable = new ColorDrawable(color);
                    check12.setVisibility(View.INVISIBLE);
                    image12.setForeground(drawable);
                    isChecked[11] = false;
                }
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo: Send Fata to backend of saved priority
                startActivity(new Intent(PreferenceActivity.this, HomeActivity.class));
            }
        });
    }
}
