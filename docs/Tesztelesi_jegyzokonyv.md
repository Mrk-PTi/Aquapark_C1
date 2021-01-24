| Rendszer megnevezése :    | Aquapark |
|  :---:       |    :----:   |
|**Tesztelés várható időtartama**|5 munkanap|
|**Tesztelés erőforrás-szükséglete**|Szerver, csúszda használat szimuláció|


Átvételi eljáráson résztvevő:

Név: Papp Ágnes

Beosztás: Fejlesztő

Dátum: 2020.01.01

|**Sorszám**|**Funkció leírása**|**Vizsgálat módja/eszköze**|**Elvárt eredmény**|**Aktuális eredmény**|**Megfelelősség státusza**|
| :-------- | :---------------- | :------------------------ | :---------------- | :------------------ | :----------------------- |
|Általános funkcionális teszt|
|1.|Vendég hozzáadás|<p>Swagger,</p><p>Google Chrome Böngésző</p>|<p>Adatbázisban új adat jelenik meg</p><p></p>|<p>Adatbázisban új termék jelenik meg</p><p></p>|Megfelelő|
|2.|Vendég idejének lekérése|<p>Swagger,</p><p>Mozzilla Böngésző</p>|Visszatér az vendég idejével|Visszatér az összes termékkel|Megfelelő|
|3.|Csúszdahasználat|<p>Swagger,</p><p>Google Chrome Böngésző</p>|Az óra és csúszda id alapján használat, adatbázisba felvétel|Csúszda azonosítása,
 adatbázisba felvétel|Megfelelő|
|4.|Csúszások lekérése|<p>Swagger,</p><p>Google Chrome Böngésző</p>|Visszatér az összes csúszdahasználattal|Visszatér az összes csúszdahasználattal|Megfelelő|
|5.|Vendég törlése|<p>Swagger,</p><p>Google crome Böngésző</p>|ID alapján, vendég eltávolítása|ID alapján vendég eltávolítása,|Megfelelő|
|6.|Vendégek lekérése|<p>Swagger,</p><p>Google Chrome Böngésző</p>|Visszatér az összes vendéggel|Visszatér az összes vendéggel|Megfelelő|

