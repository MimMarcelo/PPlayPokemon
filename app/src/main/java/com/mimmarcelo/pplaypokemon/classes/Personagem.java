package com.mimmarcelo.pplaypokemon.classes;

import android.content.Context;
import android.support.annotation.Nullable;

import com.mimmarcelo.pplaypokemon.componentes.MItemList;
import com.mimmarcelo.pplaypokemon.classes.dao.PersonagemDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo Júnior on 25-Nov-17.
 */

public class Personagem implements MItemList {
    private long id;
    private long idServidor;
    private String nome;
    private String mac;
    private String nomeImagem;
    private EStatus status;
    private ArrayList<Pokemon> pokemons;

    public Personagem(long id, long idServidor, String nome, String mac, String nomeImagem, EStatus status, ArrayList<Pokemon> pokemons) {
        this.id = id;
        this.idServidor = idServidor;
        this.nome = nome;
        this.mac = mac;
        this.nomeImagem = nomeImagem;
        this.status = status;
        this.pokemons = pokemons;
    }

    public Personagem(long id, long idServidor, String nome, String mac, String nomeImagem, EStatus status) {
        this(id, idServidor, nome, mac, nomeImagem, status, new ArrayList<Pokemon>());
    }

    public Personagem(String nome, String mac, EStatus status){
        this(0, 0, nome, mac, "", status);
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(long idServidor) {
        this.idServidor = idServidor;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getNPokemonsComPersonagem(){
        int n = 0;
        for(Pokemon p: this.pokemons){
            if(!p.isComProfessor()){
                n++;
            }
        }
        return n;
    }

    public void addPokemon(Pokemon p){
        p.setComProfessor(this.getNPokemonsComPersonagem() >= 6? true:false);
        this.pokemons.add(p);
    }

    //-------------------------------MÉTODOS COM ACESSO AO BANCO DE DADOS LOCAL
    @Nullable
    public static Personagem carregarDados(Context context){
        List<Personagem> aux = PersonagemDao.buscar(context, PersonagemDao.ID+"=?", new String[]{"1"});
        if(aux.size() > 0){
            return  aux.get(0);
        }
        return null;
    }

    public boolean salvar(Context context){
        return PersonagemDao.salvar(context, this);
    }

}
