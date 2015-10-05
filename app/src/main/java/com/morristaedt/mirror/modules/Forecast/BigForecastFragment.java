package com.morristaedt.mirror.modules.Forecast;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.morristaedt.mirror.R;

import java.util.Observable;
import java.util.Observer;

public class BigForecastFragment extends Fragment implements Observer {
    TextView bigTextView;
    TextView smallTextView;
    ViewGroup iconView;
    private IconFactory iconFactory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.big_forecast_fragment, container, false);
        return inflate;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        iconFactory = new IconFactory(getActivity().getApplicationContext());
        bigTextView = (TextView)getView().findViewById(R.id.big_text);
        smallTextView = (TextView)getView().findViewById(R.id.small_text);
        iconView = (ViewGroup)getView().findViewById(R.id.icon_container);
    }

    @Override
    public void update(Observable observable, Object data) {
        ForecastModel model = (ForecastModel) data;
        bigTextView.setText(model.getCurrentTemperature());
        smallTextView.setText(model.getCurrentMinMaxTemperature());
        iconView.removeAllViews();
        iconView.addView(iconFactory.getIcon(model.getCurrentIcon()));
    }
}