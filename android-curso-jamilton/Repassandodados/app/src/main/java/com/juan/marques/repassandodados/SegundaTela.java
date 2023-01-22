package com.juan.marques.repassandodados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaTela extends AppCompatActivity {

    private TextView txt_nome;
    private TextView txt_idade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);

        iniciarComponentes();

        // Recuperar dados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");
        Usuario usuario = (Usuario) dados.getSerializable("objeto");

        // Configurar valores recuperados
        // txt_nome.setText(nome); -> recupera por uma String
        txt_nome.setText(usuario.getNome()); // -> recupera por um objeto
        txt_idade.setText(String.valueOf(idade));

    }

    private void iniciarComponentes(){
        txt_nome = findViewById(R.id.txt_nome);
        txt_idade = findViewById(R.id.txt_idade);
    }


}