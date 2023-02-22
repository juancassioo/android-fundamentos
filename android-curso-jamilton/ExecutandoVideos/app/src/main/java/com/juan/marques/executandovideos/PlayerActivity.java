package com.juan.marques.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    private VideoView video_rick_and_morty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        iniciarComponentes();

        View decorView = getWindow().getDecorView();
        int UIoptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(UIoptions);

        video_rick_and_morty.setMediaController(new MediaController(this));
        // video_rick_and_morty.setVideoURI(); <- link do vídeo online
        video_rick_and_morty.setVideoPath("android.resource://"
                + getPackageName() + "/" + R.raw.video);
        video_rick_and_morty.start();
    }

    private void iniciarComponentes(){
        video_rick_and_morty = findViewById(R.id.video_rick_and_morty);
    }
}