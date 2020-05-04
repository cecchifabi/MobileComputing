package com.example.hw2_weather_forecasts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;


public class FragmentA extends Fragment {
    private final LinkedList<City> mCityList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private CityListAdapter mAdapter;

    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance(String param1, String param2) {
        FragmentA fragment = new FragmentA();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        mCityList.addLast(new City("Aveiro", 40.6446368,-8.6490592));
        mCityList.addLast(new City("Faro", 37.0177845,-7.9749515));
        mCityList.addLast(new City("Venezia", 45.4044576,12.2472495));
        mCityList.addLast(new City("Roma", 41.909986,12.3959141));
        mCityList.addLast(new City("Rio de Janeiro", -22.9138851,-43.7261745));
        mCityList.addLast(new City("Tokyo", 35.5040537,138.6486344));

        // Get a handle to the RecyclerView.
        mRecyclerView = rootView.findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new CityListAdapter(this, mCityList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        // Return the View for the fragment's UI.
        return rootView;
    }
}
