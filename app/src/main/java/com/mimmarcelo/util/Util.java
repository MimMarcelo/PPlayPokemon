package com.mimmarcelo.util;

import com.mimmarcelo.pplaypokemon.R;

import java.lang.reflect.Field;

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
}
