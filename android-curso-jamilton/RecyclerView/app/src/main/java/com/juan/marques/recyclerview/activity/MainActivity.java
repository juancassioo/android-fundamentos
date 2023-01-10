package com.juan.marques.recyclerview.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.juan.marques.recyclerview.R;
import com.juan.marques.recyclerview.RecyclerItemClickListener;
import com.juan.marques.recyclerview.adapter.AdapterFilmes;
import com.juan.marques.recyclerview.model.Filme;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_filmes;
    private List<Filme> listaFilmes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        // Listagem de Filmes
        criarFilmes();


        // Configurar adapter
        AdapterFilmes adapterFilmes = new AdapterFilmes(listaFilmes);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_filmes.setLayoutManager(layoutManager);
        recycler_filmes.setHasFixedSize(true);
        recycler_filmes.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recycler_filmes.setAdapter(adapterFilmes);

        // Evento de Click
        recycler_filmes.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recycler_filmes,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click rápido em " + filme.getTitulo(),
                                Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        Filme filme = listaFilmes.get(position);
                        Toast.makeText(getApplicationContext(), "Click longo em " + filme.getTitulo(),
                                Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }));

    }

    public void criarFilmes(){
        Filme filme = new Filme("Liga da Justiça", "2017", "Comédia");
        this.listaFilmes.add(filme);

        filme = new Filme("Liga da Justiça de Snyder Cut", "2017", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filme("Vingadores: Ultimato", "2019", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filme("Mulher-Maravilha", "2017", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filme("Medo Profundo: O Segundo Ataque", "2019", "Suspense");
        this.listaFilmes.add(filme);

        filme = new Filme("It: a Coisa", "2017", "Terror");
        this.listaFilmes.add(filme);

        filme = new Filme("Homem-Aranha: Sem volta para casa", "2021", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filme("Batman vs Superman", "2016", "Ação");
        this.listaFilmes.add(filme);

        filme = new Filme("Sobrenatural", "2010", "Terror");
        this.listaFilmes.add(filme);

        filme = new Filme("Jogos Mortais", "2004", "Terror");
        this.listaFilmes.add(filme);
    }

    private void iniciarComponentes(){
        recycler_filmes = findViewById(R.id.recycler_filmes);
    }
}