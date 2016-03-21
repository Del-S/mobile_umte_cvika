package com.cviceni.cv3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cviceni.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int idBan = getIntent().getIntExtra("id_ban", 0);

        Ban ban = Data.getBanById(idBan);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        TextView txtDescription = (TextView) findViewById(R.id.txtDescription);

        txtTitle.setText(ban.getTitle());
        txtDescription.setText(ban.getDescription());
    }
}
