package com.example.minhasanotacoes;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.minhasanotacoes.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private AnotacaoPreferencias preferencias;
    private EditText edt_mult_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        iniciarComponentes();

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Validar se foi digitado algo
                String textoRecuperado = edt_mult_txt.getText().toString();
                if (textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação.", Snackbar.LENGTH_LONG).show();
                } else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, "Anotação salva com sucesso.", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        // Recuperar anotação
        String anotacao = preferencias.recuperarAnotacao();
        if (!anotacao.equals("")){
            edt_mult_txt.setText(anotacao);
        }
    }


    private void iniciarComponentes(){
        edt_mult_txt = findViewById(R.id.edt_mult_txt);
    }

}