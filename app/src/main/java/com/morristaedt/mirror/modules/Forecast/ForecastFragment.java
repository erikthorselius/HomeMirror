package com.morristaedt.mirror.modules.Forecast;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.morristaedt.mirror.R;

public class ForecastFragment extends Fragment {
    ForecastModule forecastModule;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forecastModule = new ForecastModule();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.forecast_big_fragment, createBigForecastFragment());
        fragmentTransaction.add(R.id.forecast_small_fragment_1, getSmallForecastFragment(1));
        fragmentTransaction.add(R.id.forecast_small_fragment_2, getSmallForecastFragment(2));
        fragmentTransaction.add(R.id.forecast_small_fragment_3, getSmallForecastFragment(3));
        fragmentTransaction.add(R.id.forecast_small_fragment_4, getSmallForecastFragment(4));
        fragmentTransaction.add(R.id.forecast_small_fragment_5, getSmallForecastFragment(5));
        fragmentTransaction.commit();
    }

    @NonNull
    private SmallForecastFragment getSmallForecastFragment(int dayOffset) {
        Bundle bundle = new Bundle();
        bundle.putInt("dayOffset", dayOffset);
        SmallForecastFragment smallForecastFragment = new SmallForecastFragment();
        smallForecastFragment.setArguments(bundle);
        forecastModule.addObserver(smallForecastFragment);
        return smallForecastFragment;
    }

    private Fragment createBigForecastFragment() {
        BigForecastFragment bigForecastFragment = new BigForecastFragment();
        forecastModule.addObserver(bigForecastFragment);
        return bigForecastFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.forecast_module_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        forecastModule.getHourlyForecast(getResources());
    }
}
