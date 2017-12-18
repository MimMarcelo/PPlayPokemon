package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.pplaypokemon.classes.EEspecie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Pokemon {

    com.mimmarcelo.pplaypokemon.classes.Pokemon p1;
    com.mimmarcelo.pplaypokemon.classes.Pokemon p2;
    com.mimmarcelo.pplaypokemon.classes.Pokemon p3;
    com.mimmarcelo.pplaypokemon.classes.Pokemon p4;

    public Pokemon(){
        p1 = new com.mimmarcelo.pplaypokemon.classes.Pokemon(EEspecie.ABRA, 5);
        p2 = new com.mimmarcelo.pplaypokemon.classes.Pokemon(EEspecie.DRAGONITE, 36);
        p3 = new com.mimmarcelo.pplaypokemon.classes.Pokemon(EEspecie.EEVEE, 8);
        p4 = new com.mimmarcelo.pplaypokemon.classes.Pokemon(EEspecie.EEVEE, 6);
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

    @Test
    public void addExperiencia() {
        p1.addExperiencia(600);
        assertEquals(100, p1.getExperiencia());
        assertEquals(6, p1.getNivel());
        p2.addExperiencia(600);
        assertEquals(600, p2.getExperiencia());
        assertEquals(36, p2.getNivel());
        p3.addExperiencia(600);
        assertEquals(600, p3.getExperiencia());
        assertEquals(8, p3.getNivel());
        p4.addExperiencia(600);
        assertEquals(0, p4.getExperiencia());
        assertEquals(7, p4.getNivel());
    }

    public void testaNome(){
        assertEquals(EEspecie.ABRA.getNome(), p1.getNome());
        String nome = "Cabuloso";
        p1.setNome(nome);
        assertEquals(nome+" ("+EEspecie.ABRA.getNome()+")", p1.getNome());
    }

    @Test
    public void testaHp(){
        assertEquals(12, p1.getHpAtual());
    }
}