package com.mimmarcelo.pplaypokemon.classes.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.R;
import com.mimmarcelo.pplaypokemon.classes.Pokemon;
import com.mimmarcelo.pplaypokemon.util.Util;

import java.util.List;

/**
 * Created by Marcelo Júnior on 17-Dec-17.
 */

public class GridAdapter extends ArrayAdapter<Pokemon> {
    public  GridAdapter(Context context, List<Pokemon> pokemons){
        super(context, 0, pokemons);
    }

    public View getView(int posicao, View v, ViewGroup parent){
        Pokemon pokemon = getItem(posicao);

        ListHolder holder;
        if (v == null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.item_list_pokemon, null);
            holder = new ListHolder();
            holder.imgPokemon = (ImageView)v.findViewById(R.id.imgPokemon);
            holder.txtNome = (TextView)v.findViewById(R.id.txtNome);
            holder.txtTipos = (TextView)v.findViewById(R.id.txtTipos);
            holder.txtNivel = (TextView)v.findViewById(R.id.txtNivel);
            holder.txtHpMp = (TextView)v.findViewById(R.id.txtHpMp);

            v.setTag(holder);
        }
        else{
            holder = (ListHolder)v.getTag();
        }
        //Picasso.with(getContext()).load("https://static.zerochan.net/Ninetales.full.1666188.jpg").into(holder.imgPokemon);
        holder.imgPokemon.setImageResource(Util.getResourceByString(pokemon.getNomeImagem(), R.mipmap.class));
        holder.txtNome.setText(pokemon.getNome());
        holder.txtNivel.setText(String.valueOf(pokemon.getNivel()));
        holder.txtTipos.setText("FALTA");
        holder.txtHpMp.setText("FALTA");
        return v;
    }

}
