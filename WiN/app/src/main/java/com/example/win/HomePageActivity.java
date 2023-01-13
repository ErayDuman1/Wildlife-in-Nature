package com.example.win;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.win.audio.BirdSoundDetectorActivity;
import com.example.win.image.MushroomIdentificationActivity;

public class HomePageActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button btnImage,btnAudio,btnAbout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        btnImage = findViewById(R.id.btnImageModel);
        btnAudio = findViewById(R.id.btnAudioModel);
        btnAbout = findViewById(R.id.btnAbout);

        btnImage.setBackgroundColor(Color.TRANSPARENT);
        btnAudio.setBackgroundColor(Color.TRANSPARENT);
        btnAbout.setBackgroundColor(Color.TRANSPARENT);
        mediaPlayer = MediaPlayer.create(HomePageActivity.this,R.raw.homepage_sound);
        mediaPlayer.start();

        Intent intentImage = new Intent(this, MainActivity.class);
        Intent intentAbout = new Intent(this, AboutPageActivity.class);
        Intent intentAudio = new Intent(this, BirdSoundDetectorActivity.class);

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentImage);
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { startActivity(intentAudio); }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentAbout);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}