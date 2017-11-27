package com.mimmarcelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 26-Nov-17.
 */

public class BancoLocal extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "PPlayPokemon"; //NOME DO BANCO DE DADOS
    private static final int VERSAO = 1; //VERSÃO DO BANCO

    private SQLiteDatabase sqLite;

    public BancoLocal(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    //EXECUTA CONSULTA COM RESTRIÇÕES
    public Cursor select(String tabela, String[] campos, String where, String[] argumentos, String orderBy){

        sqLite = getReadableDatabase();
        Cursor cursor = sqLite.query(tabela, campos, where, argumentos, null, null, orderBy);

        if(cursor!=null) {
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
            }
            else{
                cursor.close();
                cursor = null;
            }
        }
        sqLite.close();

        return cursor;
    }

    public void criarTabela(String tabela, String[] campos, String[] tiposDosCampos){
        StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
        sql.append(tabela);
        sql.append(" (");

        for(int i = 0; i < campos.length; i++){

            if(i>0) sql.append(", ");

            sql.append(campos[i]);
            sql.append(" ");
            sql.append(tiposDosCampos[i]);
        }
        sql.append(");");
        executar(sql.toString());
    }

    public void droparTabela(String tabela){
        executar("DROP TABLE "+tabela+";");
    }

    //EXECUTA QUALQUER QUERY ENVIADA
    public void executar(String sql){
        sqLite = getWritableDatabase();
        sqLite.execSQL(sql);
        sqLite.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
