package com.juan.marques.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt_digite;
    private TextView txt_percentual;
    private SeekBar seek_bar_percentual;
    private TextView txt_gorjeta;
    private TextView txt_preco;
    private TextView txt_total;
    private TextView txt_preco_total;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        seek_bar_percentual.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagem = progress;
                txt_percentual.setText(Math.round(porcentagem) +  "%");
                calcular();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcular(){

        String valorRecuperado = edt_digite.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_LONG).show();
        }else {

            // Converter String para Double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            // Calcular gorjeta
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            // Exibe gorjeta
            // txt_preco.setText("R$ " + Math.round(gorjeta));
            txt_preco.setText("R$ " + gorjeta);
            txt_preco_total.setText("R$ " + total);
        }
    }


    private void iniciarComponentes(){
        edt_digite = findViewById(R.id.edt_digite);
        txt_percentual = findViewById(R.id.txt_percentual);
        seek_bar_percentual = findViewById(R.id.seek_bar_percentual);
        txt_gorjeta = findViewById(R.id.txt_gorjeta);
        txt_preco = findViewById(R.id.txt_preco);
        txt_total = findViewById(R.id.txt_total);
        txt_preco_total = findViewById(R.id.txt_preco_total);
    }
}