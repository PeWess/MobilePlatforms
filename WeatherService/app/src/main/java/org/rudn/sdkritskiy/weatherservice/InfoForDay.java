package org.rudn.sdkritskiy.weatherservice;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

public class InfoForDay {
    public class Temperature
    {
        double temp;
        double temp_min;
        double temp_max;
    }

    @SerializedName("main")
    private Temperature current_temp;

    @SerializedName("name")
    private String user_city;

    @SerializedName("dt")
    private long current_time;

    @SerializedName("timezone")
    private long current_timezone;

    public String GetTemp(){return String.valueOf(current_temp.temp);}
    public String GetMin(){return String.valueOf(current_temp.temp_min);}
    public String GetMax(){return String.valueOf(current_temp.temp_max);}
    public String GetCity(){return user_city;}

    public InfoForDay(Temperature temp)
    {
        current_temp = temp;
    }

    public Calendar GetCurrentDate()
    {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis((current_time * 1000) + (current_timezone * 1000));
        return date;
    }
}
