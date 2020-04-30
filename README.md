# graafikuseedija
*AUTORID Sven-Ervin Paap, Enri Täär*

Kood on kirjutatud inglise keeles, kuna see programm võib näha päriselulist tööd rahvusvahelises ettevõttes.


Programm võtab sisendiks Microsoft Forms keskkonnas läbiviidud küsitluse alusel kogutud excel faili, kus on kõikide töötajate soovid, milliseid vahetusi nad vabaks soovivad. Info kogumise viisist lähtudes tuleb töötajad, kes vabade vahetuste soove ei avaldanud käsitsi faili lisada. Seejärel luuakse alltoodud reeglite põhjal juhusliku jaotusega tabel ja tuuakse välja töötajad, kellel töötunnid käesoleva graafikuga ei täitnud, et neid saaks hiljem käsitsi paigutada.

Täpsemad tingimused:

    Graafiku ajaslotid on järgnevad
	
    Hommikune 7:00-15:00
	Õhtune 15:00-23:00
	Öine 23:00-7:00
	
	Igal inimesel peab tulema kokku kas 32h või 40h vahetusi.
	
    32h - 1 öine vahetus (mida loetakse kahe vahetuse eest) + 3 hommikust/õhtust vahetust
	40h - 5 hommikust/õhtust vahetust ja mitte ühtegi öist vahetust. 
	
	Päevase ja õhtuse vahetuse vahele peab jääma min 12h. Ehk siis ei saa panna inimest tööle esmaspäeval õhtusesse vahetusse ja teisipäeval hommikusse vahetusse.
	Pühapäeval kell 23.00 algav vahetus loetakse uue nädala vahetuste arvu. 

    Näiteks 26.01 kell 23.00 algav vahetus loetakse öise vahetusena kirja 27.01 algavasse nädalasse. Ehk sellel nädalal nendel inimestel rohkem öövahetusi olla ei tohi.
	
    E-L öistes vahetustes võiks olla 3 inimest per öö, kui on rohkem, on okei, aga 3 on min. 

    P vastu E ööl võib olla 2.
	
    Kui inimene on öövahetuses, siis järgmine vahetus võiks olla õhtune vahetus.
	Tööpäeviti võiks hommikustes ja õhtustes vahetustes olla inimesi kas võrdselt või pigem rohkem õhtuses. 

    Tavaliselt jäävad need numbrid kas 6/6 või siis näiteks 7/8.

    Nädalavahetuseti võiks olla hommikul ja õhtul 3 inimest.
    
    Graafikusse tuleks hakata paigutama inimesi nimekirja alusel ülevalt poolt alla poole (see järjestus, mis graafikut väljasaates on tabelis)
	Tuleks siis arvestada inimeste soovitud graafikusoovidega (fail manuses, mis formaadis ma need saan iga nädal)


Projektis kasutame laialdaselt Apache POI api-t, et tegeleda XML failidega. Oleme selle "external library" juurdepääsu saamiseks kasutanud Maven.
Maven sai valitud, kuna üks meist oli sellega varem kokkupuutunud, enne kui praktikumites kasutati Gradle.

Klassid:

*readfromXML* - Klassi eesmärk on lugeda sisse andmed XML failist, ning neid nii töödelda, et oleks neid võimalik kasutada Parser klassis. Sellest klassist tulenev info omistatakse worker klass isenditele. 

*writetoXML* - Klassi eesmärk on luua uus XML fail ning sinna, sisse töögraafik kirjutada.

*Parser* - Klassi eesmärk on nii-öelda luua töövahetuste graafik, selleks kasutame erinevaid algoritme. Klassis esineb, küll veidi palju switch:case juhtumeid, kuid see on tahtlikult, et oleks võimalik, muuta vahetuse töö suurust.

*worker* - isendiklass, millega saame igale inimesele tekitada oma isendi.

*Graafikuseedija* - Klass, kust käivitatakse ülejäänud programm

*GUI* - Projekti teises faasis lisatud klass, kus toimub kogu suhtlus kasutajaga ja Graafikuseedija abil ülejäänud programmi käivitamine.

Mured: 
- Algselt oli veidi keerukas APACHE POI api-ga tegeleda, kuid lõpuks hakkas töö sujuvalt liikuma.
- Esialgu tegime kilplasliku lahenduse Worker klassi isendiväljadega, kus väljade väärtustamiseks oli vaja luua Parser klassis 21 erinevat switch case-i.
- Meie enda genereeritud testfailis ei olnud arvestatud SM(shift manager)-ega. Päris faili kasutades selgus, et nende välja filtreerimiseks on samuti vaja lahendus leida.

Projekti tegemise protsessid ning panused - Kõik projektis olev töö, sai tehtud mõlema poolt, kui mõlemad olime kättesaadavad. Discordi kõne kasutades, saime näidata üksteisele enda töölauda ning koodi. Ajakulu on seega mõlemal täpselt samasugune. Kõik probleemid ja mured sai, meil läbiräägitud tööd tehes ning aitasime üksteisel koodi kokku panna.

Hinnang:

 - Programm töötab ja ületab kõiki meile seatud eesmärke.
 - Sisse on viidud kõik erinevad uuendused ja parandused, mis projekti esimeses osas ilmnesid
 
 Selgitus:
 
 Programmi testiti esialgu enda loodud graafikusoovi küsimustikust exporditud failiga. Hiljem kasutati isikustamata 2020 aasta teise töönädala soovidest.
 
 Programmi kaustadesse on lisatud sisendfail ja kaks väljundfaili näidist.