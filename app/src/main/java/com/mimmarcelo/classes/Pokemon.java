package com.mimmarcelo.classes;

import com.mimmarcelo.componentes.MItemList;

import java.util.Random;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public class Pokemon implements MItemList {
    private int id;
    private EEspecie especie;
    private String nome;

    public Pokemon(EEspecie especie){
        this.especie = especie;
        this.nome = "";
    }

    public EEspecie getEspecie() {
        return this.especie;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNomeImagem() {
        return "pokemon"+this.especie.getId();
    }

    @Override
    public String getNome() {
        return this.nome.isEmpty()? this.especie.getNome(): this.nome;
    }

    public void evoluir() {
        if(this.especie.getEvolucoes().size() == 1) {
            this.especie = this.especie.getEvolucoes().get(0);
        }
        else if(this.especie.getEvolucoes().size() > 1){
            Random random = new Random();
            this.especie = this.especie.getEvolucoes().get(random.nextInt(this.especie.getEvolucoes().size()));
        }

    }

    public void evoluir(EEspecie especie) {
        if(this.especie.getEvolucoes().contains(especie)){
            this.especie = especie;
        }
    }
}
