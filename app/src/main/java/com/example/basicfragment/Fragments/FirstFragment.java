package com.example.basicfragment.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basicfragment.Classes.User;
import com.example.basicfragment.R;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_first, container, false);

        EditText etName = myView.findViewById(R.id.etName);
        EditText etAge = myView.findViewById(R.id.etAge);
        Button btnAdd = myView.findViewById(R.id.btnAdd);







        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String age = etAge.getText().toString().trim();

                if (name.isEmpty() || age.isEmpty()) {

                    Toast.makeText(getContext(), "Empty filed", Toast.LENGTH_SHORT).show();
                    return;

                } else {

                    User user = new User(name, age);

                    Bundle bundle = new Bundle();

                    bundle.putString("name", name);
                    bundle.putString("age", age);

                    SecondFragment secondFragment = new SecondFragment();

                    secondFragment.setArguments(bundle);

                    etName.setText(null);
                    etAge.setText(null);

                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragmentContainerView, secondFragment)
                            .commit();

                }

            }
        });

        return myView;


    }
}