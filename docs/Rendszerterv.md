# Rendszerterv
## Rendszer célja
- A rendszer célja a recepciós munkájánka megkönnyítése az aquaparkban.

- A program webes felületen fut , és egy adatbázisból kéri le az adatokat.

- A recepciós egy navigációs menünk keresztül kezeli a felületet.

- Fontos, hogy a recepciós könnyen el tudjon igazodni a felületeken ezért minimalista felhasználói felületet kap a program.

## Projektterv
- Ütemterv:
  - Követelmény specifikáció
 
  - Funkcionális specifikáció
  
  - Rendszerterv
  
  - Adatmodell megtervezése
  
  - Adatbázis megvalósítása a szerveren
  
 ## Üzleti folyamatok
 - Üzleti szereplők:
 
   - Recepciósok, dolgozók
   
 - Üzleti folyamatok:
 
   - Adatok rendszerbe való bevitele, módosítása.
   
   - Hozzáférés az adatbázishoz.
   
 ## Követelmények
 - Funkcionális
 
    - Webes környezetben futattható legyen.
    
    - Vendégek adatainak tárolása, listázása.
    
 - Nemfunkcionális
 
    - Gyors listázás.
    
    - Egyszerű, egyértelmű navigációs felület.
    
 - Törvényi előírások, szabványok
 
    - GDPR-nek való megfelelés

## Funkcionális terv
- Rendszerszereplők

    - Recepciós
    
- Rendszerhasználati esetek és lefutásaik

    - Recepciós
    
      - Teljes hozzáférése van a 
      
      - Adatokat látja és változtathat rajta
      
      - Adatok hozzáadására, törlésére van lehetőségük

- Menü hierarchia

    - Kezdőlap
      - Vendég adatai
      - Fizetés adatok

## Fizikai környezet
- Az alkalmazás webplatformra készül.

- Nincsenek megvásárolt komponenseink.

- Fejlesztői eszközök:

    - Sublime Text
    
    - JetBrains Webstorm
    
    - JetBrains IntelliJ IDEA
    
    - Dockstation
    
## Architekturális terv

- Backend

    - A rendszerhez szükség van egy adatbázis szerverre.
    
    - A kliensekkel JSON objektumok segítségével kommunikál.
    
- Frontend

    - A Webes felület főként HTML, CSS, és Javascript segítségével fog készülni.
    
    - Ezeket a technológiákat amennyire csak lehet külön fájlokba írva készítjük, és úgy fogjuk egymáshoz csatolni a jobb átláthatóság, könnyebb változtathatóság, és könnyebb bővítés érdekében.
    
    - Képes lesz felhasználni a Backend részen futó szolgáltatás metódusait, ezáltal tud felvinni és lekérdezni adatokat az adatbázisból.

