package com.example.win;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.win.audio.BirdSoundDetectorActivity;
import com.example.win.helpers.ImageHelperActivity;
import com.example.win.image.BirdIdentificationActivity;
import com.example.win.image.InsectsIdentificationActivity;
import com.example.win.image.MushroomIdentificationActivity;
import com.example.win.image.PlantIdentificationActivity;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnMushroom,btnBird,btnInsect,btnPlant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMushroom = findViewById(R.id.imgBtnMushroom);
        btnBird = findViewById(R.id.imgBtnBird);
        btnInsect = findViewById(R.id.imgBtnInsect);
        btnPlant = findViewById(R.id.imgBtnPlant);

        btnMushroom.setBackgroundColor(Color.TRANSPARENT);
        btnBird.setBackgroundColor(Color.TRANSPARENT);
        btnInsect.setBackgroundColor(Color.TRANSPARENT);
        btnPlant.setBackgroundColor(Color.TRANSPARENT);

        Intent intentMushroom = new Intent(this, MushroomIdentificationActivity.class);
        Intent intentBird = new Intent(this, BirdIdentificationActivity.class);
        Intent intentInsect = new Intent(this, InsectsIdentificationActivity.class);
        Intent intentPlant = new Intent(this, PlantIdentificationActivity.class);

        btnMushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentMushroom);
            }
        });

        btnBird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(intentBird); }
        });

        btnInsect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(intentInsect); }

        });
        btnPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(intentPlant); }
        });
    }
}
