package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nataliac on 4/3/18.
 */


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;

    public ForecastAdapter(){
    }

    @Override
    public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachImmediately = false;

        View view = inflater.inflate(R.layout.forecast_list_item, parent, attachImmediately);
        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
        holder.mWeatherTextView.setText( mWeatherData[position] );
    }

    @Override
    public int getItemCount() {
        if (mWeatherData == null )
            return 0;
        return mWeatherData.length;
    }


    public void setWeatherData(String[] weatherData){
        if (weatherData != null ){
            mWeatherData = new String[weatherData.length];
            System.arraycopy( weatherData, 0, mWeatherData, 0, weatherData.length );
        }
        else {
            mWeatherData = null;
        }

        notifyDataSetChanged();
    }


    public class ForecastAdapterViewHolder extends ViewHolder{

        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }
    }
}



