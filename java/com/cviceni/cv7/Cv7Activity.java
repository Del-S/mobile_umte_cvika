package com.cviceni.cv7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.cviceni.R;

public class Cv7Activity extends AppCompatActivity {

    private EditText cv7_url;
    private Button cv7_button_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv7);

        cv7_url = (EditText) findViewById(R.id.cv7_file_url);
        cv7_button_download = (Button) findViewById(R.id.cv7_button_download);

        cv7_button_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = cv7_url.getText().toString();

                Intent intent = new Intent(Cv7Activity.this, DownloadFileService.class);
                intent.putExtra("download_url", url);

                startService(intent);
            }
        });
    }
}
