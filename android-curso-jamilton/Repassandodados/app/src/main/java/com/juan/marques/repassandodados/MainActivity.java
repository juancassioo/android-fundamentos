package com.juan.marques.repassandodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_passando_dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        btn_passando_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SegundaTela.class);

                // Instanciar objeto
                Usuario usuario = new Usuario("Jamilton", "jamilton@gmail.com");

                // Passando dados entre activity
                intent.putExtra("nome","Jamilton");
                intent.putExtra("idade",30);
                intent.putExtra("objeto", usuario);

                startActivity(intent);
            }
        });

    }

    private void iniciarComponentes(){
        btn_passando_dados = findViewById(R.id.btn_passando_dados);
    }
}