package br.com.futbid.domain.enumeration;

public enum League {

    Abundesliga("80", "A. Bundesliga"), AirtricityLeague("65", "Airtricity League"), ALeague("351", "A - League"), Allsvenskan(
	    "56", "Allsvenskan"), BarclaysPremierLeague("13", "Barclays Premier League"), Bundesliga("19", "Bundesliga"), Bundesliga2(
	    "20", "Bundesliga 2"), Eredivisie("10", "Eredivisie"), HellasLiga("63", "Hellas Liga"), KLeague("83",
	    "K-League"), LigaAdelante("54", "Liga Adelante"), LigaBbva("53", "Liga BBVA"), LigadoBrasil("7",
	    "Liga do Brasil"), LigaMx("341", "MX Liga"), LigaPortuguesa("308", "Portuguesa Liga"), Ligue1("16",
	    "Ligue 1"), Ligue2("17", "Ligue 2"), Mls("39", "MLS"), NpowerChampionship("14", "npower Championship"), NpowerLeague1(
	    "60", "npower League 1"), NpowerLeague2("61", "npower League 2"), PolskaLiga("66", "Polska Liga"), PrimeraLiga(
	    "353", "Primera Liga"), ProLeague("4", "Pro League"), RaiffeisenSl("189", "Raiffeisen SL"), RussianLeague(
	    "67", "Russian League"), SaudiProLeague("350", "Saudi Pro League"), SerieA("31", "Serie A"), SerieB("32",
	    "Serie B"), SouthAfricanFl("347", "South African FL"), Spl("371", "Scotland League"), SCl("50",
	    "Scottish Prem"), Superliga("1", "Superliga"), Tippeligaen("41", "Tippeligaen"), TurkLig("68", "TürkLig"), Ukraine(
	    "332", "Ukrayina Liha");

    private String value;
    private String display;

    private League(String value, String display) {
	this.value = value;
	this.display = display;
    }

    public String getValue() {
	return this.value;
    }

    public String toString() {
	return this.display;
    }

}
