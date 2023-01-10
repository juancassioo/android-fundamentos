package com.juan.marques.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list_locais;
    private String itens[] = {"Alagoa Grande", "Alagoinha", "Bayeux", "Santa Rita",
            "Sertãozinho", "Pirpirituba", "Pirpiri", "Pilões",
            "Pilõezinhos", "Cruz do Espírito Santo", "Sapé", "Mari",
            "Guarabira", "João Pessoa", "Cajazeiras", "Patos", "Araruna",
            "Campina Grande", "Boqueirão", "Souza", "Ingá"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        // Criar adaptador para a lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,itens);

        // Adicionar adpatador para a lista
        list_locais.setAdapter(adapter);

        // Adicionar eventos de clique
        list_locais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String valorSelecionado = list_locais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void iniciarComponentes(){
        list_locais = findViewById(R.id.list_locais);
    }
}