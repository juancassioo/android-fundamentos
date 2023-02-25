package com.juan.marques.aprendaingles.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.juan.marques.aprendaingles.R;
import com.juan.marques.aprendaingles.fragments.BichosFragment;
import com.juan.marques.aprendaingles.fragments.NumerosFragment;
import com.juan.marques.aprendaingles.fragments.VogaisFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class MainActivity extends AppCompatActivity {

    private SmartTabLayout smart_tab_layout;
    private ViewPager view_pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();
        getSupportActionBar().setElevation(0);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                        .add("Bichos", BichosFragment.class)
                        .add("Números", NumerosFragment.class)
                        .add("Vogais", VogaisFragment.class)
                        .create());

        view_pager.setAdapter(adapter);
        smart_tab_layout.setViewPager(view_pager);

    }

    private void iniciarComponentes(){
        smart_tab_layout = findViewById(R.id.smart_tab_layout);
        view_pager = findViewById(R.id.view_pager);
    }
}