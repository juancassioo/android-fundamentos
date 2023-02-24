package com.juan.marques.abas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.juan.marques.abas.fragments.EmAltaFragment;
import com.juan.marques.abas.fragments.HomeFragment;
import com.juan.marques.abas.fragments.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout view_pager_tab;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        // Configurar adapter para abas
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
          getSupportFragmentManager(), FragmentPagerItems
                .with(this)
                .add("Home", HomeFragment.class)
                .add("Inscrições", InscricoesFragment.class)
                .add("Em Alta", EmAltaFragment.class)
                .create());

        // Configurar viewPager
        view_pager.setAdapter(adapter);
        view_pager_tab.setViewPager(view_pager);

    }

    private void iniciarComponentes(){
        view_pager_tab = findViewById(R.id.view_pager_tab);
        view_pager = findViewById(R.id.view_pager);
    }

}