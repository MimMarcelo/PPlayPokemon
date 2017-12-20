package com.mimmarcelo.pplaypokemon;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mimmarcelo.pplaypokemon.classes.EEspecie;
import com.mimmarcelo.pplaypokemon.classes.Personagem;
import com.mimmarcelo.pplaypokemon.classes.Pokemon;
import com.mimmarcelo.pplaypokemon.util.M;
import com.mimmarcelo.pplaypokemon.util.Util;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Personagem personagem;

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
//            List<Pokemon> pokemons = new ArrayList<>();
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.CHARMELEON, 22));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.BEEDRILL, 18));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.PRIMEAPE, 23));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.BELLSPROUT, 21));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.TENTACRUEL, 22));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.DODRIO, 19));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.NIDORINO, 17));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.VULPIX, 12));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.MUK, 19));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.HAUNTER, 17));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.HITMONLEE, 17));
//            pokemons.add(new Pokemon(personagem.getId(), EEspecie.JOLTEON, 20));
//
//            personagem.setPokemons(pokemons);
//            for(Pokemon p: personagem.getPokemons())
//                p.salvar(this);
//            Pokemon p = new Pokemon(personagem.getId(), EEspecie.ARBOK, 24);
//            p.setNome("Jararaca");
//
//            personagem.addPokemon(p);
//            p.salvar(this);
            carregarPersonagem();
        }
    }

    private void irTelaCadastro(String mensagem){
        ActivityOptionsCompat opcoes = ActivityOptionsCompat.makeSceneTransitionAnimation(this);

        Intent intent = new Intent(this, CadastroPersonagemActivity.class);

        intent.putExtra(M.Extra.MENSAGEM, mensagem);
        ActivityCompat.startActivityForResult(this, intent, M.codigoDeRequisicao.TELA_CADASTRO, opcoes.toBundle());
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
                ActivityOptionsCompat opcoes = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                Intent i = new Intent(this, BolsaPokemonActivity.class);
                //startActivity(i);
                i.putExtra(M.Extra.ID_PERSONAGEM, this.personagem.getId());
                ActivityCompat.startActivity(this, i, opcoes.toBundle());
        }
    }
}
