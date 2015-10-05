package com.morristaedt.mirror.modules.Forecast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import org.joda.time.LocalDate;

import java.lang.reflect.Type;

public class GsonUnixTimestapConverter {
    public Gson createConverter() {
        // Creates the json object which will manage the information received
        GsonBuilder builder = new GsonBuilder();
        // Register an adapter to manage the date types as long values
        builder.registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new LocalDate(json.getAsJsonPrimitive().getAsLong() * 1000);
            }
        });

        Gson gson = builder.create();
        return gson;
    }
}
