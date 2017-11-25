package com.mimmarcelo.classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Marcelo Júnior on 24-Nov-17.
 */

public class Batalha {
    ArrayList<Pokemon> time1;
    ArrayList<Pokemon> time2;
    Random random;

    public Batalha(ArrayList<Pokemon> time1, ArrayList<Pokemon> time2) {
        this.time1 = time1;
        this.time2 = time2;
        random = new Random();
    }

    public void aplicarAtaque(int dano, EStatus status, Pokemon pAlvo){
        if(dano < pAlvo.getHpAtual()){
            pAlvo.addDano(dano);
            if(random.nextInt(2) < 1){
                pAlvo.setStatus(status);
            }
        }
        else {
            pAlvo.setHpAtual(0);
            pAlvo.setStatus(EStatus.ABATIDO);
        }
    }
}
