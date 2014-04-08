package br.com.futbid.domain.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Team {
    FcKaiserslautern("29"), FcKoln("31"), FcNurnberg("171"), FcShakhtar("101059"), FcUnionBerlin("1831"), FsvMainz05(
	    "169"), Hoffenheim("10029"), AVladikavkaz("110230"), AaB("820"), AalesundsFk("1755"), Aberdeen("77"), AcAjaccio(
	    "614"), AcArlesAvignon("111989"), AcHorsens("1446"), AcademicaCoimbra("1901"), AccringtonStanley("110313"), AdAlcorcon(
	    "100831"), AdelaideUnited("111393"), AdmiraWackerModling("111821"), AdoDenHaag("650"), AekAthens("278"), AfcWimbledon(
	    "112259"), AgfAarhus("271"), Aik("433"), AjAuxerre("57"), Ajax("245"), AlWehdah("112408"), AlAhli("112387"), AldershotTown(
	    "382"), AlemanniaAachen("1826"), AlEttifaq("112096"), AlFaisaly("112389"), AlFateh("112390"), AlHilal("605"), AlIttihad(
	    "607"), AlNassr("112139"), AlRaed("112392"), AlShabab("111674"), Alshoulla("112407"), AlTaawoun("112393"), America(
	    "1879"), AmericaMineiro("112001"), AmiensSc("1816"), AmkarPerm("110234"), Anderlecht("229"), AngersSco(
	    "1530"), AnzhiMakhachkala("100766"), Arsenal("1"), AsMonaco("69"), AsNancy("1823"), AsSaintEtienne("1819"), Ascoli(
	    "1846"), AssociaoAcadmicadeCoimbra("1901"), AstonVilla("2"), Atalanta("39"), AthleticClubdeBilbao("448"), Atlante(
	    "101116"), Atlas("101114"), AtleticodeMadrid("240"), AtleticoGoianiense("112119"), AtleticoMineiro("1035"), AtleticoParanaense(
	    "1039"), AtvidabergsFf("111835"), AustriaWien("256"), Avai("111976"), Az("1906"), Bahia("1598"), Bari(
	    "1848"), Barnet("135"), Barnsley("1932"), Bayer04Leverkusen("32"), BayernMunchen("21"), BeiraMar("1897"), Benfica(
	    "234"), BirminghamCity("88"), BkHacken("711"), BlackburnRovers("3"), Blackpool("1926"), BohemianFc("305"), Bologna(
	    "189"), BoltonWanderers("4"), BorussiaDortmund("22"), BorussiaMgladbach("23"), Botafogo("517"), Bournemouth(
	    "1943"), BradfordCity("1804"), Braga("1896"), BrayWanderers("838"), Brentford("1925"), Brescia("190"), BrightonHoveAlbion(
	    "1808"), BrisbaneRoar("111395"), BristolCity("1919"), BristolRovers("1962"), Brondby("269"), BscYoungBoys(
	    "900"), Burnley("1796"), BurtonAlbion("15015"), Bury("1945"), BusanIPark("1476"), CaOsasuna("479"), Cagliari(
	    "1842"), CardiffCity("1961"), CarlisleUnited("1480"), Catania("110364"), CdAlcoyano("110833"), CdFeirense(
	    "10019"), CdGuadalajaraSpain("111827"), CdLugo("110831"), CdMirandes("110069"), CdNacional("1891"), CdNacionaldeMadeira(
	    "1891"), CdNumancia("477"), CeSabadell("15021"), Ceara("111059"), Celtic("78"), CentralCoastMariners(
	    "111396"), CercleBrugge("1750"), Cesena("110915"), ChamNiortais("1813"), Charleroi("670"), CharltonAthletic(
	    "89"), Chelsea("5"), CheltenhamTown("1936"), Chesterfield("1924"), ChicagoFire("693"), ChievoVerona("192"), ChivasUsa(
	    "111070"), ChunnamDragons("1475"), Cittadella("111993"), ClermontFoot("1815"), ClubBrugge("231"), ClubLeon(
	    "110781"), ColchesterUnited("1935"), ColoradoRapids("694"), ColumbusCrew("687"), CordobaCf("1867"), Corinthians(
	    "1041"), Coritiba("111044"), CorkCity("422"), CoventryCity("1800"), CracoviaKrakow("110747"), CrawleyTown(
	    "110890"), CreweAlexandra("121"), Crotone("110734"), CruzAzul("1878"), Cruzeiro("568"), CrystalPalace(
	    "1799"), CsMaritimo("1893"), CsSedan("613"), CskaMoskva("315"), DcUnited("688"), DaeguFc("2056"), DaejeonCitizen(
	    "980"), DagenhamRedbridge("373"), DeGraafschap("635"), DerbyCounty("91"), DerryCity("445"), DijonFootball(
	    "110569"), DinamoMoskva("312"), DjurgardensIf("710"), DoncasterRovers("142"), DroghedaUnited("1572"), DundalkFc(
	    "837"), DundeeFc("180"), DundeeUnited("181"), DynamoDresden("503"), EintrachtBraunschweig("110500"), EintrachtFrankfurt(
	    "1824"), ElcheCf("468"), Empoli("1746"), EnAvantGuingamp("62"), EnergieCottbus("162"), ErzgebirgeAue("506"), EsTroyes(
	    "294"), Esbjerg("1445"), Estoril("10020"), EstorilPraia("10020"), EstudiantesTecos("110780"), Everton("7"), EvianThononGaillardFc(
	    "111271"), Excelsior("1971"), ExeterCity("143"), FcPaosdeFerreira("182"), FcAugsburg("100409"), FcBarcelona(
	    "241"), FcBarcelonaB("110704"), FcBasel("896"), FcCartagena("100851"), FcCopenhagen("819"), FcDallas("695"), FcGroningen(
	    "1915"), FcIngolstadt04("111239"), FcIstres("1820"), FcKrasnodar("112218"), FcLausanneSports("1862"), FcLorient(
	    "217"), FcLuzern("897"), FcMetz("68"), FcMidtjylland("1516"), FcNantes("71"), FcNordsjlland("1788"), FcPorto(
	    "236"), FcRostov("110231"), FcSchalke04("34"), FcSeoul("982"), FcSion("110770"), FcSochaux("226"), FcStGallen(
	    "898"), FcStPauli("110329"), FcThun("1715"), FcTwente("1908"), FcUtrecht("1903"), FcVolgaNizhniyNovgorod(
	    "112217"), FcZurich("894"), Feyenoord("246"), Figueirense("111045"), Fiorentina("110374"), FkHaugesund(
	    "1463"), Flamengo("1043"), FleetwoodTown("112260"), Fluminense("567"), FortunaDsseldorf("110636"), FredrikstadFk(
	    "2041"), FsvFrankfurt("110596"), Fulham("144"), Gais("111594"), GalatasaraySk("325"), GalwayUnited("1571"), GangwonFc(
	    "112115"), GazelecAjaccio("110316"), GefleIf("111277"), Genk("673"), Genoa("110556"), Gent("674"), GetafeCf(
	    "1860"), GifSundsvall("1596"), GilVicente("1888"), GilVicenteFc("1888"), Gillingham("1802"), GironaFc(
	    "110062"), GirondinsBordeaux("59"), GksBelchatow("110744"), Gliwice("111086"), GoldCoastUnited("112078"), GornikZabrze(
	    "420"), GranadaCf("110832"), GrasshopperClub("322"), Gremio("1629"), Grosseto("111491"), Guadalajara("1880"), Guimaraes(
	    "1887"), GwangJuFc("112258"), GyeongNamFc("111588"), Hajer("112394"), HalmstadsBk("321"), HamburgerSv("28"), Hannover96(
	    "485"), HansaRostock("27"), HartlepoolUnited("1941"), HeartofMidlothian("80"), HelsingborgsIf("432"), HeraclesAlmelo(
	    "100634"), HerculesCf("100879"), HerefordUnited("147"), HerthaBsc("166"), Hibernian("81"), HonefossBk(
	    "1841"), HoustonDynamo("698"), HuddersfieldTown("1939"), HullCity("1952"), IfElfsborg("700"), IfkGoteborg(
	    "319"), IfkNorrkoping("702"), IkStart("1524"), IncheonUnitedFc("110765"), Inter("44"), Internacional("1048"), InvernessCaledonianThistle(
	    "620"), IpswichTown("94"), JagielloniaBialystok("110745"), JaguaresdeChiapas("110151"), JejuUnitedFc("1478"), JeonbukHyundaiMotors(
	    "1477"), JuveStabia("112124"), Juventus("45"), KaizerChiefs("110929"), KalmarFf("1439"), KapfenbergerSv(
	    "15011"), KarlsruherSc("1832"), Kilmarnock("82"), KoronaKielce("111083"), Kortrijk("100081"), KrylyaSovetovSamara(
	    "100764"), KubanKrasnodar("110089"), LaSpezia("110741"), Lanciano("112020"), Lazio("46"), LbChateauroux(
	    "212"), LeHavreAc("1738"), LeMansFc("1739"), Lecce("347"), LechPoznan("873"), LechiaGdansk("111091"), LeedsUnited(
	    "8"), LegiaWarszawa("1871"), LeicesterCity("95"), LevanteUd("1853"), LeytonOrient("1958"), Lierse("239"), LillestromSk(
	    "299"), Liverpool("9"), Livorno("1844"), LksLodz("111085"), Lokeren("2007"), LokomotivMoskva("100765"), LosAngelesGalaxy(
	    "697"), LoscLille("65"), MacclesfieldTown("1959"), MalagaCf("573"), MalmoFf("320"), ManchesterCity("10"), ManchesterUnited(
	    "11"), Maritimo("1893"), Mechelen("110724"), MelbourneHeart("112224"), MelbourneVictory("111397"), Middlesbrough(
	    "12"), Milan("47"), Millwall("97"), MiltonKeynesDons("1798"), MjallbyAif("112072"), Modena("1744"), MoldeFk(
	    "417"), MonarcasMorelia("1028"), Monterrey("1032"), MontpellierSc("70"), MontrealImpact("111139"), MordovSaransk(
	    "110106"), Morecambe("357"), MoreiraConegos("1900"), Moreirense("1900"), Motherwell("83"), MsvDuisburg(
	    "1825"), NRecife("111050"), NacBreda("1904"), Najran("112395"), Napoli("48"), NasticdeTarragona("15019"), Nec(
	    "1910"), NeuchatelXamax("435"), NewEnglandRevolution("691"), NewYorkRedBulls("689"), NewcastleUnited("13"), NewcastleUnitedJets(
	    "111398"), NimesOlympique("224"), NorthamptonTown("1930"), NorwichCity("1792"), NottinghamForest("14"), NottsCounty(
	    "1937"), Novara("112225"), OddGrenland("1456"), OdenseBk("272"), OgcNice("72"), OldhamAthletic("1920"), Olhanense(
	    "111540"), Olympiakos("280"), OlympiquedeMarseille("219"), OlympiqueLyonnais("66"), OrebroSk("705"), OrlandoPirates(
	    "110930"), OudHeverleeLeuven("100087"), OxfordUnited("1951"), PCampinas("111043"), Pachuca("110147"), PacosdeFerreira(
	    "1892"), Padova("110912"), Palermo("1843"), Palmeiras("383"), Panathinaikos("1884"), Paok("393"), ParisSaintGermain(
	    "73"), Parma("50"), PecZwolle("1914"), PerthGlory("111399"), Pescara("200"), PeterboroughUnited("1938"), PhiladelphiaUnion(
	    "112134"), PlymouthArgyle("1929"), PodbeskidzieBielskoBiala("111087"), PohangSteelers("1474"), PoloniaWarszawa(
	    "1570"), PortVale("1928"), PortlandTimbers("111140"), Portsmouth("1790"), Portuguesa("111292"), PrestonNorthEnd(
	    "1801"), Psv("247"), Puebla("110152"), QueensParkRangers("15"), Queretaro("110150"), RacingClubdeLens("64"), RacingdeSantander(
	    "456"), RandersFc("1786"), RapidWien("254"), RayoVallecano("480"), RcCeltadeVigo("450"), RcDeportivo("242"), RcRecreativo(
	    "571"), RcdEspanyol("452"), RcdMallorca("453"), Reading("1793"), RealBetisBalompie("449"), RealMadrid("243"), RealMurciaCf(
	    "1855"), RealSaltLake("111065"), RealSociedad("457"), RealSportingdeGijon("459"), RealValladolid("462"), RealZaragoza(
	    "244"), RedBullSalzburg("191"), Reggina("203"), RioAve("744"), RioAveFc("744"), RkcWaalwijk("1905"), RmCastilla(
	    "110710"), Rochdale("1955"), RodaJcKerkrade("1902"), Roma("52"), RosenborgBk("298"), RossCounty("631"), RotherhamUnited(
	    "1797"), RubinKazan("110227"), RuchChorzow("874"), SRecife("111057"), Sampdoria("1837"), SanJoseEarthquakes(
	    "111928"), SanLuis("110149"), SandnesUlf("112374"), SangjuSangmuPhoenixFc("2055"), Santos("1053"), SantosLaguna(
	    "110144"), SaoPaulo("598"), Sassuolo("111974"), ScBastia("58"), ScBeiraMar("1897"), ScBraga("1896"), ScFreiburg(
	    "25"), ScHeerenveen("1913"), ScOlhanense("111540"), ScPaderborn("10030"), ScWienerNeustadt("111373"), ScunthorpeUnited(
	    "1949"), SdHuesca("110839"), SdPonferradina("2023"), SeattleSounders("111144"), SeongnamIlhwaChunma("981"), ServetteFc(
	    "324"), SevillaFc("481"), ShamrockRovers("306"), SheffieldUnited("1794"), SheffieldWednesday("1807"), Shelbourne(
	    "834"), ShrewsburyTown("127"), Siena("1838"), SilkeborgIf("270"), SkBrann("919"), SlBenfica("234"), SlaskWroclaw(
	    "111092"), SligoRovers("563"), SmCaen("210"), Snderjyske("1447"), SogndalFotball("1465"), Southampton("17"), SouthendUnited(
	    "1954"), SpartakMoskva("100767"), SpartakNalchik("110103"), SportingCp("237"), SportingKc("696"), SportingLisbon(
	    "237"), SpvggGreutherFrth("165"), SsvJahn("543"), StJohnstone("100804"), StMirren("100805"), StPatricksAthletic(
	    "423"), StabaekFotball("917"), StadeBrestois("378"), StadedeReims("379"), StadeLavallois("1814"), StadeRennais(
	    "74"), Standard("232"), Stevenage("361"), StokeCity("1806"), StromsgodsetToppfotball("922"), SturmGraz(
	    "209"), Sunderland("106"), SuwonSamsungBluewings("983"), SvMattersburg("1785"), SvRied("780"), SvSandhausen(
	    "110178"), SwanseaCity("1960"), SwindonTown("1934"), SydneyFc("111400"), SyrianskaFc("112267"), Szczecin(
	    "110746"), TerekGrozny("110109"), Terni("570"), TigresUanl("1970"), Toluca("1882"), TomTomsk("110233"), Torino(
	    "54"), TorontoFc("111651"), TorquayUnited("1946"), TottenhamHotspur("18"), ToulouseFc("1809"), ToursFc(
	    "110326"), TranmereRovers("15048"), TromsoIl("418"), Tsv1860Munchen("33"), Ucd("111132"), Unam("1881"), UdAlmeria(
	    "1861"), UdLasPalmas("472"), Udinese("55"), UlsanHyundaiFc("1473"), UniaoDesportivadeLeiria("1895"), UsBoulogne(
	    "111376"), ValenciaCf("461"), ValenciennesFc("110456"), ValerengaFotball("920"), VancouverWhitecaps(
	    "101112"), Varese("112237"), VascodaGama("569"), Vercelli("112398"), Verona("206"), VfBStuttgart("36"), VfLBochum(
	    "160"), VfLWolfsburg("175"), VfRAalen("550"), Vicenza("1847"), VikingFk("300"), VillarrealB("110902"), VillarrealCf(
	    "483"), Vitesse("1909"), VitoriaGuimaraes("1887"), VitoriaSetubal("665"), VvvVenlo("100651"), WaaslandBeveren(
	    "110913"), WackerInnsbruck("2045"), Walsall("1803"), WanderersFc("112427"), Waregem("15005"), Watford(
	    "1795"), WellingtonPhoenix("111766"), WerderBremen("38"), WestBromwichAlbion("109"), WestHamUnited("19"), WidzewLodz(
	    "301"), WiganAthletic("1917"), WillemIi("1907"), WislaKrakow("1873"), WolfsbergerAc("111822"), WolverhamptonWanderers(
	    "110"), WycombeWanderers("1933"), XerezCd("1742"), XoloitzcuintlesdeTijuana("111678"), YeovilTown("346"), YorkCity(
	    "1948"), ZaglebieLubin("110749"), ZenitStPetersburg("100769");

    private String value;
    
    public static Map<String, Team> map = new HashMap<>();

    static {
	for (Team team : values()) {
	    map.put(team.name(), team);
	}
    }


    private Team(String value) {
	this.value = value;
    }

    public String getValue() {
	return this.value;
    }

    public static Team findBy(Team team) {
	return map.get(team.name());
    }
}