package com.cviceni.cv6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import com.cviceni.R;

public class SettingsActivity extends AppCompatActivity {

    private EditText fullname;
    private CheckBox isMale;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fullname = (EditText) findViewById(R.id.cv6_name);
        isMale = (CheckBox) findViewById(R.id.cv6_is_male);

        preferences = getSharedPreferences("UHK",0); // private is 0 - 1 is not mostly used at this time

        String name = preferences.getString("cv6_name", "");
        boolean male = preferences.getBoolean("cv6_male", false);

        fullname.setText(name);
        isMale.setChecked(male);
    }

    @Override
    protected void onStop() {
        super.onStop();

        String name = fullname.getText().toString();
        boolean male = isMale.isChecked();

        preferences = getSharedPreferences("UHK", 0);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("cv6_name", name);
        editor.putBoolean("cv6_male", male);
        editor.commit();
    }
}
