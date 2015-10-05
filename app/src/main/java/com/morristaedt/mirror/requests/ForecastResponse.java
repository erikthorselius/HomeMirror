package com.morristaedt.mirror.requests;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by HannahMitt on 8/23/15.
 */
public class ForecastResponse {

    float latitude;
    float longitude;

    public ForecastCurrently currently;
    public ForecastDaily daily;
    public ForecastHourly hourly;

    public class ForecastCurrently {
        public String summary;
        public float temperature;
        public String icon;
        public float temperatureMax;
        public float temperatureMin;
    }

    public class ForecastDaily {
        public String summary;
        public float temperature;
        public String icon;
        public List<DailyDataPoint> data;

        public String getDisplayTemperature() {
            return String.valueOf(Math.round(temperature)) + (char) 0x00B0;
        }
    }

    public class ForecastHourly {
        String summary;
        public ArrayList<Hour> data;
    }

    public class Hour {
        public long time; // in seconds
        public String summary;
        public String precipType;
        public float precipProbability;
        public float temperature;

        public Calendar getCalendar() {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(time * 1000);
            return calendar;
        }
    }

    public class DailyDataPoint {
        public String precipIntensityMax;
        public String ozone;
        public String cloudCover;
        public String windSpeed;
        public String sunriseTime;
        public String visibility;
        public String dewPoint;
        public String sunsetTime;
        public String apparentTemperatureMin;
        public String apparentTemperatureMinTime;
        public String temperatureMaxTime;
        public String humidity;
        public float temperatureMax;
        public float temperatureMin;
        public String windBearing;
        public String apparentTemperatureMax;
        public LocalDate time;
        public String temperatureMinTime;
        public String pressure;
        public String precipProbability;
        public String moonPhase;
        public String precipIntensity;
        public String icon;
        public String apparentTemperatureMaxTime ;
        public String summary;
    }
}
