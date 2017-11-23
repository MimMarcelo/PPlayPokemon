package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.classes.EEspecie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Pokemon {

    com.mimmarcelo.classes.Pokemon p1;
    com.mimmarcelo.classes.Pokemon p2;
    com.mimmarcelo.classes.Pokemon p3;
    com.mimmarcelo.classes.Pokemon p4;

    public Pokemon(){
        p1 = new com.mimmarcelo.classes.Pokemon(EEspecie.ABRA);
        p2 = new com.mimmarcelo.classes.Pokemon(EEspecie.DRAGONITE);
        p3 = new com.mimmarcelo.classes.Pokemon(EEspecie.EEVEE);
        p4 = new com.mimmarcelo.classes.Pokemon(EEspecie.EEVEE);
    }
    @Test
    public void evoluir() {
        p1.evoluir();
        assertEquals(EEspecie.KADABRA, p1.getEspecie());
        p2.evoluir();
        assertEquals(EEspecie.DRAGONITE, p2.getEspecie());
        p3.evoluir();
        assertTrue((EEspecie.VAPOREON == p3.getEspecie()) ||
                (EEspecie.JOLTEON == p3.getEspecie()) ||
                (EEspecie.FLAREON == p3.getEspecie()));
        p4.evoluir(EEspecie.FLAREON);
        assertEquals(EEspecie.FLAREON, p4.getEspecie());
    }
}