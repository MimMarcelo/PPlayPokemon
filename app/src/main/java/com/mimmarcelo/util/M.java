package com.mimmarcelo.util;

/**
 * Created by Marcelo Júnior on 23-Nov-17.
 */

public abstract class M {
    public final class TipoDano{
        public static final int FISICO = 1;
        public static final int ESPECIAL = 2;
        public static final int STATUS = 3;
        public static final int FISICO_EM_AREA = 4;
        public static final int ESPECIAL_EM_AREA = 5;
        public static final int STATUS_EM_AREA = 6;
    }

    public final class GrupoStatus{
        public static final int GRUPO1 = 1;
        public static final int GRUPO2 = 2;
    }

    public final class Alvo{
        public static final int ALVO = 1;
        public static final int SI = 2;
    }

    public final class codigoDeRequisicao{
        public static final int CAPTURA_DE_FOTO = 1;
        public static final int TELA_CADASTRO = 2;
    }

    public final class Extra {
        public static final String MENSAGEM = "mensagem";
    }
}
