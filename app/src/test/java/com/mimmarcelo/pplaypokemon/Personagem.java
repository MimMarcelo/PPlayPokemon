package com.mimmarcelo.pplaypokemon;


import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.EStatus;
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
        personagem1 = new com.mimmarcelo.pplaypokemon.classes.Personagem("Marcelo", "", EStatus.INSERIR);

        Pokemon p1 = new Pokemon(5, EEspecie.ABRA, 5);
        Pokemon p2 = new Pokemon(5, EEspecie.DRAGONITE, 36);
        Pokemon p3 = new Pokemon(5, EEspecie.EEVEE, 8);
        Pokemon p4 = new Pokemon(5, EEspecie.EEVEE, 6);
        Pokemon p5 = new Pokemon(5, EEspecie.SQUIRTLE, 36);
        Pokemon p6 = new Pokemon(5, EEspecie.KOFFING, 8);
        Pokemon p7 = new Pokemon(5, EEspecie.ODDISH, 6);

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
        assertEquals(false, personagem1.getPokemons().get(0).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(1).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(2).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(3).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(4).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(5).isComProfessor());
        assertEquals(true, personagem1.getPokemons().get(6).isComProfessor());

        personagem1.getPokemons().get(3).setComProfessor(true);
        personagem1.addPokemon(new Pokemon(5, EEspecie.ELECTRODE, 22));
        assertEquals(false, personagem1.getPokemons().get(0).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(1).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(2).isComProfessor());
        assertEquals(true, personagem1.getPokemons().get(3).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(4).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(5).isComProfessor());
        assertEquals(true, personagem1.getPokemons().get(6).isComProfessor());
        assertEquals(false, personagem1.getPokemons().get(7).isComProfessor());

    }
}
