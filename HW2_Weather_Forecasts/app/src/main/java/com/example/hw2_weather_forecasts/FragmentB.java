package com.example.hw2_weather_forecasts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentB#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentB extends Fragment {

    private City city;
    private TextView t_city, t_coord, t_curr_time, t_timezone, t_curr_temp, t_curr_press, t_curr_humidity, t_curr_cloudiness;

    public FragmentB() {
        // Required empty public constructor
    }

    public static FragmentB newInstance(City city) {
        FragmentB fragment = new FragmentB();
        Bundle args = new Bundle();
        args.putString("CITY", city.getName());
        args.putDouble("LAT", city.getLat());
        args.putDouble("LON", city.getLon());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = new City(getArguments().getString("CITY"),
                    getArguments().getDouble("LAT"), getArguments().getDouble("LON"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =
                inflater.inflate(R.layout.fragment_b, container, false);

        t_city = rootView.findViewById(R.id.city_name);
        t_city.setText(city.getName());

        t_coord = rootView.findViewById(R.id.coordinates);
        t_coord.setText("(" + city.getLat() + ", " + city.getLon() + ")");

        t_curr_time = rootView.findViewById(R.id.current_time);
        t_timezone = rootView.findViewById(R.id.timezone);
        t_curr_temp = rootView.findViewById(R.id.current_temperature);
        t_curr_press = rootView.findViewById(R.id.current_pressure);
        t_curr_humidity = rootView.findViewById(R.id.current_humidity);
        t_curr_cloudiness = rootView.findViewById(R.id.current_cloudiness);

        // Call the API
        AndroidNetworking.get("https://api.openweathermap.org/data/2.5/onecall")
                .addQueryParameter("lat", city.getLat() + "")
                .addQueryParameter("lon", city.getLon() + "")
                .addQueryParameter("appid", "2b569dbfa383ec48418ddac21c493a6a")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // do anything with response
                        //t_msg.setText(response.toString());
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error (error on parsing)
                        String msg = error.toString();
                        while(msg.charAt(0) != '{') {
                            msg = msg.substring(1);
                        }
                        while(msg.charAt(msg.length() - 1) != '}') {
                            msg = msg.substring(0, msg.length() - 1);
                        }

                        // Parse the JSON
                        JSONObject reader;
                        try {
                            reader = new JSONObject(msg);
                            String timezone  = reader.getString("timezone");
                            t_timezone.setText(timezone);
                            JSONObject current  = reader.getJSONObject("current");
                            long c_time = current.getLong("dt") * 1000;
                            String tmp = new java.util.Date(c_time).toString();
                            t_curr_time.setText(tmp);
                            double c_temperature = (current.getDouble("temp") - 273.15);
                            t_curr_temp.setText(String.format("%.2f °C", c_temperature));
                            double c_pressure = current.getDouble("pressure");
                            t_curr_press.setText(c_pressure + " hPa");
                            double c_humidity = current.getDouble("humidity");
                            t_curr_humidity.setText(c_humidity + "%");
                            double c_cloudiness = current.getDouble("clouds");
                            t_curr_cloudiness.setText(c_cloudiness + "%");
                        } catch(Exception e) {
                           Log.i("Exception", e.toString());
                        }
                    }
                });


        // Return the View for the fragment's UI.
        return rootView;
    }
}
