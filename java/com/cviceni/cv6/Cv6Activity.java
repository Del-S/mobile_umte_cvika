package com.cviceni.cv6;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cviceni.R;

public class Cv6Activity extends AppCompatActivity {

    /* 
     Google search - google material icon (useful icons and how to download them)
     ico - download - extract (directory images) to project/resources (src/main/res) - should be added to drawable 
    */

    private ListView cv6Friends;
    private ArrayAdapter<String> friendsAdapter;
    private Database dbFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv6);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbFriends = new Database(this);
        cv6Friends = (ListView) findViewById(R.id.cv6_friends);
        friendsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                dbFriends.getAllFriends());
        cv6Friends.setAdapter(friendsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbFriends.saveFriend("David", "super@email.cz");
                dbFriends.saveFriend("Test", "td@t.cz");

                friendsAdapter.clear();
                friendsAdapter.addAll(dbFriends.getAllFriends());

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            Intent intent =  new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
