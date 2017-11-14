package com.mimmarcelo.componentes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.R;
import com.mimmarcelo.util.Util;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public class MListAdapter extends BaseAdapter {
    private Context context;
    ArrayList<MItemList> lista;

    public MListAdapter(Context context, ArrayList<MItemList> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MItemList item = lista.get(i);

        MItemListHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.m_itemlist, null);
            holder = new MItemListHolder();
            holder.setImg((ImageView)view.findViewById(R.id.imgListItem));
            holder.setTxt((TextView)view.findViewById(R.id.txtListItem));
            view.setTag(holder);
        }
        else{
            holder = (MItemListHolder)view.getTag();
        }
        int res = Util.getResourceByString(item.getNomeImagem(), R.mipmap.class);
        holder.getImg().setImageResource(res);
        holder.getTxt().setText(item.getNome());

        return view;
    }
}
