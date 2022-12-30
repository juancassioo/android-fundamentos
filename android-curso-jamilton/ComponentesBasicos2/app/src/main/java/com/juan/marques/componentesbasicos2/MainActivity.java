package com.juan.marques.componentesbasicos2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Switch swt_lembrar_senha;
    private ToggleButton tgb_alterna;
    private Button btn_toast;
    private Button btn_alert_dialog;


    private ProgressBar prg_bar_circle;
    private ProgressBar prg_bar_horizontal;
    private Button btn_progress;

    private int progresso = 0;

    private SeekBar seek_bar;
    private TextView txt_progresso_seek_bar;
    private Button btn_seek_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

        // botão toast
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirToast();
            }
        });

        // botão alert dialog
        btn_alert_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirAlertDialog();
            }
        });

        // botão progress bar
        btn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarProgressBar();
            }
        });

        // componente seek bar
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // txt_progresso_seek_bar.setText("ao arrastar");
                txt_progresso_seek_bar.setText("Progresso: " + progress + "/" + seekBar.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // txt_progresso_seek_bar.setText("ao clicar");

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // txt_progresso_seek_bar.setText("ao parar");
            }
        });

        btn_seek_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recuperarProgressoSeekBar();
            }
        });


    }

    private void abrirToast(){

        // Criando objeto ImageView para o toast
        // ImageView imageView = new ImageView(getApplicationContext());
        // imageView.setImageResource(R.drawable.);

        // Criando objeto TextView para o toast
        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.teal_700);
        textView.setText("Toast personalizado");

        // Personalizando toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        //toast.setView(imageView);
        toast.setView(textView);
        toast.show();

        // Toast padrão
        // Toast.makeText(getApplicationContext(), "Mensagem Toast", Toast.LENGTH_LONG).show();
    }

    private void recuperarProgressoSeekBar(){
        txt_progresso_seek_bar.setText("Escolhido: " + seek_bar.getProgress());
    }

    private void carregarProgressBar(){

        // progress bar horizontal
        progresso++;
        prg_bar_horizontal.setProgress(progresso);

        // progress bar circular
        prg_bar_circle.setVisibility(View.VISIBLE);

        if(progresso == 10){
            prg_bar_circle.setVisibility(View.GONE);
        }

    }

    private void abrirAlertDialog(){

        // Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar título e mensagem
        dialog.setTitle("Título do AlertDialog");
        dialog.setMessage("Mensagem do AlertDialog");

        // Configurar ações para sim e não
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Mensagem Toast: positivo",
                        Toast.LENGTH_LONG).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Mensagem Toast: negativo",
                        Toast.LENGTH_LONG).show();
            }
        });

        // Criar e exibir AlertDialog
        dialog.create();
        dialog.show();

    }

    private void enviar(){

        // métodos do switch, toggleButton e checkBox
        if (swt_lembrar_senha.isChecked()){
            //txt_resultado.setText("Switch Ligado");
        }else {
            //txt_resultado.setText("Switch Desligado");
        }
            //txt_resultado.setVisibility(View.VISIBLE);
    }

    private void iniciarComponentes() {
        swt_lembrar_senha = findViewById(R.id.swt_lembrar_senha);
        tgb_alterna = findViewById(R.id.tgb_alterna);
        btn_toast = findViewById(R.id.btn_toast);
        btn_alert_dialog = findViewById(R.id.btn_alert_dialog);

        prg_bar_circle = findViewById(R.id.prg_bar_circle);
        prg_bar_horizontal = findViewById(R.id.prg_bar_horizontal);
        btn_progress = findViewById(R.id.btn_progress);

        seek_bar = findViewById(R.id.seek_bar);
        txt_progresso_seek_bar = findViewById(R.id.txt_progresso_seek_bar);
        btn_seek_bar = findViewById(R.id.btn_seek_bar);

    }
}