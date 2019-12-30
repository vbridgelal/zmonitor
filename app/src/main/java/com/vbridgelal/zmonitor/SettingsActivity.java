package com.vbridgelal.zmonitor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        final SharedPreferences.Editor editor = pref.edit();
        final TextInputEditText cam1 = findViewById(R.id.cam1_url);
        final TextInputEditText cam2 = findViewById(R.id.cam2_url);
        final TextInputEditText cam3 = findViewById(R.id.cam3_url);
        final TextInputEditText cam4 = findViewById(R.id.cam4_url);

        Button btnSave = findViewById(R.id.save_button);

        cam1.setText(pref.getString("cam1", ""));
        cam2.setText(pref.getString("cam2", ""));
        cam3.setText(pref.getString("cam3", ""));
        cam4.setText(pref.getString("cam4", ""));


        final Context ctx = this;

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("cam1", cam1.getText().toString()); // Storing string
                editor.putString("cam2", cam2.getText().toString()); // Storing string
                editor.putString("cam3", cam3.getText().toString()); // Storing string
                editor.putString("cam4", cam4.getText().toString()); // Storing string

                editor.commit(); // commit changes
                Toast.makeText(ctx, "Saved", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.view_licence:
                Intent i = new Intent();
                i.setClass(getApplicationContext(), Licences.class);
                startActivity(i);
                return (true);
        }
        return (super.onOptionsItemSelected(item));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}