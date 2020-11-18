# Követelmény specifikáció

## Bevezetés 
 - A weboldalunk célja, hogy az Aquaparkunk vendégeinek számára egy könnyebb és innovatívabb megoldást biztosítsunk a csúszdák használatára. 
Az említett eszköz egy olyan óra, amelyet belépéskor megkapnak a vendégek, és minden csúszda használatkor aktiválniuk kell.
Az Aquapark elhagyásakor ezt az órát vissza kell adni, és a rajta lévő csúszások alapján kell fizetnie a vendégnek egy összeget, melyről részletes számlát fog kapni.
Ha valaki visszaadja az óráját, akkor ezt az órát felhasználhatja egy másik vendég.
A csúszdák forgalmát is rögzítenie kell az órának, a későbbi napvégi ellenőrzésekhez.

## Jelenlegi helyzet

 - Minden csúszda mellett egy embernek kell állnia, és figyelnie, hogy ki csúszhat le.

### Jelenlegi megoldás hátrányai:
 - Nagy figyelmet igényel, ezáltal nem túl megbízható
 - Nem tudjuk nyomon követni a csúszdák forgalmát
 - Nem költséghatékony
 - Időigényes

## Vízió
 - Új rendszerünkkel elérjük, hogy a vendégek gyorsabban és gördülékenyebben igénybe vehessék a csúszdákat
 - A nap végén egy-egy vendég részletes számlát kap, amelyen szerepel, melyik csúszdát hányszor használta
 - Ha az aquapark új csúszdákkal bővül, azt szoftveresen is könnyedén rögzíthetjük, rendszerünk rugalmas

## Funkcionális követelmény
### Dolgozók számára elérhető funkciók:
- Vendégek beléptetése és kiléptetése
- Vendég adatainak lekérdezése
- Órák adatainak lekérdezése
- Vendégenkénti számla előállításának lehetősége

### Vendégek számára elérhető funkciók: 
- Jelenlegi költségek lekérdezése

| ID  | Funkció | Leírás |
| --- | --- | --- |
| F1 | Beléptetés | A vendég belépésekor egy olyan órát kap, amely egyedi azonosítóval látja el a vendéget, és ezt az eszközt minden csúszáskor használnia kell. |
| F2 | Csúszdák használata | Csúszdát csak olyan vendég használhat, akinek órája van. Minden használatkor az órán lévő számla terhelődik. |
| F3 | Vendég adat lekérdezés | A dolgozó lekérdezheti az adott vendég adatait, tartalmazva a csúszdák használatát és jelenlegi számláját. |
| F4 | Jelenlegi költségek lekérdezése | A vendég képes a jelenlegi költségeit lekérdezni. |
| F5 | Vendég számlájának előállítása | A vendég számlát kap az Aquapark elhagyása előtt, amely tartalmazza a költségeket, melyeket fizetnie kell. |
| F6 | Kiléptetés | A vendég az Aquapark elhagyásakor visszaadja az óráját, melyet egy másik vendég újra megkaphat. |

## Adatfa

#### F1 | Beléptetés
```
{
guestName: String,
watchId: Integer,
arrival: dateTime
}
```

#### F2 | Csúszdák használata
```
{
guestName: String,
watchId: Integer,
slideId: Integer,
expense: Integer
}
```

#### F3 | Vendég adat lekérdezés
```
{
guestName: String,
watchId: Integer,
payId: Integer,
arrival: dateTime          
}
```

#### F4 | Jelenlegi költségek lekérdezése
```
{
guestName: String,
watchId: Integer,
expense: Integer
}
```

#### F5 | Vendég számlájának előállítása
```
{
guestName: String,
expense: Integer
}
```

#### F6 | Kiléptetés
```
{
guestName: String
}
```



## Követelmény lista
 - Belépéskor minden egyes vendég számára órát biztosítunk
 - Az összes csúszda érzékelőkkel van ellátva
 - Biztosítjuk, hogy a felhasznált óra egyedi és csakis az adott vendég használja
 - Az óra adatait leadás után törölni fogjuk
 - A zárás előtt minden egyes óra vissza kell kerüljön

 
 ![UseCase.png]https://github.com/Mrk-PTi/Aquapark_C1/blob/master/docs/UseCase.png