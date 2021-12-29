package org.rudn.sdkritskiy.weatherservice;

import android.content.Context;

import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.ViewHolder>
{
    private final LayoutInflater inflater;
    private final List<String> cities_info;

    CityListAdapter(Context context, List<String> cities)
    {
        this.cities_info = cities;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CityListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CityListAdapter.ViewHolder holder, int position)
    {
        String city = cities_info.get(position);
        holder.weather_info.setText(city);
    }

    @Override
    public int getItemCount() {
        return cities_info.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        final TextView weather_info;
        ViewHolder(View v)
        {
            super(v);
            weather_info = v.findViewById(R.id.CityWeathertxt);
        }
    }
}
