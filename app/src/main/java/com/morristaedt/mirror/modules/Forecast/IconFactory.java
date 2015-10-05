package com.morristaedt.mirror.modules.Forecast;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import com.thbs.skycons.library.CloudFogView;
import com.thbs.skycons.library.CloudHvRainView;
import com.thbs.skycons.library.CloudMoonView;
import com.thbs.skycons.library.CloudRainView;
import com.thbs.skycons.library.CloudSnowView;
import com.thbs.skycons.library.CloudSunView;
import com.thbs.skycons.library.CloudThunderView;
import com.thbs.skycons.library.CloudView;
import com.thbs.skycons.library.MoonView;
import com.thbs.skycons.library.SkyconView;
import com.thbs.skycons.library.SunView;
import com.thbs.skycons.library.WindView;


public class IconFactory {
    public enum IconSize {
        BIG(150),
        SMALL(100);
        private int value;

        private IconSize(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Context context;
    private IconSize size;

    public IconFactory(Context context, IconSize iconSize) {
        this.context = context;
        size = iconSize;
    }

    public IconFactory(Context context) {
        this(context, IconSize.BIG);
    }

    public void setSize(IconSize size) {
        this.size = size;
    }

    public View getIcon(String icon) {
        SkyconView iconView = null;
        switch (icon) {
            case "clear-night":
                iconView = new MoonView(context);
                break;
            case "clear-day":
                iconView = new SunView(context);
                break;
            case "snow":
                iconView = new CloudSnowView(context);
                break;
            case "sleet":
                iconView = new CloudHvRainView(context);
                break;
            case "wind":
                iconView = new WindView(context);
                break;
            case "fog":
                iconView = new CloudFogView(context);
                break;
            case "cloudy":
                iconView = new CloudView(context);
                break;
            case "partly-cloudy-day":
                iconView = new CloudSunView(context);
                break;
            case "partly-cloudy-night":
                iconView = new CloudMoonView(context);
                break;
            case "thunder":
                iconView = new CloudThunderView(context);
                break;
            default:
                //Default to rain - plan for the worst
                iconView = new CloudRainView(context);
                break;
        }
        iconView.setLayoutParams(getParams());
        iconView.setBgColor(Color.BLACK);
        iconView.setStrokeColor(Color.WHITE);
        return iconView;
    }

    private LinearLayout.LayoutParams getParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.width = size.getValue();
        params.height = size.getValue();
        return params;
    }
}
