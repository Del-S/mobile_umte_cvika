package com.cviceni.cv5;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApi {

    public static JSONObject getJsonObject(String urlString) throws IOException, JSONException {
        int test = 0;
        URL url = new URL(urlString);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStreamReader in = new InputStreamReader(connection.getInputStream());

        StringBuilder jsonResult = new StringBuilder();

        int read;
        char[] buff = new char[1024];

        while((read = in.read(buff)) != -1) {
            jsonResult.append(buff, 0, read);
        }

        return new JSONObject(jsonResult.toString());
    }

    public static Weather getForcast(String city) throws IOException, JSONException {
        String url = "api.openweather.org/data/2.5/weather?q=" + city + ",cz&appid=44db6a862fba0b067b1930da0d769e98";
        // Test url (broken internet :D)
        //String test_url = "http://10.0.2.2/weather/";  // 10.0.2.2 is link to localhost
        //url = test_url;

        Weather weather = null;

        // Whole json
        JSONObject jsonObject = getJsonObject(url);

        // Sub main json object
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        JSONObject jsonObjectWeather = jsonArrayWeather.optJSONObject(0);
        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");

        String name = jsonObjectWeather.getString("main");
        String description = jsonObjectWeather.getString("description");
        double temperature = jsonObjectMain.getDouble("temp");
        double wind = jsonObjectWind.getDouble("speed");

        weather = new Weather(name, description, temperature, wind);

        return weather;
    }
}
