package com.mimmarcelo.pplaypokemon.classes;

/**
 * Created by Marcelo Júnior on 23-Nov-17.
 */

public enum EStatusPokemon {

    NENHUM(0, "Normal" , "O pokémon não está sob nenhum status"),
    QUEIMADO(1, "Queimado", "Queimaduras causam dano ao pokémon"),
    CONGELADO(2, "Congelado", "O frio debilita a locomoção do pokémon"),
    PARALISADO(3, "Paralisado", "As contrações condicionam a movimentação do pokémon"),
    ENVENENADO(4, "Envenenado", "O veneno absorvido causa dano ao pokémon"),
    DORMINDO(5, "Dormindo", "O pokémon é incapaz de realizar movimentos até acordar"),
    ENRAIZADO(6, "Enraizado", "Os movimentos do pokémon estão limitados"),
    CONFUSAO(7, "Confusão", "Pode ser que o pokémon se machuque realizando alguma ação"),
    AMALDICOADO(8, "Amaldiçoado", "O pokémon é obrigado a repetir seu último movimento"),
    ASSUSTADO(9, "Assustado", "O pokémon é incapaz de atacar"),
    IDENTIFICADO(10, "Identificado", "O pokémon é incapaz de se esconder ou fugir"),
    APAIXONADO(11, "Apaixonado", "O pokémon só pode atacar 50% das vezes"),
    PROVOCADO(12, "Provocado", "O pokémon só pode usar golpes físicos"),
    ATORMENTADO(13, "Atormentado", "O pokémon atormentado não pode usar o mesmo movimento duas vezes seguidas"),
    CURA(14, "Cura", "O pokémon restaura HP"),
    ENDURECIDO(15, "Endurecido", "O pokémon sempre vai sobreviver ao próximo ataque com pelo menos 1 de vida"),
    ABATIDO(16, "Abatido", "O pokémon está for a de combate"),
    ;

    private int id;
    private String nome;
    private String descricao;

    EStatusPokemon(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
}
