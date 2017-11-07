package com.mimmarcelo.pplaypokmon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mimmarcelo.componentes.MInputText;

public class MainActivity extends AppCompatActivity {
    MInputText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = (MInputText)findViewById(R.id.itxNome);
    }
}
