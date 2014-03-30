package br.com.futbid.domain.enumeration;

public enum Country {
    Albania("1"), Algeria("97"), Angola("98"), Argentina("52"), Armenia("3"), Australia("195"), Austria("4"), Barbados(
	    "66"), Belarus("6"), Belgium("7"), Bermuda("68"), Bolivia("53"), BosniaHerzegovina("8"), Brazil("54"), Bulgaria(
	    "9"), BurkinaFaso("101"), Burundi("102"), Cameroon("103"), Canada("70"), CapeVerdeIslands("104"), Chile(
	    "55"), ChinaPR("155"), Colombia("56"), Congo("107"), CostaRica("72"), Croatia("10"), Cyprus("11"), CzechRepublic(
	    "12"), Denmark("13"), DRCongo("110"), Ecuador("57"), Egypt("111"), England("14"), Estonia("208"), Finland(
	    "17"), France("18"), FYRMacedonia("19"), Gabon("115"), Gambia("116"), Georgia("20"), Germany("21"), Ghana(
	    "117"), Greece("22"), Grenada("77"), Guinea("118"), Haiti("80"), Honduras("81"), Hungary("23"), Iceland(
	    "24"), Iran("161"), Israel("26"), Italy("27"), IvoryCoast("108"), Jamaica("82"), Japan("163"), Kenya("120"), KoreaDPR(
	    "166"), KoreaRepublic("167"), Liechtenstein("29"), Lithuania("30"), Mali("126"), Mexico("83"), Montenegro(
	    "15"), Morocco("129"), Netherlands("34"), NewZealand("198"), Nigeria("133"), NorthernIreland("35"), Norway(
	    "36"), Panama("87"), Paraguay("58"), Peru("59"), Philippines("181"), Poland("37"), Portugal("38"), RepublicOfIreland(
	    "25"), Romania("39"), Russia("40"), SaudiArabia("183"), Scotland("42"), Senegal("136"), Serbia("51"), SierraLeone(
	    "138"), Slovakia("43"), Slovenia("44"), SouthAfrica("140"), Spain("45"), Sweden("46"), Switzerland("47"), Togo(
	    "144"), TrinidadAndTobago("93"), Tunisia("145"), Turkey("48"), Ukraine("49"), UnitedStates("95"), Uruguay(
	    "60"), Venezuela("61"), Wales("50"), Zambia("147"), Zimbabwe("148");

    private String value;

    private Country(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }
}
