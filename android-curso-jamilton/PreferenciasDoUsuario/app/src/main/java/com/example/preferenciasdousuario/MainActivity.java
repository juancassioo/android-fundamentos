package com.example.preferenciasdousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt_nome;
    private Button btn_salvar;
    private TextView txt_saida;

    private static final String ARQUIVO_PEFERENCIA = "ArquivoPreferencia";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PEFERENCIA, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Validar o nome
                if (edt_nome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Preencha o campo", Toast.LENGTH_SHORT).show();
                } else {
                    String nome = edt_nome.getText().toString();
                    editor.putString("nome", nome);
                    editor.commit();
                    txt_saida.setText("Olá, " + nome);
                }

            }
        });

        // Recuperar os dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PEFERENCIA, 0);

        // Valida se temos o nome em preferências
        if (sharedPreferences.contains("nome")){
            String nome = sharedPreferences.getString("nome", "Olá, usuário não definido");
            txt_saida.setText("Olá " + nome);
        }else {
            txt_saida.setText("Olá, usuário não definido");
        }



    }

    private void iniciarComponentes(){
        edt_nome = findViewById(R.id.edt_nome);
        btn_salvar = findViewById(R.id.btn_salvar);
        txt_saida = findViewById(R.id.txt_saida);
    }
}