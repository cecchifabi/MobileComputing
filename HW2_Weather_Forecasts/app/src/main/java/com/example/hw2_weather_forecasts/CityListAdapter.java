package com.example.hw2_weather_forecasts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.WordViewHolder> {

    private final LinkedList<String> mCityList;
    private LayoutInflater mInflater;
    private Context context;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView wordItemView;
        final CityListAdapter mAdapter;
        private Context context;

        public WordViewHolder(View itemView, CityListAdapter adapter, Context context) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String element = mCityList.get(mPosition);

            // Only if I'm not on a tablet
            Intent intent = new Intent(context, SecondActivity.class);
            context.startActivity(intent, new Bundle());
        }
    }

    public CityListAdapter(FragmentA context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context.getActivity());
        this.mCityList = wordList;
        this.context = context.getContext();
    }

    @NonNull
    @Override
    public CityListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.citylist_item, parent, false);
        return new WordViewHolder(mItemView, this, this.context);
    }

    @Override
    public void onBindViewHolder(@NonNull CityListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mCityList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCityList.size();
    }
}