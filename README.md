###Kaj je Room?

**Room** je uradna **ORM (Object Relational Mapping)** knjižnica v Androidu, ki ponuja enostaven način za delo z SQLite bazami podatkov. Z uporabo anotacij in preverjanja poizvedb v času prevajanja Room poenostavi pisanje kode za delo z bazami podatkov, kar zagotavlja pravilnost poizvedb.
---

## Prednosti in slabosti Room

| **Prednosti**                                            | **Slabosti**                                           |
|----------------------------------------------------------|--------------------------------------------------------|
| **Poenostavitev kode za delo z bazami podatkov**         | **Strmejša učna krivulja za začetnike**                 |
| Room zmanjša količino potrebne kode za delo z SQLite, kar naredi operacije bolj jedrnate in berljive. | Razumevanje anotacij, entitet, DAO-ov in migracij lahko predstavlja izziv za začetnike. |
| **Preverjanje poizvedb v času prevajanja**               | **Omejene napredne funkcionalnosti SQLite**             |
| SQL poizvedbe so preverjene med prevajanjem, kar omogoča zgodnje odkrivanje napak. | Room ne omogoča vseh naprednih funkcij SQLite, kar pomeni, da lahko kompleksne poizvedbe zahtevajo ročno obvladovanje. |
| **Seamless integracija z LiveData/Flow**                 | **Prevelik overhead za preproste primere**              |
| Room se brez težav integrira z `LiveData` ali `Flow`, kar omogoča reaktivno spremljanje sprememb. | Za enostavno shranjevanje ključ-vrednost (kot `SharedPreferences`) Room lahko prinese nepotrebno zapletenost. |
| **Podpora za migracije**                                 | **Strošek zmogljivosti zaradi abstrakcije**             |
| Room ponuja mehanizme za obvladovanje migracij baz podatkov, kar olajša spremembe shem. | Abstrakcijski sloj lahko prinese majhen dodaten strošek v primerjavi z neposredno uporabo SQLite. |
| **Enostavnost testiranja**                               |                                                        |
| Zaradi abstraktnih plasti je Room primeren za testiranje baz podatkov, saj omogoča uporabo podatkovnih baz v pomnilniku med testi. |                                                        |
| **Integracija s Kotlin Coroutines**                      |                                                        |
| Room podpira Kotlin Coroutines, kar omogoča asinhrono izvajanje operacij brez dodatnih knjižnic za niti. |                                                        |

---

###Licenca
Licenca je Apache 2.0.
---

###Informacije
Trenutna verzija Room 2.6.1
Alternative: DBFlow, Firebase, Realm, GreenDAO, SQLite

---




