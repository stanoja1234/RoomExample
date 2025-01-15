## Kaj je Room?

**Room** je uradna **ORM (Object Relational Mapping)** knjižnica v Androidu, ki ponuja enostaven način za delo z SQLite bazami podatkov. Z uporabo anotacij in preverjanja poizvedb v času prevajanja Room poenostavi pisanje kode za delo z bazami podatkov, kar zagotavlja pravilnost poizvedb.
---

## Prednosti in slabosti Room

| **Prednosti**                                            | **Slabosti**                                           |
|----------------------------------------------------------|--------------------------------------------------------|
| **Poenostavitev kode za delo z bazami podatkov**         | **Strmejša učna krivulja za začetnike**                 |
| Room zmanjša količino potrebne kode za delo z SQLite, kar naredi operacije bolj jedrnate in berljive. | Razumevanje anotacij, entitet, DAO-ov in migracij lahko predstavlja izziv za začetnike. |
| **Preverjanje poizvedb v času prevajanja**               | **Omejene napredne funkcionalnosti SQLite**             |
| SQL poizvedbe so preverjene med prevajanjem, kar omogoča zgodnje odkrivanje napak. | Room ne omogoča vseh naprednih funkcij SQLite, kar pomeni, da lahko kompleksne poizvedbe zahtevajo ročno obvladovanje. |
| **Integracija s Kotlin Coroutines**                      |                                                        |
| Room podpira Kotlin Coroutines, kar omogoča asinhrono izvajanje operacij brez dodatnih knjižnic za niti. |                                                        |

---

## Licenca
Licenca je Apache 2.0.
---

## Informacije
Trenutna verzija Room 2.6.1
Alternative: DBFlow, Firebase, Realm, GreenDAO, SQLite
---
## Primer uporabe

### Korak 1: Dodajanje odvisnosti v `build.gradle` datoteko
Najprej moraš dodati potrebne odvisnosti za Room v svojo `build.gradle` datoteko.

### Korak 2: Ustvarjanje entitete (Entity)
Entiteta predstavlja tabelo v bazi podatkov. Vsaka entiteta mora biti anotirana z @Entity, vsako polje pa z @PrimaryKey

```kotlin
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val height: Double,
    val weight:Int
)
```
### Korak 3: Ustvarjanje DAO (Data Access Object)
DAO je vmesnik, ki vsebuje metode za izvajanje operacij  na bazi podatkov.
```kotlin
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
@Dao
interface PersonDao {
    @Insert
    suspend fun insert(person: Person)

    @Query("SELECT * FROM person_table ORDER BY id ASC")
    fun getAllPeople(): LiveData<List<Person>>

    @Delete
    suspend fun delete(person: Person)
}
```
### Korak 4: Ustvarjanje Room Database
Zdaj ustvarimo Room Database, ki bo vsebovala entitete in DAO. Razred, ki podeduje RoomDatabase, bo omogočil dostop do baze podatkov.

```kotlin
import android.content.Context
        import androidx.room.Database
        import androidx.room.Room
        import androidx.room.RoomDatabase

        @Database(entities = [Person::class], version = 1, exportSchema = false)
        abstract class PersonDatabase : RoomDatabase() {
            abstract fun personDao(): PersonDao

            companion object {
                @Volatile
                private var INSTANCE: PersonDatabase? = null

                fun getDatabase(context: Context): PersonDatabase {
                    return INSTANCE ?: synchronized(this) {
                        val instance = Room.databaseBuilder(
                            context.applicationContext,
                            PersonDatabase::class.java,
                            "person_database"
                        ).build()
                        INSTANCE = instance
                        instance
                    }
                }
            }
        }
```




