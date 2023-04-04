package com.juan.marques.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NOME_DB = "DB_TAREFAS";
    public static String TABELA_TAREFAS = "tarefas";


    public DbHelper(@Nullable Context context) {
        super(context, NOME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL); ";

        try {
            db.execSQL(sql);
            Log.i("Info DB", "sucesso ao criar tabela");
        }catch (Exception e){
            Log.i("Info DB", "erro ao criar tabela " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop table
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;";

        // Alter table
        // String sql = "ALTER TABLE " + TABELA_TAREFAS + " ADD COLUMN VARCHAR(1);";

        try {
            db.execSQL(sql);
            onCreate(db);
            Log.i("Info DB", "sucesso ao atualizar app");
        }catch (Exception e){
            Log.i("Info DB", "erro ao atualizar app " + e.getMessage());
        }

    }
}
