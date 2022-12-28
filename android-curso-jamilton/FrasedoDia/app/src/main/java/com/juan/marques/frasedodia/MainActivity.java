package com.juan.marques.frasedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btn_novafrase;
    TextView txt_gerafrase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btn_novafrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gerarFrase();
            }
        });
    }

    private void iniciarComponentes(){
        btn_novafrase = findViewById(R.id.btn_novafrase);
        txt_gerafrase = findViewById(R.id.txt_gerafrase);
    }

    private void gerarFrase(){

        int numero = new Random().nextInt(4);

        String frases[] = {
                "Frase 1" +
                "Frase 2" +
                "Frase 3" +
                "Frase 4"};

        txt_gerafrase.setText(frases[numero]);
    }
}