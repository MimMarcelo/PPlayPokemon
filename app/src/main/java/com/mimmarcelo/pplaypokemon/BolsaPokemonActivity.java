package com.mimmarcelo.pplaypokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.Pokemon;
import com.mimmarcelo.pplaypokemon.classes.adaptador.GridAdapter;
import com.mimmarcelo.pplaypokemon.classes.dao.PokemonDao;

import java.util.ArrayList;
import java.util.List;

public class BolsaPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa_pokemon);

        GridView gdvBolsaPokemon = (GridView)findViewById(R.id.gdvBolsaPokemons);

        List<Pokemon> pokemons = new ArrayList<>();
        pokemons = Pokemon.buscar(this, PokemonDao.ID_PERSONAGEM, new String[]{"1"});
//        pokemons.add(new Pokemon(EEspecie.PERSIAN, 22));
//        pokemons.add(new Pokemon(EEspecie.BULBASAUR, 12));
//        pokemons.add(new Pokemon(EEspecie.BEEDRILL, 18));
//        pokemons.add(new Pokemon(EEspecie.NINETALES, 35));
//        pokemons.add(new Pokemon(EEspecie.NIDOKING, 32));
//        pokemons.add(new Pokemon(EEspecie.PIDGEOT, 28));
//        pokemons.add(new Pokemon(EEspecie.PRIMEAPE, 31));
//        pokemons.add(new Pokemon(EEspecie.VICTREEBEL, 30));
//        pokemons.add(new Pokemon(EEspecie.SEADRA, 20));
//        pokemons.add(new Pokemon(EEspecie.CLEFABLE, 29));
//        pokemons.add(new Pokemon(EEspecie.CHANSEY, 15));
//        pokemons.add(new Pokemon(EEspecie.MACHAMP, 34));

        GridAdapter adaptador = new GridAdapter(this, pokemons);
        gdvBolsaPokemon.setAdapter(adaptador);
    }
}
