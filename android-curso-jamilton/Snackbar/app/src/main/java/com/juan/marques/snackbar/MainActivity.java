package com.juan.marques.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button btn_snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        btn_snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Botão pressionado",
                        Snackbar.LENGTH_LONG).setAction("Confirmar", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                btn_snackbar.setText("Botão snackbar presionado");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.white))
                        .show();
            }
        });

    }

    private void abrirSnackbar(View view){

    }

    private void iniciarComponentes(){
        btn_snackbar = findViewById(R.id.btn_snackbar);
    }



}