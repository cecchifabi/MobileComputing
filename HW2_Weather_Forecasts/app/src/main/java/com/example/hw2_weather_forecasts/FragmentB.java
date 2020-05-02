package com.example.hw2_weather_forecasts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {

    private String city;

    public FragmentB() {
        // Required empty public constructor
    }

    public static FragmentB newInstance(String city) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString("CITY", city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = getArguments().getString("CITY");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_b, container, false);

        TextView t = rootView.findViewById(R.id.text);
        t.setText(city);

        // Call the API
        // ...


        // Return the View for the fragment's UI.
        return rootView;
    }
}
