package com.mimmarcelo.pplaypokemon;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mimmarcelo.classes.Personagem;
import com.mimmarcelo.componentes.MInputText;
import com.mimmarcelo.util.M;
import com.mimmarcelo.util.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CadastroPersonagemActivity extends AppCompatActivity {

    String caminhoDaImagem;
    String enderecoMac;
    Personagem personagem;
    MInputText itvNome;
    MInputText itvMac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_personagem);

        caminhoDaImagem = "";
        //ImageView imgPersonagem = (ImageView)findViewById(R.id.imgPersonagem);
        itvNome = (MInputText)findViewById(R.id.itvNome);
        itvMac = (MInputText)findViewById(R.id.itvMac);

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
            caminhoDaImagem = personagem.getNomeImagem();
            loadImageFromStorage();
        }
        itvMac.setValue(enderecoMac);
    }

    public void getFoto(View v){
        pegaFotoDaCamera();
    }

    public void btnCadastrarAction(View v){
        if(personagem == null){
            personagem = new Personagem();
        }
        personagem.setNome(itvNome.getValue());
        personagem.setMac(itvMac.getValue());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == M.codigoDeRequisicao.CAPTURA_DE_FOTO){
            if(resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap)extras.get("data");

                saveToInternalStorage(imageBitmap);
                loadImageFromStorage();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
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
        loadImageFromStorage();
        itvMac.setValue(enderecoMac);
    }

    @NonNull
    private String saveToInternalStorage(Bitmap bitmapImage){
        ContextWrapper cw = new ContextWrapper(getApplicationContext());
        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
        caminhoDaImagem = directory.getAbsolutePath();

        File mypath=new File(directory,"profile.jpg");

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
    private void loadImageFromStorage()
    {
        if(!caminhoDaImagem.isEmpty()) {
            try {
                File f = new File(caminhoDaImagem, "profile.jpg");
                Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
                ImageView img = (ImageView)findViewById(R.id.imgPersonagem);
                img.setImageBitmap(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
