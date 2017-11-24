package com.mimmarcelo.classes;

import com.mimmarcelo.componentes.MItemList;

import java.util.Random;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public class Pokemon implements MItemList {
    private int id;
    private int nivel;
    private int experiencia;
    private int hpAtual;
    private boolean evolui;
    private String nome;
    private EEspecie especie;
    private ETecnica tecnica;

    public Pokemon(EEspecie especie){
        this.especie = especie;
        this.evolui = true;
        this.nome = "";
    }

    public Pokemon(EEspecie especie, int nivel){
        this(especie);
        this.nivel = nivel;
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
        return this.nome.isEmpty()? this.especie.getNome(): (this.nome+" ("+this.especie.getNome()+")");
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public boolean isEvolui() {
        return evolui;
    }

    public void setEvolui(boolean evolui) {
        this.evolui = evolui;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void evoluir() {
        if (this.especie.getEvolucoes().size() == 1) {
            this.especie = this.especie.getEvolucoes().get(0);
        } else if (this.especie.getEvolucoes().size() > 1) {
            Random random = new Random();
            this.especie = this.especie.getEvolucoes().get(random.nextInt(this.especie.getEvolucoes().size()));
        }
    }

    public void evoluir(EEspecie especie) {
        if(this.especie.getEvolucoes().contains(especie)){
            this.especie = especie;
        }
    }

    public void addExperiencia(int xp) {
        if (xp > 0) {
            if ((this.experiencia + xp) >= (this.nivel * 100)) {
                this.experiencia = (this.experiencia + xp) - (this.nivel * 100);
                this.nivel++;
            } else {
                this.experiencia += xp;
            }
        }
    }

    public int getHpTotal(){
        return ((this.especie.getForca()+this.especie.getResistencia()+this.especie.getVelocidade())/2)*this.nivel;
    }

    public int getHpAtual() {
        return this.hpAtual;
    }
}
