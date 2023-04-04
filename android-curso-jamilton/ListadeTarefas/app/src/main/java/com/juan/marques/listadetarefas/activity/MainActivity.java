package com.juan.marques.listadetarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.lights.LightState;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.marques.listadetarefas.R;
import com.juan.marques.listadetarefas.adapter.TarefaAdapter;
import com.juan.marques.listadetarefas.databinding.ActivityMainBinding;
import com.juan.marques.listadetarefas.helper.DbHelper;
import com.juan.marques.listadetarefas.helper.RecyclerItemClickListener;
import com.juan.marques.listadetarefas.helper.TarefaDAO;
import com.juan.marques.listadetarefas.model.Tarefa;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private RecyclerView recycler_view;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // configurar recycler
        recycler_view = findViewById(R.id.recycler_view);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefaActivity.class);
                startActivity(intent);
            }
        });
    }

    private void carregarListaTarefa(){

        // Listar tarefas estáticas
//        Tarefa tarefa1 = new Tarefa();
//        tarefa1.setNomeTarefa("Ir ao mercado");
//        listaTarefas.add(tarefa1);
//
//        Tarefa tarefa2 = new Tarefa();
//        tarefa2.setNomeTarefa("Ir à feira");
//        listaTarefas.add(tarefa2);


        // Listar tarefas
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();


        // Exibir lista tarefas

        // Configurar adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

        // Adicionar evento de clique
        recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recycler_view,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        // Recuperar tarefa para edição
                        Tarefa tarefaSelecionada = listaTarefas.get(position);
                        //Enviar tarefa para tela adicionar tarefa
                        Intent intent = new Intent(MainActivity.this, AdicionarTarefaActivity.class);
                        intent.putExtra("tarefaSelecionada", tarefaSelecionada);
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                        // Recupera tarefa para deletar
                        tarefaSelecionada = listaTarefas.get(position);

                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                        // Configura título e mensagem
                        dialog.setTitle("Confirmar exclusão");
                        dialog.setMessage("Deseja excluir a tarefa " + tarefaSelecionada.getNomeTarefa() + "?");

                        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                                if (tarefaDAO.deletar(tarefaSelecionada)){
                                    carregarListaTarefa();
                                    Toast.makeText(getApplicationContext(), "Sucesso ao excluir tarefa", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(getApplicationContext(), "Erro ao excluir tarefa", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        dialog.setNegativeButton("Não", null);

                        // Exibir dialog
                        dialog.create();
                        dialog.show();

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

        // Configurar recycler
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);
        recycler_view.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recycler_view.setAdapter(tarefaAdapter);
    }

    @Override
    protected void onStart() {
        carregarListaTarefa();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return true;
    }

}