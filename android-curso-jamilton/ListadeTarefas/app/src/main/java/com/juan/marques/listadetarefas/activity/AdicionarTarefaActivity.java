package com.juan.marques.listadetarefas.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.juan.marques.listadetarefas.R;
import com.juan.marques.listadetarefas.helper.TarefaDAO;
import com.juan.marques.listadetarefas.model.Tarefa;


public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText text_tarefa;
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        text_tarefa = findViewById(R.id.text_tarefa);

        // recuperar tarefa, caso seja edição
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        // configurar tarefa na caixa de texto
        if (tarefaAtual != null) {
            text_tarefa.setText(tarefaAtual.getNomeTarefa());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_salvar:
                // Executa ação para o item salvar

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if (tarefaAtual != null) { // edição

                    String nomeTarefa = text_tarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        // atualizar banco de dados
                        if (tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao editar", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Erro ao editar", Toast.LENGTH_SHORT).show();
                        }
                    }


                }else { // salvar

                    String nomeTarefa = text_tarefa.getText().toString();

                    if (!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if (tarefaDAO.salvar(tarefa)){
                            finish();
                            Toast.makeText(this, "Sucesso ao salvar", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Erro ao salvar", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }
}