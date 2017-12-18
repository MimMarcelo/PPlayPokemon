package com.mimmarcelo.pplaypokemon.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.mimmarcelo.pplaypokemon.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public abstract class Util {
    /**
	 * RECUPERA IMAGEM DO "Resource" ATRAVÉS DE UMA STRING
	 * @param resName NOME DA IMAGEM
	 * @param c REFERÊNCIA DA CLASSE DE "Resource" QUE INDICA O TIPO DE IMAGEM
	 * @return A IMAGEM ENCONTRADA
	 */
	public static int getResourceByString(String resName, Class<?> c) {

	    try {
	        Field idField = c.getDeclaredField(resName);
	        return idField.getInt(idField);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	public static void alerta(Context context, String mensagem) {
		Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
	}

	public static Bitmap getImagemLocal(String caminhoDaImagem){
		if(!caminhoDaImagem.isEmpty()) {
			try {
				File f = new File(caminhoDaImagem, "perfil.jpg");
				return BitmapFactory.decodeStream(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
