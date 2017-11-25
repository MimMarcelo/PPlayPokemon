package com.mimmarcelo.classes;

import com.mimmarcelo.componentes.MItemList;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 25-Nov-17.
 */

public class Personagem implements MItemList {
    private int id;
    private String nome;
    private ArrayList<Pokemon> pokemons;

    public Personagem() {
        pokemons = new ArrayList<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNomeImagem() {
        return null;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getNPokemonsComPersonagem(){
        int n = 0;
        for(Pokemon p: this.pokemons){
            if(!p.comProfessor()){
                n++;
            }
        }
        return n;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon p){
        p.setComProfessor(this.getNPokemonsComPersonagem() >= 6? true:false);
        this.pokemons.add(p);
    }
}
