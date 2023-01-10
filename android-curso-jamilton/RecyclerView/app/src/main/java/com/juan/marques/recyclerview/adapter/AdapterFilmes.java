package com.juan.marques.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.marques.recyclerview.R;
import com.juan.marques.recyclerview.model.Filme;

import java.util.List;

public class AdapterFilmes extends RecyclerView.Adapter<AdapterFilmes.ViewHolderFilmes> {


    private List<Filme> listaFilmes;
    public AdapterFilmes(List<Filme> lista){

        this.listaFilmes = lista;


    }

    @NonNull
    @Override
    public ViewHolderFilmes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View recycler_filmes = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_lista, parent, false);

        return new ViewHolderFilmes(recycler_filmes);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFilmes holder, int position) {

        Filme filme = listaFilmes.get(position);

        holder.titulo.setText(filme.getTitulo());
        holder.ano.setText(filme.getAno());
        holder.genero.setText(filme.getGenero());

    }

    @Override
    public int getItemCount() {
        return listaFilmes.size();
    }

    public class ViewHolderFilmes extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView ano;
        TextView genero;

        public ViewHolderFilmes(View itemView){
            super(itemView);


            titulo = itemView.findViewById(R.id.txt_titulo);
            ano = itemView.findViewById(R.id.txt_ano);
            genero = itemView.findViewById(R.id.txt_genero);

        }
    }


}
