package com.morristaedt.mirror.modules.Forecast;

import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.morristaedt.mirror.R;
import com.morristaedt.mirror.requests.ForecastRequest;
import com.morristaedt.mirror.requests.ForecastResponse;
import com.morristaedt.mirror.utils.WeekUtil;

import java.util.Calendar;
import java.util.List;
import java.util.Observable;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.converter.GsonConverter;

/**
 * Created by HannahMitt on 8/22/15.
 */
public class ForecastModule extends Observable {
    public void getHourlyForecast(final Resources resources) {
        new AsyncTask<Void, Void, ForecastResponse>() {
            @Override
            protected ForecastResponse doInBackground(Void... params) {
                Gson gson = new GsonUnixTimestapConverter().createConverter();
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint("https://api.forecast.io")
                        .setErrorHandler(new ErrorHandler() {
                            @Override
                            public Throwable handleError(RetrofitError cause) {
                                Log.w("mirror", "Forecast error: " + cause);
                                return null;
                            }
                        }).setConverter(new GsonConverter(gson))
                        .build();
                ForecastRequest service = restAdapter.create(ForecastRequest.class);
                String excludes = "minutely,flags";
                String units = "si";
                Log.d("mirror", "backgrounddd");
                ForecastResponse hourlyForecast = service.getHourlyForecast(resources.getString(R.string.dark_sky_api_key),
                        Double.parseDouble(resources.getString(R.string.home_lat)),
                        Double.parseDouble(resources.getString(R.string.home_lon)), excludes, units);
                return hourlyForecast;
            }

            @Override
            protected void onPostExecute(ForecastResponse forecastResponse) {
                if (forecastResponse != null) {
                    setChanged();
                    notifyObservers(new ForecastModel(forecastResponse));
                }
            }
        };
    }
}
