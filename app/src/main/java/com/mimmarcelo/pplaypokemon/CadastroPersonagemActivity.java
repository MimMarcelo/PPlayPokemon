package com.mimmarcelo.pplaypokemon;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mimmarcelo.pplaypokemon.classes.EStatus;
import com.mimmarcelo.pplaypokemon.classes.Personagem;
import com.mimmarcelo.pplaypokemon.componentes.MInputText;
import com.mimmarcelo.pplaypokemon.util.M;
import com.mimmarcelo.pplaypokemon.util.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class CadastroPersonagemActivity extends AppCompatActivity implements View.OnClickListener{

    String caminhoDaImagem;
    String enderecoMac;
    Personagem personagem;
    MInputText itvNome;
    MInputText itvMac;
    CircleImageView imgPersonagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_personagem);

        caminhoDaImagem = "";

        itvNome = (MInputText)findViewById(R.id.itvNome);
        itvMac = (MInputText)findViewById(R.id.itvMac);
        imgPersonagem = (CircleImageView)findViewById(R.id.imgPersonagem);

        Button btn = (Button)findViewById(R.id.btnCamera);
        btn.setOnClickListener(this);

        btn = (Button)findViewById(R.id.btnCadastrar);
        btn.setOnClickListener(this);

        btn = (Button)findViewById(R.id.btnDaGaleria);
        btn.setOnClickListener(this);

        String msg = getIntent().getStringExtra(M.Extra.MENSAGEM);
        getIntent().putExtra(M.Extra.MENSAGEM, "");

        if(!msg.isEmpty()){
            Util.alerta(this, msg);
            enderecoMac = android.provider.Settings.Secure.getString(this.getContentResolver(), "bluetooth_address");
        }

        personagem = Personagem.carregarDados(this);
        if(personagem != null){
            itvNome.setValue(personagem.getNome());
            enderecoMac = personagem.getMac();
            imgPersonagem.setImageBitmap(Util.getImagemLocal(personagem.getNomeImagem()));
        }
        itvMac.setValue(enderecoMac);
    }

    public void cadastrar(){
        String nome = itvNome.getValue();
        String mac = itvMac.getValue();

        if(personagem == null){
            personagem = new Personagem(nome, mac, EStatus.INSERIR);
        }
        else {
            personagem.setNome(itvNome.getValue());
            personagem.setMac(itvMac.getValue());
            personagem.setStatus(EStatus.ATUALIZAR);
        }

        personagem.setNomeImagem(caminhoDaImagem);
        personagem.salvar(this);

        setResult(RESULT_OK);
        finish();
    }

    private void pegaFotoDaCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //VERIFICA SE O DISPOSITIVO POSSUI CÂMERA
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, M.codigoDeRequisicao.CAPTURA_DE_FOTO);
        }
    }

    private void pegaFotoDaGaleria(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent,"Selecionar imagem"), M.codigoDeRequisicao.SELECIONAR_FOTO);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case M.codigoDeRequisicao.CAPTURA_DE_FOTO:
                if(resultCode == RESULT_OK) {
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap)extras.get("data");

                    caminhoDaImagem = salvaImagemLocal(imageBitmap);
                    imgPersonagem.setImageBitmap(Util.getImagemLocal(caminhoDaImagem));
                }
                break;
            case M.codigoDeRequisicao.SELECIONAR_FOTO:
                if(resultCode == RESULT_OK){
                    Uri uri = data.getData();
                    Bitmap bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    caminhoDaImagem = salvaImagemLocal(bitmap);
                    imgPersonagem.setImageBitmap(Util.getImagemLocal(caminhoDaImagem));
                }
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("caminhoDaImagem", caminhoDaImagem);
        savedInstanceState.putString("enderecoMac", enderecoMac);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore UI state from the savedInstanceState.
        // This bundle has also been passed to onCreate.
        caminhoDaImagem = savedInstanceState.getString("caminhoDaImagem");
        enderecoMac = savedInstanceState.getString("enderecoMac");
        itvMac.setValue(enderecoMac);
        Util.getImagemLocal(caminhoDaImagem);
    }

    @NonNull
    private String salvaImagemLocal(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/img
        File directory = cw.getDir("img", Context.MODE_PRIVATE);

        File mypath = new File(directory,"perfil.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return directory.getAbsolutePath();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCamera:
                pegaFotoDaCamera();
                break;
            case R.id.btnCadastrar:
                cadastrar();
                break;
            case R.id.btnDaGaleria:
                pegaFotoDaGaleria();
                break;
        }
    }
}
