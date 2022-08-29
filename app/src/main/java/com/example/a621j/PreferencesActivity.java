package com.example.a621j;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        initViews();
    }

    void initViews() {
        EditText et_email = findViewById(R.id.et_email);
        Button b_save = findViewById(R.id.b_save);
        Button b_save1 = findViewById(R.id.b_save1);
        Button b_save2 = findViewById(R.id.b_save2);
        Button b_save3 = findViewById(R.id.b_save3);

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int email = Integer.parseInt(et_email.getText().toString());
                PrefsManager.getInstance(PreferencesActivity.this).saveData("key", email);
                int data = PrefsManager.getInstance(PreferencesActivity.this).getData("key");
                saveEmail(data);
            }
        });

        b_save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long email = Long.parseLong(et_email.getText().toString());
                PrefsManager.getInstance(PreferencesActivity.this).saveDataLong("key", email);
                long data = PrefsManager.getInstance(PreferencesActivity.this).getDataLong("key");
                saveEmail1(data);
            }
        });

        b_save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean email = Boolean.parseBoolean(et_email.getText().toString());
                PrefsManager.getInstance(PreferencesActivity.this).saveDataBoolean("key", email);
                Boolean data = PrefsManager.getInstance(PreferencesActivity.this).getDataBoolean("key");
                saveEmail2(data);
            }
        });
    }

    void saveEmail(int email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("email", email);
        editor.apply();
    }

    void saveEmail1(Long email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("email", email);
        editor.apply();
    }

    void saveEmail2(Boolean email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("email", email);
        editor.apply();
    }

    void saveEmail3(Double email) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("email", Double.doubleToRawLongBits(email));
        editor.apply();
    }
}
