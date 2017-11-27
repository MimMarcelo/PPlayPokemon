package com.mimmarcelo.dao;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Marcelo Júnior on 26-Nov-17.
 */

public class PersonagemDao {

    private static final String TABELA = "personagem";

    private static final String ID = "id";
    private static final String NOME = "nome";
    private static final String MAC = "mac";
    private static final String CAMINHO_DA_IMAGEM = "caminhodaimagem";

    private static final String[] CAMPOS = {ID, NOME, MAC, CAMINHO_DA_IMAGEM};

    private static void executar(BancoLocal bd){
        bd.droparTabela(TABELA);
        bd.criarTabela(TABELA, CAMPOS, new String[]{"integer primary key autoincrement",
        "text", "text", "text"});
    }

    public static String getPersonagem(Context context){
        BancoLocal bd = new BancoLocal(context);
        //executar(bd);
        String o = "";
        String where = ID+"=?";
        Cursor cursor = bd.select(TABELA, CAMPOS, where, new String[]{"1"}, null);
        if(cursor != null){
            o = cursor.getInt(0)+";"+cursor.getString(1)+";"+cursor.getString(2)+";"+cursor.getString(3);
            cursor.close();
        }
        return o;
    }

    public static void salvar(Context context, int id, String nome, String mac, String caminhoDaImagem){
        String sql = "INSERT INTO "+TABELA+" ("+NOME+", "+MAC+", "+CAMINHO_DA_IMAGEM+") VALUES ('"+
                nome+"', '"+mac+"', '"+caminhoDaImagem+"');";
        new BancoLocal(context).executar(sql);
    }
}
