package com.mimmarcelo.pplaypokemon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mimmarcelo.classes.Personagem;
import com.mimmarcelo.componentes.MInputText;
import com.mimmarcelo.util.M;
import com.mimmarcelo.util.Util;

public class MainActivity extends AppCompatActivity {

    Personagem personagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personagem = Personagem.carregarDados(this);
        if(personagem == null){
            irTelaCadastro("Cadastre-se");
        }
    }

    public void btnCadastroClick(View v){
        irTelaCadastro("");
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
                Util.alerta(this, personagem.getNome()+" cadastrado com sucesso!");
            }
        }
    }
}
