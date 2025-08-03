package com.ritesh.themeswitcher;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Switch themeSwitch;
    private static final String PREFS = "theme_prefs";

    private static final String DARK_MODE = "dark_mode";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        SharedPreferences prefs = getSharedPreferences(PREFS, MODE_PRIVATE);


        boolean dark = prefs.getBoolean(DARK_MODE, false);
       setTheme(dark?R.style.Apptheme_Dark: R.style.Apptheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        themeSwitch = findViewById(R.id.theme);
        themeSwitch.setChecked(dark);

        themeSwitch.setOnCheckedChangeListener((v, isChecked)-> {
            prefs.edit().putBoolean(DARK_MODE,isChecked ).apply();
            recreate();

        });
    }
}
