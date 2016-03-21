package com.cviceni.cv4;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.cviceni.R;

public class Cv4Activity extends AppCompatActivity implements MainFragment.onSendEmailListener {

    DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv4);

        // Oncreate makes exception when you switch landscape to normal
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
    }

    @Override
    public void sendEmail(String email) {
        Toast.makeText(Cv4Activity.this, email, Toast.LENGTH_SHORT).show();

        if(detailFragment == null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
        } else {
            detailFragment.setEmail(email);
        }
    }
}
