package com.cviceni.cv5;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cviceni.R;
import com.cviceni.cv4.Cv4Activity;

import org.json.JSONException;

import java.io.IOException;

public class Cv5Activity extends AppCompatActivity {

    private EditText inputLocation;
    private Button buttonFindWeather;
    private TextView textName,
            textDescription,
            textTemperature,
            textWind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv5);

        inputLocation = (EditText) findViewById(R.id.cv5input);
        buttonFindWeather = (Button) findViewById(R.id.cv5button);
        textName = (TextView) findViewById(R.id.cv5TextName);
        textDescription = (TextView) findViewById(R.id.cv5TextDescription);
        textTemperature = (TextView) findViewById(R.id.cv5TextTemperature);
        textWind = (TextView) findViewById(R.id.cv5TextWind);

        buttonFindWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = inputLocation.getText().toString();

                // New Thread should be via service (but no time)
                new AsyncTask<String, Void, Weather>() {
                    @Override
                    protected Weather doInBackground(String... params) {
                        try {
                            return WeatherApi.getForcast(params[0]);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Weather weather) {
                        //super.onPostExecute(weather);
                        textName.setText(weather.getName());
                        textDescription.setText(weather.getDescription());
                        textTemperature.setText("Tempreature: " + weather.getTemperature());
                        textWind.setText("Wind: " + weather.getWind());
                    }
                }.execute(city);

            }
        });
    }
}
