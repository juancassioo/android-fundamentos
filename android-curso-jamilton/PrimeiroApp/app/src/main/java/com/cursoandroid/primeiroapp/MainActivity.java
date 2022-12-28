package com.cursoandroid.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txt_resultado;
    private Button btn_jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();
        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_resultado.setText("O número selecionado foi: " + sortear());
            }
        });
    }

    public void iniciarComponentes(){
        txt_resultado = findViewById(R.id.txt_resultado);
        btn_jogar = findViewById(R.id.btn_jogar);
    }

    public int sortear(){
        int[] valores = {0,1,2,3,4,5,6,7,8,9,10};
        Random random = new Random();
        return random.nextInt(valores.length);
    }
}