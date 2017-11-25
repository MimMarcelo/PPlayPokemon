package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.classes.*;
import com.mimmarcelo.classes.Pokemon;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Personagem {

    com.mimmarcelo.classes.Personagem personagem1;

    public Personagem(){
        personagem1 = new com.mimmarcelo.classes.Personagem();

        com.mimmarcelo.classes.Pokemon p1 = new com.mimmarcelo.classes.Pokemon(EEspecie.ABRA, 5);
        com.mimmarcelo.classes.Pokemon p2 = new com.mimmarcelo.classes.Pokemon(EEspecie.DRAGONITE, 36);
        com.mimmarcelo.classes.Pokemon p3 = new com.mimmarcelo.classes.Pokemon(EEspecie.EEVEE, 8);
        com.mimmarcelo.classes.Pokemon p4 = new com.mimmarcelo.classes.Pokemon(EEspecie.EEVEE, 6);
        com.mimmarcelo.classes.Pokemon p5 = new com.mimmarcelo.classes.Pokemon(EEspecie.SQUIRTLE, 36);
        com.mimmarcelo.classes.Pokemon p6 = new com.mimmarcelo.classes.Pokemon(EEspecie.KOFFING, 8);
        com.mimmarcelo.classes.Pokemon p7 = new com.mimmarcelo.classes.Pokemon(EEspecie.ODDISH, 6);

        personagem1.addPokemon(p1);
        personagem1.addPokemon(p2);
        personagem1.addPokemon(p3);
        personagem1.addPokemon(p4);
        personagem1.addPokemon(p5);
        personagem1.addPokemon(p6);
        personagem1.addPokemon(p7);
    }

    @Test
    public void testAddPokemon(){
        assertEquals(false, personagem1.getPokemons().get(0).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(1).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(2).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(3).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(4).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(5).comProfessor());
        assertEquals(true, personagem1.getPokemons().get(6).comProfessor());

        personagem1.getPokemons().get(3).setComProfessor(true);
        personagem1.addPokemon(new Pokemon(EEspecie.ELECTRODE));
        assertEquals(false, personagem1.getPokemons().get(0).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(1).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(2).comProfessor());
        assertEquals(true, personagem1.getPokemons().get(3).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(4).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(5).comProfessor());
        assertEquals(true, personagem1.getPokemons().get(6).comProfessor());
        assertEquals(false, personagem1.getPokemons().get(7).comProfessor());

    }
}
