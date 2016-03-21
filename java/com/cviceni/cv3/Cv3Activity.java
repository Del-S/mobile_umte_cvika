package com.cviceni.cv3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cviceni.R;

public class Cv3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv3);

        Data.LoadData();

        BanAdapter banAdapter = new BanAdapter(this, R.layout.item_ban, Data.getBans());

        ListView listView = (ListView) findViewById(R.id.banView);
        listView.setAdapter(banAdapter);
        listView.setOnItemClickListener(this);

        banAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Ban ban = (Ban) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("id_ban", ban.getId());
        startActivity(intent);

        Toast.makeText(Cv3Activity.this, "Clicked on detail " + position, Toast.LENGTH_SHORT);
    }
}
