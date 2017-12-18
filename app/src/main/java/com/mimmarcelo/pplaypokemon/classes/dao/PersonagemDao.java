package com.mimmarcelo.pplaypokemon.classes.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.mimmarcelo.pplaypokemon.classes.EStatus;
import com.mimmarcelo.pplaypokemon.classes.Personagem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo Júnior on 26-Nov-17.
 */

public class PersonagemDao {

    private static final String TABELA = "personagem";

    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String MAC = "mac";
    public static final String CAMINHO_DA_IMAGEM = "imagem";
    public static final String STATUS = "status";
    public static final String ID_SERVIDOR = "id_servidor";

    private static boolean inserir(Context context, Personagem personagem){
        Object[] valor = null;
        String[] campo = null;

        if(personagem.getIdServidor() == 0) {
            valor = new Object[]{personagem.getNome(), personagem.getMac(), personagem.getNomeImagem(), personagem.getStatus().toString()};
            campo = new String[]{NOME, MAC, CAMINHO_DA_IMAGEM, STATUS};
        }
        else {
            valor = new Object[]{personagem.getIdServidor(), personagem.getNome(), personagem.getMac(), personagem.getNomeImagem(), personagem.getStatus().toString()};
            campo = new String[]{ID_SERVIDOR, NOME, MAC, CAMINHO_DA_IMAGEM, STATUS};
        }

        Banco bd = new Banco(context);
        long id = bd.inserir(TABELA, campo, valor);
        bd.close();
        if(id > 0) {
            personagem.setId(id);
            return true;
        }

        return false;
    }

    private static boolean atualizar(Context context, Personagem personagem){
        Object[] valor = null;
        String[] campo = null;

        if((personagem.getStatus() == EStatus.OK_EXCLUIR) ||
                (personagem.getStatus() == EStatus.EXCLUIR && personagem.getIdServidor() == 0)) {
            return excluir(context, personagem);
        }
        else {

            if(personagem.getIdServidor() == 0) {
                valor = new Object[]{personagem.getNome(), personagem.getMac(), personagem.getNomeImagem(), EStatus.INSERIR};
                campo = new String[]{NOME, MAC, CAMINHO_DA_IMAGEM, STATUS};
            }
            else {
                valor = new Object[]{personagem.getIdServidor(), personagem.getNome(), personagem.getMac(), personagem.getNomeImagem(), personagem.getStatus().toString()};
                campo = new String[]{ID_SERVIDOR, NOME, MAC, CAMINHO_DA_IMAGEM, STATUS};
            }

            Banco bd = new Banco(context);
            long linhasAfetadas = bd.atualizar(TABELA, campo, valor, ID+"=?", new String[]{String.valueOf(personagem.getId())});
            bd.close();

            if (linhasAfetadas > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean salvar(Context context, Personagem personagem) {
        if(personagem.getId() == 0)
            return inserir(context, personagem);
        else
            return atualizar(context, personagem);
    }

    private static boolean excluir(Context context, Personagem produto) {
        Banco bd = new Banco(context);
        int n = bd.excluir(TABELA, ID+"=?", new String[]{String.valueOf(produto.getId())});
        bd.close();
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static List<Personagem> buscar(Context context, String where, String[] argumento, String groupBy, String having, String orderBy){
        Banco bd = new Banco(context);
        List<Personagem> personagems = new ArrayList<>();

        try{
            Cursor cursor = bd.buscar(TABELA, new String[]{ID, NOME, MAC, CAMINHO_DA_IMAGEM, STATUS, ID_SERVIDOR}, where, argumento, groupBy, having, orderBy);

            while(!cursor.isAfterLast()){

                Personagem personagem = new Personagem(
                        cursor.getLong(cursor.getColumnIndex(ID)),
                        cursor.getLong(cursor.getColumnIndex(ID_SERVIDOR)),
                        cursor.getString(cursor.getColumnIndex(NOME)),
                        cursor.getString(cursor.getColumnIndex(MAC)),
                        cursor.getString(cursor.getColumnIndex(CAMINHO_DA_IMAGEM)),
                        EStatus.valueOf(cursor.getString(cursor.getColumnIndex(STATUS))));
                personagems.add(personagem);
                cursor.moveToNext();
            }
            cursor.close();
        }
        catch (SQLiteException e){
            if(e.getMessage().startsWith("no such table")){
                criarTabela(context);
            }
            else{
                e.printStackTrace();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return personagems;
    }

    public static List<Personagem> buscar(Context context, String where, String[] argumento) {
        return buscar(context, where, argumento, null, null, null);
    }

    public static void criarTabela(Context context){
        Banco bd = new Banco(context);
        bd.criarTabela(TABELA,
                new String[]{
                        ID,
                        NOME,
                        MAC,
                        CAMINHO_DA_IMAGEM,
                        STATUS,
                        ID_SERVIDOR},
                new String[]{
                        Banco.INTEGER_PRIMARY_KEY_AUTOINCREMENT,
                        Banco.TEXT_NOT_NULL,
                        Banco.TEXT_NOT_NULL,
                        Banco.TEXT,
                        Banco.INTEGER,
                        Banco.INTEGER_UNIQUE});
        bd.close();
    }

    private static void limparTabela(Banco bd){
        bd.limparTabela(TABELA);
    }

}
