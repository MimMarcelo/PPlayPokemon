package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.classes.EEspecie;
import com.mimmarcelo.classes.EStatus;
import com.mimmarcelo.classes.ETipo;
import com.mimmarcelo.classes.Pokemon;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Batalha {

    Pokemon p1;

    public Batalha(){
        p1 = new Pokemon(EEspecie.PERSIAN, 23);
    }

    @Test
    public void aplicaDano() {
        p1.setHpAtual(p1.getHpTotal());

        assertEquals(34, p1.getHpAtual());
        com.mimmarcelo.classes.Batalha b = new com.mimmarcelo.classes.Batalha(new ArrayList<Pokemon>(), new ArrayList<Pokemon>(){{add(p1);}});

        b.aplicarAtaque(12, EStatus.ASSUSTADO, p1);
        assertEquals(22, p1.getHpAtual());
        assertEquals(EStatus.ASSUSTADO, p1.getStatus());

        b.aplicarAtaque(30, EStatus.ASSUSTADO, p1);
        assertEquals(0, p1.getHpAtual());
        assertEquals(EStatus.ABATIDO, p1.getStatus());
    }
}