package com.mimmarcelo.pplaypokemon.classes;

import android.content.Context;

import com.mimmarcelo.pplaypokemon.classes.dao.PokemonDao;
import com.mimmarcelo.pplaypokemon.componentes.MItemList;

import java.util.List;
import java.util.Random;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public class Pokemon implements MItemList {

    private long id;
    private long idPersonagem;
    private long idServidor;
    private int nivel;
    private int experiencia;
    private int hpAtual;
    private int mpAtual;
    private boolean evolui;
    private boolean comProfessor;
    private String nome;
    private EEspecie especie;
    private EStatusPokemon statusPokemon;
    private ETecnica tecnica;
    private EStatus status;

    public Pokemon(long id, long idPersonagem, long idServidor, int nivel, int experiencia, int hpAtual, int mpAtual, boolean evolui, boolean comProfessor, String nome, EEspecie especie, EStatusPokemon statusPokemon, ETecnica tecnica, EStatus status) {
        this.id = id;
        this.idPersonagem = idPersonagem;
        this.idServidor = idServidor;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.hpAtual = hpAtual;
        this.mpAtual = mpAtual;
        this.evolui = evolui;
        this.comProfessor = comProfessor;
        this.nome = nome;
        this.especie = especie;
        this.statusPokemon = statusPokemon;
        this.tecnica = tecnica;
        this.status = status;
    }

    public Pokemon(long idPersonagem, EEspecie especie){
        this(0, idPersonagem, 0, 0, 0, 0, 0, true, false, "", especie, EStatusPokemon.NENHUM, null, EStatus.INSERIR);
    }

    public Pokemon(long idPersonagem, EEspecie especie, int nivel){
        this(0, idPersonagem, 0, nivel, 0, 0, 0, true, false, "", especie, EStatusPokemon.NENHUM, null, EStatus.INSERIR);
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPersonagem() {
        return idPersonagem;
    }

    public void setIdPersonagem(long ididPersonagem) {
        this.idPersonagem = ididPersonagem;
    }

    public long getIdServidor() {
        return idServidor;
    }

    public void setIdServidor(long idServidor) {
        this.idServidor = idServidor;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getHpAtual() {
        return hpAtual;
    }

    public int getHpTotal(){
        return ((this.especie.getForca()+this.especie.getResistencia()+this.especie.getVelocidade())/2)*this.nivel;
    }

    public void setHpAtual(int hpAtual) {
        if(hpAtual > this.getHpTotal()){
            this.hpAtual = this.getHpTotal();
        }
        else if (hpAtual < 0){
            this.hpAtual = 0;
        }
        else {
            this.hpAtual = hpAtual;
        }
    }

    public int getMpAtual() {
        return mpAtual;
    }

    public int getMpTotal(){
        return ((this.especie.getPoder()+this.especie.getProtecao()+this.especie.getVelocidade())/2)*this.nivel;
    }

    public void setMpAtual(int mpAtual) {
        if(mpAtual > this.getMpTotal()){
            this.mpAtual = this.getMpTotal();
        }
        else if (mpAtual < 0){
            this.mpAtual = 0;
        }
        else {
            this.mpAtual = hpAtual;
        }
    }

    public boolean isEvolui() {
        return evolui;
    }

    public void setEvolui(boolean evolui) {
        this.evolui = evolui;
    }

    public boolean isComProfessor() {
        return comProfessor;
    }

    public void setComProfessor(boolean comProfessor) {
        this.comProfessor = comProfessor;
    }

    @Override
    public String getNome() {
        return this.nome.isEmpty()? this.especie.getNome(): (this.nome+" ("+this.especie.getNome()+")");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EEspecie getEspecie() {
        return especie;
    }

    public void setEspecie(EEspecie especie) {
        this.especie = especie;
    }

    public EStatusPokemon getStatusPokemon() {
        return statusPokemon;
    }

    public void setStatusPokemon(EStatusPokemon statusPokemon) {
        this.statusPokemon = statusPokemon;
    }

    public ETecnica getTecnica() {
        return tecnica;
    }

    public void setTecnica(ETecnica tecnica) {
        this.tecnica = tecnica;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }
    @Override
    public String getNomeImagem() {
        return "pokemon"+this.especie.getId();
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

    public void addDano(int dano) {
        if(dano < this.hpAtual){
            this.hpAtual -= dano;
        }
        else {
            this.hpAtual = 0;
            this.setStatusPokemon(EStatusPokemon.ABATIDO);
        }
    }

    public static List<Pokemon> buscar(Context context, String where, String[] argumento){
        return PokemonDao.buscar(context, where, argumento);
    }
}
