package com.juan.marques.executandovideos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img_executar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();



        img_executar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executarVideo();
            }
        });

    }

    private void iniciarComponentes(){
        img_executar = findViewById(R.id.img_executar);
    }

    private void executarVideo(){
        startActivity(new Intent(getApplicationContext(), PlayerActivity.class));
    }
}