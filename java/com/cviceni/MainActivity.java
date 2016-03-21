package com.cviceni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cviceni.cv3.Cv3Activity;
import com.cviceni.cv4.Cv4Activity;
import com.cviceni.cv5.Cv5Activity;
import com.cviceni.cv6.Cv6Activity;
import com.cviceni.cv7.Cv7Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cv3_button = (Button) findViewById(R.id.main_cv3);
        cv3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cv3Activity.class);
                startActivity(intent);
            }
        });

        Button cv4_button = (Button) findViewById(R.id.main_cv4);
        cv4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cv4Activity.class);
                startActivity(intent);
            }
        });

        Button cv5_button = (Button) findViewById(R.id.main_cv5);
        cv5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cv5Activity.class);
                startActivity(intent);
            }
        });

        Button cv6_button = (Button) findViewById(R.id.main_cv6);
        cv6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cv6Activity.class);
                startActivity(intent);
            }
        });

        Button cv7_button = (Button) findViewById(R.id.main_cv7);
        cv7_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cv7Activity.class);
                startActivity(intent);
            }
        });
    }
}
