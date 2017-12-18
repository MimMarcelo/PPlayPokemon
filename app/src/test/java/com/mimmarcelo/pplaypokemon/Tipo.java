package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.ETipo;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Tipo {

    ETipo p1;

    public Tipo(){
        p1 = ETipo.AGUA;
    }
    @Test
    public void vantagens() {

        assertEquals(1.0, p1.getVantagem(new ArrayList<ETipo>(){{add(ETipo.AGUA);}}), 0);
        assertEquals(0.8, p1.getVantagem(new ArrayList<ETipo>(){{add(ETipo.DRAGAO);}}), 0);
        assertEquals(1.0, p1.getVantagem(new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}), 0);
        assertEquals(0.85, p1.getVantagem(EEspecie.BULBASAUR.getTipos()), 0);
        assertEquals(1.6, p1.getVantagem(EEspecie.GOLEM.getTipos()), 0);
    }
}