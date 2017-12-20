package com.mimmarcelo.pplaypokemon;

import android.content.Intent;
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
import com.mimmarcelo.pplaypokemon.util.M;

import java.util.ArrayList;
import java.util.List;

public class BolsaPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa_pokemon);

        GridView gdvBolsaPokemon = (GridView)findViewById(R.id.gdvBolsaPokemons);

        List<Pokemon> pokemons = new ArrayList<>();
        Intent i = getIntent();
        if(i.hasExtra(M.Extra.ID_PERSONAGEM)) {
            long id = i.getLongExtra(M.Extra.ID_PERSONAGEM, 0);
            pokemons = Pokemon.buscar(this, PokemonDao.ID_PERSONAGEM + "=?", new String[]{String.valueOf(id)}, PokemonDao.COM_PROFESSOR+" asc");
        }
        GridAdapter adaptador = new GridAdapter(this, pokemons);
        gdvBolsaPokemon.setAdapter(adaptador);
    }
}
