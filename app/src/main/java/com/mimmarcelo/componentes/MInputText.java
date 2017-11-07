package com.mimmarcelo.componentes;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mimmarcelo.pplaypokmon.R;

/**
 * Created by Marcelo Júnior on 31/10/2017.
 */

public class MInputText extends LinearLayout {
    private TextView txtInputText;
    private EditText edtInputText;

    private String _placeholder;

    private OnFocusChangeListener edtChangeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View view, boolean b) {
            EditText e = (EditText)view;
            if(b) {
                e.setHint("");
            }
            else{
                if(e.getText().toString().isEmpty()){
                    e.setHint(_placeholder);
                }
            }
        }
    };

    public MInputText(Context context) {
        super(context);
        init(context, null, 0);
    }

    public MInputText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public MInputText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View v = inflate(context, R.layout.m_inputtext, null);
        txtInputText = (TextView)v.findViewById(R.id.txtInputText);
        edtInputText = (EditText)v.findViewById(R.id.edtInputText);
        final TypedArray a = getContext().obtainStyledAttributes(
                attrs, R.styleable.MInputText, defStyleAttr, 0);

        txtInputText.setText(a.getString(R.styleable.MInputText_label));
        edtInputText.setText(a.getString(R.styleable.MInputText_valor));
        _placeholder = a.getString(R.styleable.MInputText_placeholder);
        edtInputText.setHint(_placeholder);

        edtInputText.setOnFocusChangeListener(edtChangeListener);

        this.addView(v);
    }

    public void setValue(String textoInput){
        edtInputText.setText(textoInput);
    }

    public void setText(String textoLabel){
        txtInputText.setText(textoLabel);
    }

    public String getValue(){
        return edtInputText.getText().toString().trim();
    }

    public String getText(){
        return txtInputText.getText().toString().trim();
    }
}
