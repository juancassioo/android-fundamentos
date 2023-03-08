package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Criar banco de dados
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("app", MODE_PRIVATE, null);

            // Criar tabela
//            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");
            // sqLiteDatabase.execSQL("DROP TABLE pessoas");
            // sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            // Inserir valores na tabela
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Jamilton', 30)");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Guanabara', 30)");
//            sqLiteDatabase.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Leonardo', 30)");

            sqLiteDatabase.execSQL("UPDATE pessoas SET idade = 18 WHERE nome = 'Guanabara'");
            sqLiteDatabase.execSQL("DELETE FROM pessoas WHERE nome = 'Guanabara'");

            // Recuperar pessoas
            String consulta = "SELECT nome, idade FROM pessoas WHERE nome = 'Jamilton' AND idade = 30";
            // String consulta = "SELECT nome, idade FROM pessoas WHERE idade >= 35 OR idade = 18";
            // String consulta = "SELECT nome, idade FROM pessoas WHERE idade IN(18,35)";
            // String consulta = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 30 AND 35";
            // String filtro = "jam";
            // String consulta = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%" + filtro + "%'";
            // String consulta = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC LIMIT 3";

            Cursor cursor = sqLiteDatabase.rawQuery(consulta, null);

            // Índices da tabela
            // int indiceID = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - nome ", nome + " | idade: " + idade);
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}