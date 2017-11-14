package com.mimmarcelo.componentes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.R;
import com.mimmarcelo.util.Util;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Marcelo Júnior on 14/11/2017.
 */

public class MListExpandableAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<MItemList, ArrayList<MItemList>> dados;
    private ArrayList<MItemList> chaves;

    public MListExpandableAdapter(Context context, Map<MItemList, ArrayList<MItemList>> dados) {
        this.context = context;
        this.dados = dados;
        this.chaves = new ArrayList<>(dados.keySet());
    }

    @Override
    public int getGroupCount() {
        return dados.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return dados.get(chaves.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return chaves.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return dados.get(chaves.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return chaves.get(i).getId();
    }

    @Override
    public long getChildId(int i, int i1) {
        return dados.get(chaves.get(i)).get(i1).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        try {
            MItemList item = chaves.get(i);

            MItemListHolder holder = null;
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.m_itemlist, null);
                holder = new MItemListHolder();
                holder.setImg((ImageView) view.findViewById(R.id.imgListItem));
                holder.setTxt((TextView) view.findViewById(R.id.txtListItem));
                holder.getImg().setBackgroundColor(Color.GRAY);
                holder.getTxt().setBackgroundColor(Color.GRAY);
                view.setTag(holder);
            } else {
                holder = (MItemListHolder) view.getTag();
            }
            int res = Util.getResourceByString(item.getNomeImagem(), R.mipmap.class);
            holder.getImg().setImageResource(res);
            holder.getTxt().setText(item.getNome());

            return view;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        MItemList item = dados.get(chaves.get(i)).get(i1);

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

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
