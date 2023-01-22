package com.juan.marques.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.juan.marques.fragments.R;
import com.juan.marques.fragments.fragment.ContatosFragment;
import com.juan.marques.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btn_conversas;
    private Button btn_contatos;

    ConversasFragment conversasFragment;
    ContatosFragment contatosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, conversasFragment);
        transaction.commit();

        btn_contatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, contatosFragment);
                transaction.commit();

            }
        });

        btn_conversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, conversasFragment);
                transaction.commit();
            }
        });

    }

    private void iniciarComponentes(){
        btn_conversas = findViewById(R.id.btn_conversas);
        btn_contatos = findViewById(R.id.btn_contatos);
    }

}