package com.mimmarcelo.classes;

import java.util.ArrayList;

/**
 * Created by Marcelo Júnior on 13/11/2017.
 */

public enum EEspecie {
    VENUSAUR(3, "Venusaur", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},3,4,3,3,3,0),
    IVYSAUR(2, "Ivysaur", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.VENUSAUR);}},3,3,2,3,1,30),
    BULBASAUR(1, "Bulbasaur", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.IVYSAUR);}},3,3,2,3,1,15),
    CHARIZARD(6, "Charizard", new ArrayList<ETipo>(){{add(ETipo.FOGO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    CHARMELEON(5, "Charmeleon", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{add(EEspecie.CHARIZARD);}},3,3,2,2,0,30),
    CHARMANDER(4, "Charmander", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{add(EEspecie.CHARMELEON);}},2,4,2,2,0,15),
    BLASTOISE(9, "Blastoise", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},3,4,3,3,3,0),
    WARTORTLE(8, "Wartortle", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.BLASTOISE);}},2,3,3,3,1,30),
    SQUIRTLE(7, "Squirtle", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.WARTORTLE);}},2,3,3,3,1,15),
    BUTTERFREE(12, "Butterfree", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},1,3,2,3,-1,0),
    METAPOD(11, "Metapod", new ArrayList<ETipo>(){{add(ETipo.INSETO);}}, new ArrayList<EEspecie>(){{add(EEspecie.BUTTERFREE);}},0,0,7,7,4,10),
    CATERPIE(10, "Caterpie", new ArrayList<ETipo>(){{add(ETipo.INSETO);}}, new ArrayList<EEspecie>(){{add(EEspecie.METAPOD);}},4,2,2,3,1,9),
    BEEDRILL(15, "Beedrill", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},3,2,2,2,-1,0),
    KAKUNA(14, "Kakuna", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.BEEDRILL);}},0,0,7,7,4,11),
    WEEDLE(13, "Weedle", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.KAKUNA);}},4,2,2,3,1,10),
    PIDGEOT(18, "Pidgeot", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,2,0,0),
    PIDGEOTTO(17, "Pidgeotto", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.PIDGEOT);}},2,4,2,2,0,25),
    PIDGEY(16, "Pidgey", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.PIDGEOTTO);}},2,4,2,2,0,12),
    RATICATE(20, "Raticate", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},3,2,3,2,0,0),
    RATTATA(19, "Rattata", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.RATICATE);}},3,2,3,2,0,20),
    FEAROW(22, "Fearow", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,2,0,0),
    SPEAROW(21, "Spearow", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.FEAROW);}},2,4,2,2,0,22),
    ARBOK(24, "Arbok", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},3,3,2,2,0,0),
    EKANS(23, "Ekans", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.ARBOK);}},3,3,2,2,0,22),
    RAICHU(26, "Raichu", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{}},2,3,2,3,0,0),
    PIKACHU(25, "Pikachu", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.RAICHU);}},2,3,2,2,-1,25),
    SANDSLASH(28, "Sandslash", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},4,1,3,2,0,0),
    SANDSHREW(27, "Sandshrew", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.SANDSLASH);}},4,1,3,2,0,20),
    NIDOQUEEN(31, "Nidoqueen", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},2,4,3,2,1,0),
    NIDORINA(30, "Nidorina", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.NIDOQUEEN);}},3,2,3,2,0,30),
    NIDORAN_F(29, "Nidoran-f", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.NIDORINA);}},3,2,3,2,0,12),
    NIDOKING(34, "Nidoking", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},4,2,3,2,1,0),
    NIDORINO(33, "Nidorino", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.NIDOKING);}},3,2,3,2,0,30),
    NIDORAN_M(32, "Nidoran-m", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.NIDORINO);}},3,2,3,2,0,12),
    CLEFABLE(36, "Clefable", new ArrayList<ETipo>(){{add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{}},1,4,1,4,0,0),
    CLEFAIRY(35, "Clefairy", new ArrayList<ETipo>(){{add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{add(EEspecie.CLEFABLE);}},1,4,1,4,0,30),
    NINETALES(38, "Ninetales", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{}},1,4,2,3,0,0),
    VULPIX(37, "Vulpix", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{add(EEspecie.NINETALES);}},2,3,2,3,0,30),
    WIGGLYTUFF(40, "Wigglytuff", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{}},3,3,2,3,1,0),
    JIGGLYPUFF(39, "Jigglypuff", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{add(EEspecie.WIGGLYTUFF);}},2,3,2,3,0,22),
    GOLBAT(42, "Golbat", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},1,4,2,2,-1,30),
    ZUBAT(41, "Zubat", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.GOLBAT);}},1,4,2,2,-1,14),
    VILEPLUME(45, "Vileplume", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    GLOOM(44, "Gloom", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.VILEPLUME);}},1,4,2,3,0,25),
    ODDISH(43, "Oddish", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.GLOOM);}},1,4,2,3,0,12),
    PARASECT(47, "Parasect", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.GRAMA);}}, new ArrayList<EEspecie>(){{}},2,3,3,4,2,0),
    PARAS(46, "Paras", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.GRAMA);}}, new ArrayList<EEspecie>(){{add(EEspecie.PARASECT);}},2,3,3,3,1,15),
    VENOMOTH(49, "Venomoth", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},1,3,2,3,-1,0),
    VENONAT(48, "Venonat", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.VENOMOTH);}},1,3,3,3,0,22),
    DUGTRIO(51, "Dugtrio", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},1,2,2,2,-3,0),
    DIGLETT(50, "Diglett", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.DUGTRIO);}},1,2,2,2,-3,15),
    PERSIAN(53, "Persian", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},2,3,2,2,-1,0),
    MEOWTH(52, "Meowth", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{add(EEspecie.PERSIAN);}},3,2,2,2,-1,20),
    GOLDUCK(55, "Golduck", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},1,4,2,3,0,0),
    PSYDUCK(54, "Psyduck", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.GOLDUCK);}},1,4,3,3,1,20),
    PRIMEAPE(57, "Primeape", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{}},5,1,3,2,1,0),
    MANKEY(56, "Mankey", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.PRIMEAPE);}},4,1,3,2,0,25),
    ARCANINE(59, "Arcanine", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{}},2,3,2,3,0,0),
    GROWLITHE(58, "Growlithe", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{add(EEspecie.ARCANINE);}},2,3,2,3,0,30),
    POLIWRATH(62, "Poliwrath", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{}},4,2,2,2,0,0),
    POLIWHIRL(61, "Poliwhirl", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.POLIWRATH);}},3,3,2,2,0,30),
    POLIWAG(60, "Poliwag", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.POLIWHIRL);}},2,3,2,3,0,12),
    ALAKAZAM(65, "Alakazam", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},1,5,2,3,1,0),
    KADABRA(64, "Kadabra", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.ALAKAZAM);}},1,5,2,3,1,30),
    ABRA(63, "Abra", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.KADABRA);}},1,5,2,4,2,12),
    MACHAMP(68, "Machamp", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{}},5,1,3,2,1,0),
    MACHOKE(67, "Machoke", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.MACHAMP);}},5,1,3,2,1,30),
    MACHOP(66, "Machop", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.MACHOKE);}},4,1,3,2,0,15),
    VICTREEBEL(71, "Victreebel", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},3,5,1,2,1,0),
    WEEPINBELL(70, "Weepinbell", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.VICTREEBEL);}},3,4,1,2,0,20),
    BELLSPROUT(69, "Bellsprout", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.WEEPINBELL);}},3,4,1,1,-1,15),
    TENTACRUEL(73, "Tentacruel", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},1,5,2,3,1,0),
    TENTACOOL(72, "Tentacool", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.TENTACRUEL);}},1,5,1,3,0,20),
    GOLEM(76, "Golem", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},4,1,4,2,1,0),
    GRAVELER(75, "Graveler", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.GOLEM);}},4,1,3,2,0,30),
    GEODUDE(74, "Geodude", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.GRAVELER);}},4,1,3,2,0,20),
    RAPIDASH(78, "Rapidash", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{}},3,3,1,2,-1,0),
    PONYTA(77, "Ponyta", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{add(EEspecie.RAPIDASH);}},3,3,2,2,0,20),
    SLOWBRO(80, "Slowbro", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},2,4,3,3,2,0),
    SLOWPOKE(79, "Slowpoke", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.SLOWBRO);}},1,4,3,3,1,12),
    MAGNETON(82, "Magneton", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);add(ETipo.METAL);}}, new ArrayList<EEspecie>(){{}},1,4,3,2,0,30),
    MAGNEMITE(81, "Magnemite", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);add(ETipo.METAL);}}, new ArrayList<EEspecie>(){{add(EEspecie.MAGNETON);}},1,4,3,2,0,15),
    FARFETCHD(83, "Farfetchd", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,3,2,3,0,0),
    DODRIO(85, "Dodrio", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},3,1,2,2,-2,0),
    DODUO(84, "Doduo", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{add(EEspecie.DODRIO);}},3,2,2,2,-1,15),
    DEWGONG(87, "Dewgong", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.GELO);}}, new ArrayList<EEspecie>(){{}},2,4,2,2,0,0),
    SEEL(86, "Seel", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.DEWGONG);}},2,3,2,3,0,15),
    MUK(89, "Muk", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},2,4,4,3,3,0),
    GRIMER(88, "Grimer", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.MUK);}},2,2,4,3,1,25),
    CLOYSTER(91, "Cloyster", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.GELO);}}, new ArrayList<EEspecie>(){{}},1,5,4,3,3,0),
    SHELLDER(90, "Shellder", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.CLOYSTER);}},3,3,3,3,2,12),
    GENGAR(94, "Gengar", new ArrayList<ETipo>(){{add(ETipo.FANTASMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},1,5,1,2,-1,0),
    HAUNTER(93, "Haunter", new ArrayList<ETipo>(){{add(ETipo.FANTASMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.GENGAR);}},1,4,1,2,-2,30),
    GASTLY(92, "Gastly", new ArrayList<ETipo>(){{add(ETipo.FANTASMA);add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.HAUNTER);}},1,4,1,2,-2,20),
    ONIX(95, "Onix", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},5,1,3,3,2,30),
    HYPNO(97, "Hypno", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},1,4,2,3,0,0),
    DROWZEE(96, "Drowzee", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.HYPNO);}},1,4,2,4,1,20),
    KINGLER(99, "Kingler", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},4,2,3,3,2,0),
    KRABBY(98, "Krabby", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.KINGLER);}},3,2,3,3,1,15),
    ELECTRODE(101, "Electrode", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{}},3,3,2,2,0,0),
    VOLTORB(100, "Voltorb", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.ELECTRODE);}},3,3,2,2,0,20),
    EXEGGUTOR(103, "Exeggutor", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},2,5,3,3,3,0),
    EXEGGCUTE(102, "Exeggcute", new ArrayList<ETipo>(){{add(ETipo.GRAMA);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{add(EEspecie.EXEGGUTOR);}},1,4,3,3,1,20),
    MAROWAK(105, "Marowak", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{}},3,1,3,3,0,0),
    CUBONE(104, "Cubone", new ArrayList<ETipo>(){{add(ETipo.TERRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.MAROWAK);}},3,1,3,3,0,15),
    HITMONLEE(106, "Hitmonlee", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{}},4,1,3,2,0,0),
    HITMONCHAN(107, "Hitmonchan", new ArrayList<ETipo>(){{add(ETipo.LUTADOR);}}, new ArrayList<EEspecie>(){{}},3,1,3,3,0,0),
    LICKITUNG(108, "Lickitung", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},2,3,3,3,1,30),
    WEEZING(110, "Weezing", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{}},1,3,2,4,0,0),
    KOFFING(109, "Koffing", new ArrayList<ETipo>(){{add(ETipo.VENENOSO);}}, new ArrayList<EEspecie>(){{add(EEspecie.WEEZING);}},1,3,3,3,0,20),
    RHYDON(112, "Rhydon", new ArrayList<ETipo>(){{add(ETipo.TERRA);add(ETipo.PEDRA);}}, new ArrayList<EEspecie>(){{}},4,1,3,3,1,30),
    RHYHORN(111, "Rhyhorn", new ArrayList<ETipo>(){{add(ETipo.TERRA);add(ETipo.PEDRA);}}, new ArrayList<EEspecie>(){{add(EEspecie.RHYDON);}},4,2,3,3,2,15),
    CHANSEY(113, "Chansey", new ArrayList<ETipo>(){{add(ETipo.NORMAL);add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{}},1,1,4,5,1,30),
    TANGELA(114, "Tangela", new ArrayList<ETipo>(){{add(ETipo.GRAMA);}}, new ArrayList<EEspecie>(){{}},3,2,2,3,0,30),
    KANGASKHAN(115, "Kangaskhan", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},3,2,4,3,2,0),
    SEADRA(117, "Seadra", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},1,4,2,3,0,30),
    HORSEA(116, "Horsea", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.SEADRA);}},1,4,1,4,0,12),
    SEAKING(119, "Seaking", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},3,2,3,2,0,0),
    GOLDEEN(118, "Goldeen", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.SEAKING);}},3,2,3,2,0,15),
    STARMIE(121, "Starmie", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},2,4,2,2,0,0),
    STARYU(120, "Staryu", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.STARMIE);}},2,3,2,3,0,20),
    MR_MIME(122, "Mr-mime", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);add(ETipo.FADA);}}, new ArrayList<EEspecie>(){{}},1,5,2,3,1,0),
    SCYTHER(123, "Scyther", new ArrayList<ETipo>(){{add(ETipo.INSETO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},4,1,2,2,-1,25),
    JYNX(124, "Jynx", new ArrayList<ETipo>(){{add(ETipo.GELO);add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},1,5,2,5,3,0),
    ELECTABUZZ(125, "Electabuzz", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{}},3,4,2,2,1,30),
    MAGMAR(126, "Magmar", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{}},3,4,2,2,1,30),
    PINSIR(127, "Pinsir", new ArrayList<ETipo>(){{add(ETipo.INSETO);}}, new ArrayList<EEspecie>(){{}},5,1,3,2,1,0),
    TAUROS(128, "Tauros", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},5,1,3,2,1,0),
    GYARADOS(130, "Gyarados", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},3,4,2,2,1,0),
    MAGIKARP(129, "Magikarp", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.GYARADOS);}},1,1,4,6,2,12),
    LAPRAS(131, "Lapras", new ArrayList<ETipo>(){{add(ETipo.AGUA);add(ETipo.GELO);}}, new ArrayList<EEspecie>(){{}},1,4,3,4,2,0),
    DITTO(132, "Ditto", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},3,3,2,2,0,0),
    VAPOREON(134, "Vaporeon", new ArrayList<ETipo>(){{add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    JOLTEON(135, "Jolteon", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);}}, new ArrayList<EEspecie>(){{}},2,3,2,2,-1,0),
    FLAREON(136, "Flareon", new ArrayList<ETipo>(){{add(ETipo.FOGO);}}, new ArrayList<EEspecie>(){{}},2,3,2,3,0,0),
    EEVEE(133, "Eevee", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{add(EEspecie.VAPOREON);add(EEspecie.JOLTEON);add(EEspecie.FLAREON);}},3,2,2,3,0,15),
    PORYGON(137, "Porygon", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},1,5,2,2,0,15),
    OMASTAR(139, "Omastar", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},3,2,4,4,3,0),
    OMANYTE(138, "Omanyte", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.OMASTAR);}},3,2,4,3,2,15),
    KABUTOPS(141, "Kabutops", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{}},4,1,3,3,1,0),
    KABUTO(140, "Kabuto", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.AGUA);}}, new ArrayList<EEspecie>(){{add(EEspecie.KABUTOPS);}},1,3,4,4,2,12),
    AERODACTYL(142, "Aerodactyl", new ArrayList<ETipo>(){{add(ETipo.PEDRA);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},3,4,2,3,2,0),
    SNORLAX(143, "Snorlax", new ArrayList<ETipo>(){{add(ETipo.NORMAL);}}, new ArrayList<EEspecie>(){{}},4,1,4,4,3,0),
    ARTICUNO(144, "Articuno", new ArrayList<ETipo>(){{add(ETipo.GELO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    ZAPDOS(145, "Zapdos", new ArrayList<ETipo>(){{add(ETipo.ELETRICO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    MOLTRES(146, "Moltres", new ArrayList<ETipo>(){{add(ETipo.FOGO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},2,4,2,3,1,0),
    DRAGONITE(149, "Dragonite", new ArrayList<ETipo>(){{add(ETipo.DRAGAO);add(ETipo.VOADOR);}}, new ArrayList<EEspecie>(){{}},3,3,2,3,1,0),
    DRAGONAIR(148, "Dragonair", new ArrayList<ETipo>(){{add(ETipo.DRAGAO);}}, new ArrayList<EEspecie>(){{add(EEspecie.DRAGONITE);}},2,3,2,3,0,30),
    DRATINI(147, "Dratini", new ArrayList<ETipo>(){{add(ETipo.DRAGAO);}}, new ArrayList<EEspecie>(){{add(EEspecie.DRAGONAIR);}},2,3,2,3,0,15),
    MEWTWO(150, "Mewtwo", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},1,5,1,3,0,0),
    MEW(151, "Mew", new ArrayList<ETipo>(){{add(ETipo.PSIQUICO);}}, new ArrayList<EEspecie>(){{}},1,5,1,3,0,0),
    ;

    private int id;
    private int forca;
    private int poder;
    private int resistencia;
    private int protecao;
    private int velocidade;
    private int nivelEvolucao;
    private String nome;
    private ArrayList<ETipo> tipos;
    private ArrayList<EEspecie> evolucoes;

    EEspecie(int id, String nome, ArrayList<ETipo> tipos, ArrayList<EEspecie> evolucoes, int forca, int poder, int resistencia, int protecao, int velocidade, int nivelEvolucao){
        this.id = id;
        this.nome = nome;
        this.tipos = tipos;
        this.evolucoes = evolucoes;
        this.forca = forca;
        this.poder = poder;
        this.resistencia = resistencia;
        this.protecao = protecao;
        this.velocidade = velocidade;
        this.nivelEvolucao = nivelEvolucao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<ETipo> getTipos() {
        return tipos;
    }

    public ArrayList<EEspecie> getEvolucoes() {
        return evolucoes;
    }

    public int getNivelEvolucao() {
        return nivelEvolucao;
    }
}
