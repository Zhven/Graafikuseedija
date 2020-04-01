# graafikuseedija
*AUTORID Sven-Ervin Paap, Enri Täär*

Kood on kirjutatud inglise keeles, kuna see programm võib näha päriselulist tööd.
Võtab, sisse inimeste soovidega tabeli, ning paneb selle põhjal kokku vahetustega töögraafiku. Töögraafik, on 7 päevane, ning igas päevas on 3 vahetust. Päevaste vahetuste vahel peab olema vähemalt 12 tundi, ning öistel 24.

Projektis kasutame laialdaselt Apache POI api-t, et tegeleda XML failidega. Oleme selle "external library" juurdepääsu saamiseks kasutanud Maven.
Maven sai valitud, kuna üks meist oli sellega varem kokkupuutunud, enne kui praktikumites kasutati Gradle.

Klassid:

*readfromXML* - Klassi eesmärk on lugeda sisse andmed XML failist, ning neid nii töödelda, et oleks neid võimalik kasutada Parser klassis. Sellest klassist tulenev info omistatakse worker klass isenditele. 

*writetoXML* - Klassi eesmärk on luua uus XML fail ning sinna, sisse töögraafik kirjutada.

*Parser* - Klassi eesmärk on nii-öelda luua töövahetuste graafik, selleks kasutame erinevaid algoritme. Klassis esineb, küll veidi palju switch:case juhtumeid, kuid see on tahtlikult, et oleks võimalik, muuta vahetuse töö suurust.

*worker* - isendiklass, millega saame igale inimesele tekitada oma isendi.

Mured - algselt oli veidi keerukas APACHE POI api-ga tegeleda, kuid lõpuks hakkas töö sujuvalt liikuma.

Projekti tegemise protsessid ning panused - Kõik projektis olev töö, sai tehtud mõlema poolt, kui mõlemad olime kättesaadavad. Discordi kõne kasutades, saime näidata üksteisele enda töölauda ning koodi. Ajakulu on seega mõlemal täpselt samasugune. Kõik probleemid ja mured sai, meil läbiräägitud tööd tehes ning aitasime üksteisel koodi kokku panna.
