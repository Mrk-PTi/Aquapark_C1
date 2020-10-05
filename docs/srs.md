# Követelmény specifikáció

## Bevezetés 
 - A weboldalunk célja, hogy az Aquaparkunk vendégeinek számára egy könnyebb és innovatívabb megoldást biztosítsunk a csúszdák használatára. 
Az említett eszköz egy olyan óra, amelyet belépéskor megkapnak a vendégek, és minden csúszda használatkor aktiválniuk kell.
Az Aquapark elhagyásakor ezt az órát vissza kell adni, és a rajta lévő csúszások alapján kell fizetnie a vendégnek egy összeget, melyről részletes számlát fog kapni.
Ha valaki visszaadja az óráját, akkor ezt az órát felhasználhatja egy másik vendég.
A csúszdák forgalmát is rögzítenie kell az órának, a későbbi napvégi ellenőrzésekhez.

## Jelenlegi helyzet

Minden csúszda mellett egy embernek kell állnia, és figyelnie hogy, ki csúszhat le.

### Jelenlegi megoldás hátrányai:
 - Nagy figyelmet igényel, ezáltal nem túl megbízható
 - Nem tudjuk nyomon követni a csúszdák forgalmát
 - Nem költséghatékony
 - Időigényes

## Vágyálom rendszer
 - Új rendszerünkkel elérjük, hogy a vendégek gyorsabban és gördülékenyebben igénybe vehessék a csúszdákat
  Az aquapark dolgozói így átláthatóbb statisztikát készíthetnek, ezáltal az ő munkájuk is könyebb lesz.
  A nap végén egy-egy vendég részletes számlát kap, amelyen szerepel, melyik csúszdát hányszor használta.
  Ha az aquapark új csúszdákkal bővül, azt szoftveresen is könnyedén rögzíthetjük, rendszerünk rugalmas.

## Funkcionális követelmény
### Dolgozók számára elérhető funkciók:
- Vendégek belépésekor és kilépésekor értesítés
- Vendégenkénti órák adatainak lekérdezése
- Napi/havi statisztika
- Vendégenkénti számla előállításának lehetősége

### Vendégek számára elérhető funkciók:
- Saját csúszási adatok lekérdezése 
- Jelenlegi költségek lekérdezése

## Követelmény lista
 - Belépéskor minden egyes vendég számára órát biztosítunk.
 - Az összes csúszda érzékelőkkel van ellátva.
 - Biztosítjuk, hogy a felhasznált óra egyedi és csakis az adott vendég használja.
 - Az óra adatait leadás után törölni fogjuk.
 - A zárás előtt minden egyes óra vissza kell kerüljön.
