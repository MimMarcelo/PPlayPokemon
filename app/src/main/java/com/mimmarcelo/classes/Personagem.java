package com.mimmarcelo.classes;

import android.content.Context;

import com.mimmarcelo.componentes.MItemList;
import com.mimmarcelo.dao.PersonagemDao;
import com.mimmarcelo.pplaypokemon.CadastroPersonagemActivity;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 25-Nov-17.
 */

public class Personagem implements MItemList {
    private int id;
    private String nome;
    private String mac;
    private String nomeImagem;
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
        return this.nomeImagem;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
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

    public static Personagem carregarDados(Context context){
        String o = PersonagemDao.getPersonagem(context);

        String[] s = o.split(";");
        Personagem personagem = new Personagem();
        try {
            personagem.id = Integer.parseInt(s[0]);
            personagem.nome = s[1];
            personagem.mac = s[2];
            personagem.nomeImagem = s[3];
        }
        catch (IndexOutOfBoundsException e){
            personagem = null;
        }
        catch (NullPointerException e){
            personagem = null;
        }
        catch (Exception e){
            personagem = null;
        }
        return personagem;
    }

    public String getMac() {
        return this.mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void salvar(Context context) {
        PersonagemDao.salvar(context, 0, this.nome, this.mac, this.nomeImagem);
    }
}
