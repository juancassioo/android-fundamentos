package com.juan.marques.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edt_nome;
    private EditText edt_email;

    private TextView txt_resultado;

    private Button btn_cadastrar;

    private CheckBox chk_verde;
    private CheckBox chk_branco;
    private CheckBox chk_vermelho;

    private RadioGroup rdo_group_sexo;

    private RadioButton rdo_masculino;
    private RadioButton rdo_feminino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        verificaRadioGroup();

    }

    private void iniciarComponentes(){

        edt_nome = findViewById(R.id.edt_nome);
        edt_email = findViewById(R.id.edt_email);

        chk_verde = findViewById(R.id.chk_verde);
        chk_branco = findViewById(R.id.chk_branco);
        chk_vermelho = findViewById(R.id.chk_vermelho);

        btn_cadastrar = findViewById(R.id.btn_cadastrar);

        txt_resultado = findViewById(R.id.txt_resultado);

        rdo_group_sexo = findViewById(R.id.rdo_group_sexo);

        rdo_masculino = findViewById(R.id.rdo_masculino);
        rdo_feminino = findViewById(R.id.rdo_feminino);
    }

    private void verificaCheck(){

        String texto = "";
        if (chk_verde.isChecked()){
            texto = "Verde selecionado, ";
        }if (chk_vermelho.isChecked()){
            texto = texto + "Vermelho selecionado, ";
        } if (chk_branco.isChecked()){
            texto = texto + "Branco selecionado, ";
        }
        txt_resultado.setText(texto);
    }

    private void verificaRadio(){

        // Utilizando os RadioButton de forma individual
        if (rdo_masculino.isChecked()){
            txt_resultado.setText("Sexo: masculino");
        }else{
            txt_resultado.setText("Sexo: feminino");
        }

    }

    private void verificaRadioGroup(){

        // Utilizando o RadioGroup
        rdo_group_sexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rdo_masculino){
                    txt_resultado.setText("Masculino");
                }else{
                    txt_resultado.setText("Feminino");
                }
            }
        });

    }
}