package com.mimmarcelo.pplaypokemon.classes.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.EStatus;
import com.mimmarcelo.pplaypokemon.classes.EStatusPokemon;
import com.mimmarcelo.pplaypokemon.classes.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo Júnior on 17-Dec-17.
 */

public class PokemonDao {

    private static final String TABELA = "pokemon";

    public static final String ID = "id";
    public static final String ID_PERSONAGEM = "idPersonagem";
    public static final String NIVEL = "nivel";
    public static final String EXPERIENCIA = "experiencia";
    public static final String HP_ATUAL = "hpAtual";
    public static final String MP_ATUAL = "mpAtual";
    public static final String EVOLUI = "evolui";
    public static final String COM_PROFESSOR = "comProfessor";
    public static final String NOME = "nome";
    public static final String ESPECIE = "especie";
    public static final String STATUS_POKEMON = "statusPokemon";
    public static final String STATUS = "status";
    public static final String ID_SERVIDOR = "idServidor";

    private static boolean inserir(Context context, Pokemon pokemon){
        Object[] valor = null;
        String[] campo = null;

        if(pokemon.getIdServidor() == 0) {
            valor = new Object[]{pokemon.getIdPersonagem(), pokemon.getNivel(), pokemon.getExperiencia(), pokemon.getHpAtual(),
                    pokemon.getMpAtual(), pokemon.isEvolui(), pokemon.isComProfessor(), pokemon.getNome(),
                    pokemon.getStatusPokemon().toString(), pokemon.getStatus().toString()};
            campo = new String[]{ID_PERSONAGEM, NIVEL, EXPERIENCIA, HP_ATUAL, MP_ATUAL, EVOLUI, COM_PROFESSOR,
                    NOME, STATUS_POKEMON, STATUS};
        }
        else {
            valor = new Object[]{pokemon.getIdServidor(), pokemon.getIdPersonagem(), pokemon.getNivel(), pokemon.getExperiencia(),
                    pokemon.getHpAtual(), pokemon.getMpAtual(), pokemon.isEvolui(), pokemon.isComProfessor(),
                    pokemon.getNome(), pokemon.getStatusPokemon().toString(), pokemon.getStatus().toString()};
            campo = new String[]{ID_SERVIDOR, ID_PERSONAGEM, NIVEL, EXPERIENCIA, HP_ATUAL, MP_ATUAL, EVOLUI,
                    COM_PROFESSOR, NOME, STATUS_POKEMON, STATUS};
        }

        Banco bd = new Banco(context);
        long id = bd.inserir(TABELA, campo, valor);
        bd.close();
        if(id > 0) {
            pokemon.setId(id);
            return true;
        }

        return false;
    }

