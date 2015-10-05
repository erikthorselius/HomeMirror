package com.morristaedt.mirror.modules.Forecast;

import android.support.annotation.NonNull;

import com.morristaedt.mirror.requests.ForecastResponse;
import org.joda.time.LocalDate;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class ForecastModel {
    private ForecastResponse forecastResponse;

    public ForecastModel(ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }

    public String getCurrentTemperature() {
        return floatToTemperature(forecastResponse.currently.temperature);
    }

    public String getCurrentMinMaxTemperature() {
        return getMinMaxTemperature(new LocalDate());
     }

    public String getMinMaxTemperature(LocalDate targetDate) {
        ForecastResponse.DailyDataPoint data = findDayByDate(targetDate);
        return floatToTemperature(data.temperatureMin) + "/" + floatToTemperature(data.temperatureMax);
    }

    @NonNull
    private String floatToTemperature(float temp) {
        return String.valueOf(Math.round(temp)) + (char) 0x00B0;
    }

    public String getCurrentIcon() {
        return forecastResponse.currently.icon;
    }
    public String getIcon(LocalDate targetDate) {
        ForecastResponse.DailyDataPoint data = findDayByDate(targetDate);
        return data.icon;
    }
    private ForecastResponse.DailyDataPoint findDayByDate(LocalDate targetDate) {
        for (ForecastResponse.DailyDataPoint data :
                forecastResponse.daily.data) {
            if(targetDate.equals(data.time)) {
                return data;
            }
        }
        return null;
    }

    public String getWeekDay(LocalDate targetDate) {
        ForecastResponse.DailyDataPoint dayByDate = findDayByDate(targetDate);
        int day = dayByDate.time.getDayOfWeek();
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(Locale.ENGLISH);
        return dfs.getWeekdays()[day % 7 + 1].substring(0,1);
    }
}
