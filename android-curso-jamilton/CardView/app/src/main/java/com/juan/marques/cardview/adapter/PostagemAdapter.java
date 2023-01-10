package com.juan.marques.cardview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juan.marques.cardview.R;
import com.juan.marques.cardview.model.Postagem;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> listaPostagens) {
        this.postagens = listaPostagens;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.postagem_layout, parent, false);

        return new MyViewHolder(itemLista);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagem postagem = postagens.get(position);

        holder.txt_usuario.setText(postagem.getNome());
        holder.txt_titulo_postagem.setText(postagem.getPostagem());
        holder.img_postagem.setImageResource(postagem.getImagem());

    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txt_usuario;
        private ImageView img_postagem;
        private TextView txt_titulo_postagem;


        public MyViewHolder(View itemView){
            super(itemView);
            txt_usuario = itemView.findViewById(R.id.txt_usuario);
            img_postagem = itemView.findViewById(R.id.img_postagem);
            txt_titulo_postagem = itemView.findViewById(R.id.txt_titulo_postagem);
        }

    }

}
