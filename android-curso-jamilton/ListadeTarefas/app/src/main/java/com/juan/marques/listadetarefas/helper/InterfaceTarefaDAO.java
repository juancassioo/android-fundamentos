package com.juan.marques.listadetarefas.helper;

import com.juan.marques.listadetarefas.model.Tarefa;

import java.util.List;

public interface InterfaceTarefaDAO {

    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
