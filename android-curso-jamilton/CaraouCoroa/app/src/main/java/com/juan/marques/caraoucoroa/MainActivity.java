package com.juan.marques.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Resultado.class);

                // Passar dados para próxima tela
                int random = new Random().nextInt(2);
                intent.putExtra("numero", random);

                startActivity(intent);
            }
        });

    }

    private void iniciarComponentes(){
        btn_jogar = findViewById(R.id.btn_jogar);
    }
}