package com.juan.marques.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.juan.marques.aprendaingles.R;
import com.juan.marques.aprendaingles.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BichosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageButton imgBtn_cachorro;
    private ImageButton imgBtn_gato;
    private ImageButton imgBtn_leao;
    private ImageButton imgBtn_macaco;
    private ImageButton imgBtn_ovelha;
    private ImageButton imgBtn_vaca;

    private MediaPlayer mediaPlayer;

    public BichosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BichosFragments.
     */
    // TODO: Rename and change types and number of parameters
    public static BichosFragment newInstance(String param1, String param2) {
        BichosFragment fragment = new BichosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        imgBtn_cachorro = view.findViewById(R.id.imgBtn_cachorro);
        imgBtn_gato = view.findViewById(R.id.imgBtn_gato);
        imgBtn_leao = view.findViewById(R.id.imgBtn_leao);
        imgBtn_macaco = view.findViewById(R.id.imgBtn_macaco);
        imgBtn_ovelha = view.findViewById(R.id.imgBtn_ovelha);
        imgBtn_vaca = view.findViewById(R.id.imgBtn_vaca);

        imgBtn_cachorro.setOnClickListener(this);
        imgBtn_gato.setOnClickListener(this);
        imgBtn_leao.setOnClickListener(this);
        imgBtn_macaco.setOnClickListener(this);
        imgBtn_ovelha.setOnClickListener(this);
        imgBtn_vaca.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.imgBtn_cachorro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;
            case R.id.imgBtn_gato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;
            case R.id.imgBtn_leao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;
            case R.id.imgBtn_macaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;
            case R.id.imgBtn_ovelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;
            case R.id.imgBtn_vaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }

    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}