package com.morristaedt.mirror.modules.Forecast;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.morristaedt.mirror.R;

import java.util.HashMap;
import java.util.Map;

public class ForecastFragment extends Fragment {
    public enum Icons {CLOUD,WIND}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forecast_layout, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView weatherText = (TextView) getView().findViewById(R.id.weather_summary);

        View clearNight = (View)getView().findViewById(R.id.clear_night);
        View clearDay = (View)getView().findViewById(R.id.clear_day);
        View rain = (View)getView().findViewById(R.id.rain);
        View snow = (View)getView().findViewById(R.id.snow);
        View sleet = (View)getView().findViewById(R.id.sleet);
        View wind = (View)getView().findViewById(R.id.wind);
        View fog = (View)getView().findViewById(R.id.fog);
        View cloudy = (View)getView().findViewById(R.id.cloudy);
        View partlyCloudyDay = (View)getView().findViewById(R.id.partly_cloudy_day);
        View partlyCloudyNight = (View)getView().findViewById(R.id.partly_cloudy_night);
        View thunder = (View)getView().findViewById(R.id.thunder);

        Map<String, View> icons = new HashMap<>();
        icons.put("clear-night", clearNight);
        icons.put("clear-day", clearDay);
        icons.put("rain", rain);
        icons.put("snow", snow);
        icons.put("sleet", sleet);
        icons.put("wind", wind);
        icons.put("fog", fog);
        icons.put("cloudy", wind);
        icons.put("partly-cloudy-day", partlyCloudyDay);
        icons.put("partly-cloudy-night", partlyCloudyNight);
        icons.put("thunder", thunder);

        ForecastModule.getHourlyForecast(getResources(), new ForecastListener(weatherText, icons));
    }
}
