package com.srm.srmhack.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.srm.srmhack.R;

public class GeneratorFragment extends Fragment {

    LinearLayout linearLayout;
    View mainView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = getLayoutInflater().inflate(R.layout.fragment_generator , container, false);
        linearLayout = mainView.findViewById(R.id.linearLayoutGenerator);

        return mainView;
    }
}
