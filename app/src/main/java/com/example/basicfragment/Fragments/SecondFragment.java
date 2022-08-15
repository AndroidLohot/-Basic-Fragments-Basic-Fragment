package com.example.basicfragment.Fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.basicfragment.R;

public class SecondFragment extends Fragment {


    private String name;
    private String age;

    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();

        if (bundle != null) {

            name = bundle.getString("name");
            age = bundle.getString("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_second, container, false);

        TextView tvName = myView.findViewById(R.id.tvName);
        TextView tvAge = myView.findViewById(R.id.tvAge);

        tvName.setText(name);
        tvAge.setText(age);

        return myView;
    }
}