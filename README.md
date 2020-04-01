# graafikuseedija
Seedib graafikuid

Projektis kasutame laialdaselt Apache POI api-t, et tegeleda XML failidega. Oleme selle "external library" juurdepääsu saamiseks kasutanud Maven.
Maven sai valitud, kuna üks meist oli sellega varem kokkupuutunud, enne kui praktikumites kasutati Gradle.

Klassid:

*readfromXML - Klassi eesmärk on lugeda sisse andmed XML failist, ning neid nii töödelda, et oleks neid võimalik kasutada Parser klassis.

*writetoXML - Klassi eesmärk on luua uus XML fail ning sinna, sisse töögraafik kirjutada.

*Parser - Klassi eesmärk on nii-öelda luua töövahetuste graafik, selleks kasutame erinevaid algoritme.

*worker - isendiklass, millega saame igale inimesele tekitada oma isendi.
