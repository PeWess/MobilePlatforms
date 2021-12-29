package org.rudn.sdkritskiy.weatherservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText user_city;
    TextView temperature_today;
    Button get_weather_btn;
    Button get_cities_weather_btn;
    WeatherAPI.APIInterface api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_city = findViewById(R.id.UserCitytxt);
        temperature_today = findViewById(R.id.Temperaturetxt);
        get_weather_btn = findViewById(R.id.GetWeatherbtn);
        get_cities_weather_btn = findViewById(R.id.GetCitiesbtn);
        api = WeatherAPI.getClient().create(WeatherAPI.APIInterface.class);

        get_weather_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!user_city.getText().toString().equals(""))
                {
                    GetWeather(v);
                }
            }
        });

        get_cities_weather_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CitiesActivity.class);
                MainActivity.this.startActivity(i);
            }
        });
    }

    public void GetWeather(View v)
    {
        String units = "metric";
        String key = WeatherAPI.key;
        String lang = "en";
        Call<InfoForDay> callDay = api.GetToday(user_city.getText().toString(), key, units, lang);
        callDay.enqueue(new Callback<InfoForDay>() {
            @Override
            public void onResponse(Call<InfoForDay> call, Response<InfoForDay> response) {
                InfoForDay data = response.body();

                if(response.isSuccessful())
                    temperature_today.setText("Date: " + data.GetCurrentDate().getTime() + "\nCity: " + data.GetCity() + "\nTemperature now: " + data.GetTemp() +
                            "\nColdest temperature for today: " + data.GetMin() +  "\nWarmest temperature for today: " + data.GetMax());
            }

            @Override
            public void onFailure(Call<InfoForDay> call, Throwable t) {
                Log.e("onFailure", t.toString());
            }
        });
    }
}