package com.srm.srmhack.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.srm.srmhack.R;
import com.srm.srmhack.TripActivity;

public class GeneratorFragment extends Fragment {

    LinearLayout linearLayout;
    View mainView;
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
        return mainView;
    }
}
