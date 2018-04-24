package com.mimmarcelo.pplaypokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.classes.Personagem;
import com.mimmarcelo.pplaypokemon.util.M;
import com.mimmarcelo.pplaypokemon.util.Util;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Personagem personagem;
//Teste
    CircleImageView btnPersonagem;
    TextView txtNomePersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNomePersonagem = (TextView)findViewById(R.id.txtNomePersonagem);
        btnPersonagem = (CircleImageView)findViewById(R.id.btnPersonagem);

        txtNomePersonagem.setOnClickListener(this);
        btnPersonagem.setOnClickListener(this);

        ImageButton imb = (ImageButton)findViewById(R.id.btnPokemons);
        imb.setOnClickListener(this);

        personagem = Personagem.carregarDados(this);

        if(personagem == null){
            irTelaCadastro(getString(R.string.cadastrar));
        }
        else {
            carregarPersonagem();
        }
    }

    private void irTelaCadastro(String mensagem){
        Intent intent = new Intent(this, CadastroPersonagemActivity.class);

        intent.putExtra(M.Extra.MENSAGEM, mensagem);
        startActivityForResult(intent, M.codigoDeRequisicao.TELA_CADASTRO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == M.codigoDeRequisicao.TELA_CADASTRO){
            if(resultCode == RESULT_OK){
                personagem = Personagem.carregarDados(this);
                carregarPersonagem();
                Util.alerta(this, personagem.getNome()+" cadastrado com sucesso!");
            }
        }
    }

    private void carregarPersonagem(){
        txtNomePersonagem.setText(personagem.getNome());
        btnPersonagem.setImageBitmap(Util.getImagemLocal(personagem.getNomeImagem()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPersonagem:
            case R.id.txtNomePersonagem:
                irTelaCadastro("");
                break;
            case R.id.btnPokemons:
                Intent i = new Intent(this, BolsaPokemonActivity.class);
                startActivity(i);
        }
    }
}
