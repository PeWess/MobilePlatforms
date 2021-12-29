package org.rudn.sdkritskiy.weatherservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class WeatherAPI {
    public static String key = "8a92fe0e253fcdee2180b489142407db";
    public static final String base_url = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit retrofit = null;

    public interface APIInterface
    {
        @GET("weather")
        Call<InfoForDay> GetToday(
                @Query("q") String user_city,
                @Query("appid") String key,
                @Query("units") String units,
                @Query("lang") String lang
        );

        @GET("forecast")
        Call<ArrayList<InfoForDay>> GetList(
                @Query("q") String user_city,
                @Query("appid") String key,
                @Query("units") String units,
                @Query("lang") String lang
        );
    }

    public static Retrofit getClient()
    {
        if(retrofit == null)
            retrofit = new Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build();

        return  retrofit;
    }
}
