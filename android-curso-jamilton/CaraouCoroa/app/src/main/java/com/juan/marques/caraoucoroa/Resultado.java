package com.juan.marques.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Resultado extends AppCompatActivity {

    private ImageView img_moeda;
    private Button btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        iniciarComponentes();

        // Recuperar dados
        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if (numero == 0){
            img_moeda.setImageResource(R.drawable.moeda_cara);
        } else {
            img_moeda.setImageResource(R.drawable.moeda_coroa);
        }

        btn_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void iniciarComponentes(){
        img_moeda = findViewById(R.id.img_moeda);
        btn_voltar = findViewById(R.id.btn_voltar);
    }
}