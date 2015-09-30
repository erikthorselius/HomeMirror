package com.morristaedt.mirror.modules.Forecast;

import android.app.Fragment;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.morristaedt.mirror.R;
import com.thbs.skycons.library.CloudFogView;
import com.thbs.skycons.library.CloudHvRainView;
import com.thbs.skycons.library.CloudRainView;
import com.thbs.skycons.library.CloudSunView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.Map;

public class ForecastListener {

    private final TextView mWeatherText;
    private Map<String, View> icons;
    private TextView mBikeTodayText;
    private ViewGroup mWeatherLayout;
    private Fragment forecastFragment;
    private View activeIcon;

    public ForecastListener(TextView mWeatherText, Map<String, View> icons) {
        this.mWeatherText = mWeatherText;
        this.icons = icons;
    }

    public void onWeatherToday(String weatherToday) {
        if (!TextUtils.isEmpty(weatherToday)) {
            mWeatherText.setVisibility(View.VISIBLE);
            mWeatherText.setText(weatherToday);
        }
    }

    public void onShouldBike(boolean showToday, boolean shouldBike) {
        //mBikeTodayText.setVisibility(showToday ? View.VISIBLE : View.GONE);
        //mBikeTodayText.setText(shouldBike ? R.string.bike_today : R.string.no_bike_today);
    }

    public void setIcon(String iconToDisplay) {
        for( View icon : icons.values()) {
            icon.setVisibility(View.GONE);
        }
        icons.get(iconToDisplay).setVisibility(View.VISIBLE);
    }
}

