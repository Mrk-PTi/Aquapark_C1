# Funkcionális specifikáció
## Áttekintés
- Ebben a fejezetben röviden ismertetem a projektünk egészét. Milyen technológiákat szeretnénk alkalmazni, hogyan fog működni az alkalmazásunk.

- A fejlesztés célja egy vizuálisan részletes, és átlátható web alkalmazás készítése, amely képes nyílvántartani egy aquaparkban a csúszdák használatát, és megjeleníteni, egy vendég mikor érkezett és távozott

- Az alkalmazást az aquapark alkalmazottai kezelik. Belépéskor minden vendég kap egy órát, amit használnia kell minden csúszás után. Távozáskor az óráról leolvasottak alapján kap számlát.

- A dolgozók képesek az adatbázisból kiolvasni :
 - Mikor érkezett a vendég
 - Mely csúszdákat használta és hányszor
 - Mikor távozott
 - Mennyit fizetett
- Milyen azonosítójú óra volt nála

- Ezen adatok alapján statisztikát készítenek az aquapark forgalmáról és a csúszdák kihasználtságáról.

- Ha egy vendég záróra előtt távozik, az óráját lenullázhatjuk és újra kiadhatjuk.
## Jelenlegi helyzet
- Ennek a fejezetnek a feladata kifejteni, hogy miért van szükség az alkalmazásunkra. Érdemes minél lényegretörőbbnek lenni benne, minél több pontban ecsetelve a szükséget.

- Az aquaparknak szüksége van egy átfogó rendszerre ami korszerűsíti a jelenlegi rendszert, átláthatóbbá és értelmezhetőbbé teszi a vendégek igényeit és visszakövethetőbbé a pénzösszegek befolyását.

- A jelenlegi megoldás túl lassú ahhoz, hogy megfelelően kielégítse a vendégek igényeit. Ráadásul az alkalmazottaknak kevesebb ideje marad egyéb teendőikre.

- A befolyó összegek nyomonkövetése jelenlegi formájában nehéz. Időigényes visszakövetni ki melyik csúszdát mikor használta.

- Minden csúszdánál állnia kell egy alkalmazottnak, ezért sok embert kell felvennie az aquaparknak. 
## Követelménylista
- A programozás szempontjából talán a legfontosabb része a dokumentumnak. Itt kell leírni azt, hogy milyen funkciókkal kell rendelkeznie a programunknak, ezeknek milyen al-funkciói vannak.

- Hozzáadás : új vendég regisztrálása a rendszerbe, beleértve érkezésének idejét, valamint hogy mely csúszdákat használta hányszor és mennyit fizetett távozásaskor.

  - Kifejtés: Adatok hozzáadása az adatbázishoz

- Törlés : vendég minden adatának kitörlése, ha azokra már nincs szükség.

   - Kifejtés: Adatok törlése az adatbázisból

- Listázás : segítség a statisztikák elkészítéséhez, minden vendég minden adata látható legyen.

   - Kifejtés: Adatok listázása

- Navigációs menü : Navigációs menü létrehozása, ahol a kezdőlapra kattintva a kezdőlap jelenik meg.

   - Kifejtés: Navigációs menü létrehozása, ahol a kezdőlapra kattintva a kezdőlap jelenik meg.

## Használati esetek
- A recepciós órát ad a vendégnek.

- A vengég használja az órát.

- A recepciós adatokat tud felvinni a rendszerbe és azokat módosítani.

- A recepciós láthatja az adatbázisban lévő adatokat.

## Forgatókönyv
- A recepciósok tudják kezelni a rendszert, egyszerre egy dolgot tudnak benne csinálni

## Fogalomtár
- Számla : fizetésről bizonylat.
- Óra : azonosítóval ellátott eszköz, amelyet a vendégeknek minden csúszás után használni kell.
