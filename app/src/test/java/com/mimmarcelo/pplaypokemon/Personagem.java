package com.mimmarcelo.pplaypokemon;

import com.mimmarcelo.classes.*;
import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.Pokemon;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Personagem {

    com.mimmarcelo.pplaypokemon.classes.Personagem personagem1;

    public Personagem(){
        personagem1 = new com.mimmarcelo.pplaypokemon.classes.Personagem();

        Pokemon p1 = new Pokemon(EEspecie.ABRA, 5);
        Pokemon p2 = new Pokemon(EEspecie.DRAGONITE, 36);
        Pokemon p3 = new Pokemon(EEspecie.EEVEE, 8);
        Pokemon p4 = new Pokemon(EEspecie.EEVEE, 6);
        Pokemon p5 = new Pokemon(EEspecie.SQUIRTLE, 36);
        Pokemon p6 = new Pokemon(EEspecie.KOFFING, 8);
        Pokemon p7 = new Pokemon(EEspecie.ODDISH, 6);

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
