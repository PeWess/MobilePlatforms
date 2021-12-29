package org.rudn.sdkritskiy.weatherservice;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitiesActivity extends AppCompatActivity {
    TextView txt;
    ArrayList<String> cities = new ArrayList<String>(Arrays.asList("Moscow", "Paris", "Penza", "Sochi", "Berlin", "Oslo", "New_York", "Madrid"));
    ArrayList<String> cities_weather = new ArrayList<String>();
    WeatherAPI.APIInterface api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        txt = findViewById(R.id.LastCity);
        api = WeatherAPI.getClient().create(WeatherAPI.APIInterface.class);
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.CitiesList);
        CityListAdapter adapter = new CityListAdapter(this, cities_weather);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData()
    {
        for(int i = 0; i < cities.size(); i++)
        {
            WeatherForCity(cities.get(i));
            cities_weather.add(txt.getText().toString());
        }
    }

    private void WeatherForCity(String city)
    {
        String units = "metric";
        String key = WeatherAPI.key;
        String lang = "en";
        Call<InfoForDay> callDay = api.GetToday(city, key, units, lang);
        callDay.enqueue(new Callback<InfoForDay>() {
            @Override
            public void onResponse(Call<InfoForDay> call, Response<InfoForDay> response) {
                InfoForDay data = response.body();

                if(response.isSuccessful())
                    txt.setText("Date: " + data.GetCurrentDate().getTime() + "\nCity: " + data.GetCity() + "\nTemperature now: " + data.GetTemp() +
                            "\nColdest temperature for today: " + data.GetMin() +  "\nWarmest temperature for today: " + data.GetMax());
            }

            @Override
            public void onFailure(Call<InfoForDay> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}