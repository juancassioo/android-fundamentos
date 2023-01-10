package com.juan.marques.cardview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.juan.marques.cardview.R;
import com.juan.marques.cardview.adapter.PostagemAdapter;
import com.juan.marques.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_postagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        // Definir layout padrão (vertical)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_postagem.setLayoutManager(layoutManager);

        // define horizontal
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // layoutManager.setOrientation(RecyclerView.HORIZONTAL);

        // define grid
        // RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);


        // Definir adapter
        prepararPostagens();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recycler_postagem.setAdapter(adapter);

    }

    public void prepararPostagens(){

        Postagem postagem;

        postagem = new Postagem("Jamilton Damasceno", "#tbt viagem legal!", R.drawable.imagem1);
        postagens.add(postagem);

        postagem = new Postagem("Leonardo Leitão", "gostei demais daqui", R.drawable.imagem2);
        postagens.add(postagem);

        postagem = new Postagem("Gustavo Guanabara", "de volta a minha terra", R.drawable.imagem3);
        postagens.add(postagem);

        postagem = new Postagem("Nina Talks", "como foi bom visitar a Apple", R.drawable.imagem4);
        postagens.add(postagem);

    }

    private void iniciarComponentes(){
        recycler_postagem = findViewById(R.id.recycler_postagem);
    }
}