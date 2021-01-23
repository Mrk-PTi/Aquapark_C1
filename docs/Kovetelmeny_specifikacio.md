# Követelmény specifikáció
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

## Vágyálomrendszer
- A vágyálomrendszer azért felelős, hogy kifejtsük benne, mit szeretnénk célul a programunkban a 100%-ban ideális esetben. Ilyen-olyan feature-ök jelenléte, és ideális állapotuk.

- A projekt céla egy olyan termék készítése, ami lehetővé teszi az aquapark számára a felzárkózást a többi konkurens céghez online környezetet biztosítva garantálja az aquapark gördülékeny működését.

- Csökkentse az adminisztráció idejét és költségeit. Megkönnyítse az alkalmazottak munkáját.

- A rendszer tegye követhetőbbé, egyes csúszdákat hányszor használják, melyek a legnépszerűbbek.

- Statisztikákat lehessen készíteni a rendszer adatainak segítségével. 

## Funkcionális követelmények
- Új vendég adatainak hozzáadása.

- Feleslegessé vált adatok törlése.

- Vendégek adatainak kilistázása.

- Fizetett összegek megjelenítése.

