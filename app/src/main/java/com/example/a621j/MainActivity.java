package com.example.a621j;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        context = this;
        Button b_home = findViewById(R.id.b_home);
        b_home.setText(getString(R.string.app_name));

        b_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPreferenceActivity();
            }
        });
    }

    void callPreferenceActivity() {
        Intent intent = new Intent(this, PreferenceActivity.class);
        startActivity(intent);
    }

}