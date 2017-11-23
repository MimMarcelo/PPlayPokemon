package com.mimmarcelo.classes;

import com.mimmarcelo.componentes.MItemList;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 16-Nov-17.
 */

public enum ETipo implements MItemList{
    AGUA(1, "Água", new ArrayList<Double>(){{add(1.0);add(0.8);add(1.0);add(1.0);add(0.8);add(1.3);add(0.9);add(0.7);add(0.8);add(1.0);add(0.9);add(1.0);add(1.0);add(1.5);add(1.0);add(1.5);add(1.0);add(0.8);}}),
    DRAGAO(2, "Dragão", new ArrayList<Double>(){{add(1.0);add(1.3);add(1.0);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(0.9);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);}}),
    ELETRICO(3, "Elétrico", new ArrayList<Double>(){{add(1.6);add(1.0);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(0.7);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(1.0);add(0.5);add(1.0);add(1.5);}}),
    FADA(4, "Fada", new ArrayList<Double>(){{add(1.0);add(1.3);add(1.0);add(1.0);add(1.1);add(1.0);add(1.0);add(1.0);add(1.0);add(1.1);add(1.0);add(1.0);add(1.0);add(1.0);add(0.7);add(1.0);add(0.8);add(1.0);}}),
    FANTASMA(5, "Fantasma", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(0.8);add(1.2);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(0.9);add(1.0);add(1.3);add(1.0);add(1.0);add(1.0);}}),
    FOGO(6, "Fogo", new ArrayList<Double>(){{add(0.9);add(0.7);add(1.0);add(1.4);add(0.7);add(0.8);add(1.1);add(1.3);add(1.3);add(1.0);add(1.3);add(1.0);add(1.0);add(0.7);add(1.0);add(0.8);add(1.0);add(1.0);}}),
    GELO(7, "Gelo", new ArrayList<Double>(){{add(1.0);add(1.3);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(0.8);add(1.1);add(1.0);add(1.1);add(1.0);add(1.0);add(0.8);add(1.0);add(0.9);add(1.0);add(1.1);}}),
    GRAMA(8, "Grama", new ArrayList<Double>(){{add(1.0);add(0.8);add(1.0);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);add(1.2);add(1.0);add(1.2);add(1.0);add(1.0);}}),
    INSETO(9, "Inseto", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(1.5);add(1.0);add(1.0);add(0.8);add(1.0);add(1.2);add(0.8);add(1.2);add(0.9);add(1.0);add(0.8);}}),
    LUTADOR(10, "Lutador", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.2);add(1.2);add(1.1);add(1.2);add(0.7);add(0.9);add(1.0);add(0.8);}}),
    METAL(11, "Metal", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(1.2);add(1.0);add(1.0);add(1.3);add(1.0);add(1.0);add(0.7);add(1.0);add(1.0);add(0.9);add(1.2);add(1.0);add(1.2);add(1.0);add(0.8);}}),
    NORMAL(12, "Normal", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);}}),
    NOTURNO(13, "Noturno", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(0.5);add(1.4);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(1.1);add(1.0);add(1.0);add(1.0);add(1.2);add(1.0);add(1.0);add(1.0);}}),
    PEDRA(14, "Pedra", new ArrayList<Double>(){{add(0.8);add(1.0);add(1.0);add(1.0);add(0.8);add(1.0);add(1.3);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);add(1.2);}}),
    PSIQUICO(15, "Psiquico", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(1.3);add(0.8);add(1.0);add(0.9);add(1.0);add(1.0);add(1.0);add(1.2);add(1.0);}}),
    TERRA(16, "Terra", new ArrayList<Double>(){{add(0.7);add(1.0);add(1.0);add(1.0);add(1.0);add(1.1);add(1.0);add(0.9);add(1.0);add(1.0);add(1.2);add(1.0);add(1.0);add(1.1);add(1.0);add(1.0);add(1.0);add(1.0);}}),
    VENENOSO(17, "Venenoso", new ArrayList<Double>(){{add(1.0);add(1.0);add(1.0);add(1.4);add(1.0);add(1.0);add(0.9);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(1.0);add(0.8);add(1.0);add(0.9);add(1.0);add(1.0);}}),
    VOADOR(18, "Voador", new ArrayList<Double>(){{add(1.0);add(0.8);add(1.0);add(0.8);add(1.0);add(1.0);add(0.9);add(1.1);add(1.1);add(1.1);add(1.0);add(1.0);add(1.0);add(0.9);add(1.0);add(1.3);add(1.0);add(1.0);}}),
    ;
    private int id;
    private String nome;
    private ArrayList<Double> vantagens;

    ETipo(int id, String nome, ArrayList<Double> vantagens) {
        this.id = id;
        this.nome = nome;
        this.vantagens = vantagens;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNomeImagem() {
        return "tipo"+this.id;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    public double getVantagem(ArrayList<ETipo> tipos){
        double vantagem = 0;
        if(tipos.size() == 1){
            vantagem = this.vantagens.get(tipos.get(0).getId()-1);
        }
        else if(tipos.size() > 1){
            double vantagem1 = this.vantagens.get(tipos.get(0).getId()-1);
            double vantagem2 = this.vantagens.get(tipos.get(1).getId()-1);
            if(vantagem1 > 1 && vantagem2 > 1){
                vantagem = vantagem1>vantagem2?vantagem1:vantagem2;
                vantagem += 0.1;
            }
            else if(vantagem1 < 1 && vantagem2 < 1){
                vantagem = vantagem1<vantagem2?vantagem1:vantagem2;
                vantagem -= 0.1;
            }
            else {
                vantagem = (this.vantagens.get(tipos.get(0).getId() - 1) + this.vantagens.get(tipos.get(1).getId() - 1)) / 2;
            }
        }

        return vantagem;
    }
}
