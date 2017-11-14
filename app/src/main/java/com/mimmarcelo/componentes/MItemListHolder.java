package com.mimmarcelo.componentes;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public class MItemListHolder {
    private ImageView img;
    private TextView txt;

    public ImageView getImg() {
        return img;
    }

    public TextView getTxt() {
        return txt;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public void setTxt(TextView txt) {
        this.txt = txt;
    }
}
