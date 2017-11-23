package com.mimmarcelo.pplaypokemon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;

import com.mimmarcelo.classes.ETipo;
import com.mimmarcelo.componentes.MItemList;
import com.mimmarcelo.componentes.MListAdapter;
import com.mimmarcelo.componentes.MListExpandableAdapter;
import com.mimmarcelo.componentes.MInputText;

import java.util.ArrayList;
import java.util.Collections;
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


        ETipo.values();
        ArrayList<MItemList> pokemons1 = new ArrayList<>();
        Collections.addAll(pokemons1, ETipo.values());
//        pokemons1.add(new Pokemon(EEspecie.BULBASAUR));
//        pokemons1.add(new Pokemon(EEspecie.IVYSAUR));
//        pokemons1.add(new Pokemon(EEspecie.VENOSAUR));

        MListAdapter adapter = new MListAdapter(this, pokemons1);
        lstPokemons.setAdapter(adapter);
        spnPokemons.setAdapter(adapter);

        ArrayList<MItemList> pokemons2 = new ArrayList<>();
//        pokemons2.add(new Pokemon(EEspecie.CHARMANDER));
//        pokemons2.add(new Pokemon(EEspecie.CHARMILION));
//        pokemons2.add(new Pokemon(EEspecie.CHARIZARD));

        //Map<MItemList, ArrayList<MItemList>> dados = new HashMap<>();
//        dados.put(new Pokemon(EEspecie.VENOSAUR), pokemons1);
//        dados.put(new Pokemon(EEspecie.CHARIZARD), pokemons2);
        //elsPokemons.setAdapter(new MListExpandableAdapter(this, dados));
    }
}
