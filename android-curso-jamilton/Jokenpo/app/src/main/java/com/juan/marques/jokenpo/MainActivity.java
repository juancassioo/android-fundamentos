package com.juan.marques.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView img_padrao;
    ImageView img_pedra;
    ImageView img_papel;
    ImageView img_tesoura;

    TextView txt_escolha_abaixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        img_pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadaPedra();
            }
        });

        img_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadaPapel();
            }
        });

        img_tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selecionadaTesoura();
            }
        });
    }

    public void selecionadaPedra(){
        this.opcaoSelecionada("pedra");
    }
    public void selecionadaPapel(){
        this.opcaoSelecionada("papel");
    }

    public void selecionadaTesoura(){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada){

        int numero = new Random().nextInt(3);
        String opcoes[] = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){

            case "pedra":
                img_padrao.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                img_padrao.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                img_padrao.setImageResource(R.drawable.tesoura);
                break;
        }

        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")) {
            // App ganhador

            txt_escolha_abaixo.setText("Você perdeu.");

        }else if((opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")) {
            // Usuário ganhador

            txt_escolha_abaixo.setText("Você ganhou.");

        }else{ // Empate
            txt_escolha_abaixo.setText("Empate");
        }

        System.out.println("item clicado " + opcaoApp);

    }

    public void iniciarComponentes(){

        img_padrao = findViewById(R.id.img_padrao);
        img_pedra = findViewById(R.id.img_pedra);
        img_papel = findViewById(R.id.img_papel);
        img_tesoura = findViewById(R.id.img_tesoura);

        txt_escolha_abaixo = findViewById(R.id.txt_escolha_abaixo);

    }



}