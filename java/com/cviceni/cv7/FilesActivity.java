package com.cviceni.cv7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cviceni.R;

import java.io.File;

public class FilesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);

        // Display buttons with file names (onclick display absPath to file)
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cv7_activity_files);

        File dir = getFilesDir();
        for (File file : dir.listFiles()) {
            Button button = new Button(this);
            button.setText(file.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    final String absPath = getFilesDir() + "/" + b.getText();

                    Toast.makeText(FilesActivity.this, "Image path - " + absPath, Toast.LENGTH_SHORT).show();
                }
            });

            linearLayout.addView(button);
        }
    }
}
