package com.morristaedt.mirror.modules.Forecast;

public enum ForecastView {
    ICON("ICON"),
    ICON_TEXT("ICON_TEXT"),
    TEMP_ICON_TEXT("TEMP_ICON_TEXT")
    ;
    private final String text;

    private ForecastView(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
