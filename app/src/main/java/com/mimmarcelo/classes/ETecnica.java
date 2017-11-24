package com.mimmarcelo.classes;

import com.mimmarcelo.util.M;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 23-Nov-17.
 */

public enum ETecnica {
    AGULHA_MISSIL(1, "Agulha Míssil", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    AGULHAS_GEMEAS(2, "Agulhas gêmeas", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    CORTE_DUPLO(3, "Corte duplo", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    CORTE_FURIOSO(4, "Corte furioso", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    INFESTAÇÃO(5, "Infestação", ETipo.INSETO, M.TipoDano.ESPECIAL_EM_AREA, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    MEGA_CHIFRE(6, "Mega chifre", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    MORDIDA_DE_INSETO(7, "Mordida de inseto", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{add(EStatus.ENVENENADO);}}, new ArrayList<Integer>(){{add(M.Alvo.ALVO);}}),
    PICADA_DE_INSETO(8, "Picada de inseto", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{add(EStatus.ENVENENADO);}}, new ArrayList<Integer>(){{add(M.Alvo.ALVO);}}),
    PÓ_DA_RAIVA(9, "Pó da raiva", ETipo.INSETO, M.TipoDano.STATUS_EM_AREA, new ArrayList<EStatus>(){{add(EStatus.PROVOCADO);}}, new ArrayList<Integer>(){{add(M.Alvo.ALVO);}}),
    RAIO_SINALIZADOR(10, "Raio sinalizador", ETipo.INSETO, M.TipoDano.ESPECIAL, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    SANGUESSUGA(11, "Sanguessuga", ETipo.INSETO, M.TipoDano.FISICO, new ArrayList<EStatus>(){{add(EStatus.CURA);}}, new ArrayList<Integer>(){{add(M.Alvo.SI);}}),
    TEIA_DE_ARANHA(12, "Teia de aranha", ETipo.INSETO, M.TipoDano.STATUS, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    TEIA_PEGAJOSA(13, "Teia pegajosa", ETipo.INSETO, M.TipoDano.STATUS, new ArrayList<EStatus>(){{add(EStatus.ENRAIZADO);}}, new ArrayList<Integer>(){{add(M.Alvo.ALVO);}}),
    VENTO_PRATEADO(14, "Vento prateado", ETipo.INSETO, M.TipoDano.ESPECIAL, new ArrayList<EStatus>(){{}}, new ArrayList<Integer>(){{}}),
    ZUMBIDO_DE_INSETO(15, "Zumbido de inseto", ETipo.INSETO, M.TipoDano.ESPECIAL_EM_AREA, new ArrayList<EStatus>(){{add(EStatus.CONFUSAO);}}, new ArrayList<Integer>(){{add(M.Alvo.ALVO);}}),
    ;

    private int id;
    private int tipoDano;
    private String nome;
    private ETipo tipo;
    private ArrayList<EStatus> status;
    private ArrayList<Integer> alvoStatus;

    ETecnica(int id, String nome, ETipo tipo, int tipoDano, ArrayList<EStatus> status, ArrayList<Integer> alvoStatus) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.tipoDano = tipoDano;
        this.status = status;
        this.alvoStatus = alvoStatus;
    }
}
