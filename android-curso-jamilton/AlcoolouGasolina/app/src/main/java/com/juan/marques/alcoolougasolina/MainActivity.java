package com.juan.marques.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt_preco_alcool;
    private EditText edt_preco_gasolina;
    private Button btn_calcular;
    private TextView txt_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponentes();

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void iniciarComponentes(){
        edt_preco_alcool = findViewById(R.id.edt_preco_alcool);
        edt_preco_gasolina = findViewById(R.id.edt_preco_gasolina);
        btn_calcular = findViewById(R.id.btn_calcular);
        txt_resultado = findViewById(R.id.txt_resultado);
    }

    private void calcular(){
        String precoAlcool = edt_preco_alcool.getText().toString();
        String precoGasolina = edt_preco_gasolina.getText().toString();

        Boolean camposVerificados = verificaCampos(precoAlcool, precoGasolina);

        if (camposVerificados) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7){
                txt_resultado.setText("Melhor utilizar gasolina");
            } else {
                txt_resultado.setText("Melhor utilizar álcool");
            }
        } else {
            txt_resultado.setText("Preencha os preços primeiro");
        }
    }

    private Boolean verificaCampos(String pAlcool, String pGasolina){

        Boolean camposVerificados = true;

        if (pAlcool == null || pAlcool.equals("")
                || pGasolina == null || pGasolina.equals("")) {
            camposVerificados = false;
        }

        return camposVerificados;

    }
}