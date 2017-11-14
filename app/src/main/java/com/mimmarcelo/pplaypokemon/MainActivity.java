package com.mimmarcelo.pplaypokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;

import com.mimmarcelo.classes.Especie;
import com.mimmarcelo.componentes.MItemList;
import com.mimmarcelo.componentes.MListAdapter;
import com.mimmarcelo.classes.Pokemon;
import com.mimmarcelo.componentes.MListExpandableAdapter;
import com.mimmarcelo.componentes.MInputText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    MInputText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (MInputText)findViewById(R.id.itxNome);
        ListView lstPokemons = (ListView)findViewById(R.id.lstPokemons);
        Spinner spnPokemons = (Spinner)findViewById(R.id.spnPokemons);
        ExpandableListView elsPokemons = (ExpandableListView)findViewById(R.id.elsPokemons);

        ArrayList<MItemList> pokemons1 = new ArrayList<>();
        pokemons1.add(new Pokemon(Especie.BULBASAUR));
        pokemons1.add(new Pokemon(Especie.IVYSAUR));
        pokemons1.add(new Pokemon(Especie.VENOSAUR));

        MListAdapter adapter = new MListAdapter(this, pokemons1);
        lstPokemons.setAdapter(adapter);
        spnPokemons.setAdapter(adapter);

        ArrayList<MItemList> pokemons2 = new ArrayList<>();
        pokemons2.add(new Pokemon(Especie.CHARMANDER));
        pokemons2.add(new Pokemon(Especie.CHARMILION));
        pokemons2.add(new Pokemon(Especie.CHARIZARD));

        Map<MItemList, ArrayList<MItemList>> dados = new HashMap<>();
        dados.put(new Pokemon(Especie.VENOSAUR), pokemons1);
        dados.put(new Pokemon(Especie.CHARIZARD), pokemons2);
        elsPokemons.setAdapter(new MListExpandableAdapter(this, dados));
    }
}