    private static boolean atualizar(Context context, Pokemon pokemon){
        Object[] valor = null;
        String[] campo = null;

        if((pokemon.getStatus() == EStatus.OK_EXCLUIR) ||
                (pokemon.getStatus() == EStatus.EXCLUIR && pokemon.getIdServidor() == 0)) {
            return excluir(context, pokemon);
        }
        else {

            if(pokemon.getIdServidor() == 0) {
                valor = new Object[]{pokemon.getIdPersonagem(), pokemon.getNivel(), pokemon.getExperiencia(), pokemon.getHpAtual(),
                        pokemon.getMpAtual(), pokemon.isEvolui(), pokemon.isComProfessor(), pokemon.getNome(),
                        pokemon.getStatusPokemon().toString(), pokemon.getStatus().toString()};
                campo = new String[]{ID_PERSONAGEM, NIVEL, EXPERIENCIA, HP_ATUAL, MP_ATUAL, EVOLUI, COM_PROFESSOR,
                        NOME, STATUS_POKEMON, STATUS};
            }
            else {
                valor = new Object[]{pokemon.getIdServidor(), pokemon.getIdPersonagem(), pokemon.getNivel(), pokemon.getExperiencia(),
                        pokemon.getHpAtual(), pokemon.getMpAtual(), pokemon.isEvolui(), pokemon.isComProfessor(),
                        pokemon.getNome(), pokemon.getStatusPokemon().toString(), pokemon.getStatus().toString()};
                campo = new String[]{ID_SERVIDOR, ID_PERSONAGEM, NIVEL, EXPERIENCIA, HP_ATUAL, MP_ATUAL, EVOLUI,
                        COM_PROFESSOR, NOME, STATUS_POKEMON, STATUS};
            }

            Banco bd = new Banco(context);
            long linhasAfetadas = bd.atualizar(TABELA, campo, valor, ID+"=?", new String[]{String.valueOf(pokemon.getId())});
            bd.close();

            if (linhasAfetadas > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean salvar(Context context, Pokemon pokemon) {
        if(pokemon.getId() == 0)
            return inserir(context, pokemon);
        else
            return atualizar(context, pokemon);
    }

    private static boolean excluir(Context context, Pokemon produto) {
        Banco bd = new Banco(context);
        int n = bd.excluir(TABELA, ID+"=?", new String[]{String.valueOf(produto.getId())});
        bd.close();
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static List<Pokemon> buscar(Context context, String where, String[] argumento, String groupBy, String having, String orderBy){
        Banco bd = new Banco(context);
        List<Pokemon> pokemons = new ArrayList<>();

        try{
            Cursor cursor = bd.buscar(TABELA, new String[]{ID, ID_PERSONAGEM, ID_SERVIDOR, NIVEL, EXPERIENCIA, HP_ATUAL, MP_ATUAL, EVOLUI,
                    COM_PROFESSOR, NOME, STATUS_POKEMON, STATUS}, where, argumento, groupBy, having, COM_PROFESSOR+" desc");

            while(!cursor.isAfterLast()){

                Pokemon pokemon = new Pokemon(
                        cursor.getLong(cursor.getColumnIndex(ID)),
                        cursor.getLong(cursor.getColumnIndex(ID_PERSONAGEM)),
                        cursor.getLong(cursor.getColumnIndex(ID_SERVIDOR)),
                        cursor.getInt(cursor.getColumnIndex(NIVEL)),
                        cursor.getInt(cursor.getColumnIndex(EXPERIENCIA)),
                        cursor.getInt(cursor.getColumnIndex(HP_ATUAL)),
                        cursor.getInt(cursor.getColumnIndex(MP_ATUAL)),
                        cursor.getInt(cursor.getColumnIndex(EVOLUI))==1?true:false,
                        cursor.getInt(cursor.getColumnIndex(COM_PROFESSOR))==1?true:false,
                        cursor.getString(cursor.getColumnIndex(NOME)),
                        EEspecie.valueOf(cursor.getString(cursor.getColumnIndex(ESPECIE))),
                        EStatusPokemon.valueOf(cursor.getString(cursor.getColumnIndex(STATUS_POKEMON))),
                        null,
                        EStatus.valueOf(cursor.getString(cursor.getColumnIndex(STATUS))));
                pokemons.add(pokemon);
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

        return pokemons;
    }

    public static List<Pokemon> buscar(Context context, String where, String[] argumento) {
        return buscar(context, where, argumento, null, null, null);
    }

    public static void criarTabela(Context context){
        Banco bd = new Banco(context);
        bd.criarTabela(TABELA,
                new String[]{
                        ID,
                        ID_PERSONAGEM,
                        NIVEL,
                        EXPERIENCIA,
                        HP_ATUAL,
                        MP_ATUAL,
                        EVOLUI,
                        COM_PROFESSOR,
                        NOME,
                        ESPECIE,
                        STATUS_POKEMON,
                        STATUS,
                        ID_SERVIDOR},
                new String[]{
                        Banco.INTEGER_PRIMARY_KEY_AUTOINCREMENT,
                        Banco.INTEGER_NOT_NULL,
                        Banco.INTEGER_NOT_NULL,
                        Banco.INTEGER_NOT_NULL,
                        Banco.INTEGER_NOT_NULL,
                        Banco.INTEGER_NOT_NULL,
                        Banco.INTEGER,
                        Banco.INTEGER,
                        Banco.TEXT,
                        Banco.TEXT_NOT_NULL,
                        Banco.TEXT_NOT_NULL,
                        Banco.TEXT_NOT_NULL,
                        Banco.INTEGER_UNIQUE});
        bd.close();
    }

    private static void limparTabela(Banco bd){
        bd.limparTabela(TABELA);
    }

}
