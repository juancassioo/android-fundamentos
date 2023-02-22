package com.juan.marques.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar seek_bar;
    private ImageButton btn_pause;
    private ImageButton btn_play;
    private ImageButton btn_stop;

    private MediaPlayer mediaPlayer;
    private AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        configuraSeekBar();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bach);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarSom();
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausarSom();
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pararSom();
            }
        });

    }

    private void configuraSeekBar(){

        seek_bar = findViewById(R.id.seek_bar);

        // Configurar o áudio manager do aparelho
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Recuperar os valores de volume máximo e o volume atual
        int volumeMaximo = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int volumeAtual = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Configurar os valores máximos para o SeekBar
        seek_bar.setMax(volumeMaximo);
        seek_bar.setProgress(volumeAtual);

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void iniciarComponentes(){
        btn_pause = findViewById(R.id.btn_pause);
        btn_play = findViewById(R.id.btn_play);
        btn_stop = findViewById(R.id.btn_stop);
    }

    @Override
    protected void onStop() {
        super.onStop();
        pausarSom();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void executarSom(){
        if (mediaPlayer != null) mediaPlayer.start();
    }

    public void pausarSom(){
        if(mediaPlayer.isPlaying()) mediaPlayer.pause();
    }

    public void pararSom(){
        if(mediaPlayer.isPlaying()) mediaPlayer.stop();
    }

}

