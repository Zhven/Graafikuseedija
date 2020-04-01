# graafikuseedija
*AUTORID Sven-Ervin Paap, Enri Täär*

Võtab, sisse inimeste soovidega tabeli, ning paneb selle põhjal kokku vahetustega töögraafiku.

Projektis kasutame laialdaselt Apache POI api-t, et tegeleda XML failidega. Oleme selle "external library" juurdepääsu saamiseks kasutanud Maven.
Maven sai valitud, kuna üks meist oli sellega varem kokkupuutunud, enne kui praktikumites kasutati Gradle.

Klassid:

*readfromXML* - Klassi eesmärk on lugeda sisse andmed XML failist, ning neid nii töödelda, et oleks neid võimalik kasutada Parser klassis.

*writetoXML* - Klassi eesmärk on luua uus XML fail ning sinna, sisse töögraafik kirjutada.

*Parser* - Klassi eesmärk on nii-öelda luua töövahetuste graafik, selleks kasutame erinevaid algoritme.

*worker* - isendiklass, millega saame igale inimesele tekitada oma isendi.

Mured - algselt oli veidi keerukas APACHE POI api-ga tegeleda, kuid lõpuks hakkas töö sujuvalt liikuma.

Projekti tegemise protsessid ning panused - Kõik projektis olev töö, sai tehtud mõlema poolt, kui mõlemad olime kättesaadavad. Discordi kõne kasutades, saime näidata üksteisele enda töölauda ning koodi. Ajakulu on seega mõlemal täpselt samasugune. Kõik probleemid ja mured sai, meil läbiräägitud tööd tehes ning aitasime üksteisel koodi kokku panna.
