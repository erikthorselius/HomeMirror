package com.morristaedt.mirror.modules.Forecast;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.morristaedt.mirror.R;

import org.joda.time.LocalDate;

import java.util.Observable;
import java.util.Observer;

public class SmallForecastFragment extends Fragment implements Observer {
    TextView minMaxTemp;
    TextView weekday;
    ViewGroup iconView;
    private IconFactory iconFactory;
    private int dayOffset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.small_forecast_fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iconFactory = new IconFactory(getActivity().getApplicationContext(), IconFactory.IconSize.SMALL);
        minMaxTemp = (TextView)getView().findViewById(R.id.temp_text);
        weekday = (TextView)getView().findViewById(R.id.day_text);
        iconView = (ViewGroup)getView().findViewById(R.id.icon_container);
        Bundle arguments = getArguments();
        dayOffset = arguments.getInt("dayOffset");
    }
    @Override
    public void update(Observable observable, Object data) {
        ForecastModel model = (ForecastModel) data;
        LocalDate targetDate = new LocalDate().plusDays(dayOffset);
        minMaxTemp.setText(model.getMinMaxTemperature(targetDate));
        weekday.setText(model.getWeekDay(targetDate));
        iconView.removeAllViews();
        iconView.addView(iconFactory.getIcon(model.getIcon(targetDate)));
    }
}
