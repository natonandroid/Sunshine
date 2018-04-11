package com.example.android.sunshine.sync;//   (1) Create a class called SunshineSyncTask

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import java.net.URL;

public class SunshineSyncTask {

    //   (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather
    //  (3) Within syncWeather, fetch new weather data

    synchronized public static void syncWeather(Context context){

        try {
            URL weatherRequestUrl = NetworkUtils.getUrl(context);
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);
            ContentValues[] weatherValues = OpenWeatherJsonUtils.getWeatherContentValuesFromJson(context, jsonWeatherResponse);

            //  (4) If we have valid results, delete the old data and insert the new
            if (weatherValues != null && weatherValues.length != 0) {
                ContentResolver sunshineContentResolver = context.getContentResolver();

                sunshineContentResolver.delete(WeatherContract.WeatherEntry.CONTENT_URI,null, null);
                sunshineContentResolver.bulkInsert(WeatherContract.WeatherEntry.CONTENT_URI,weatherValues);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
