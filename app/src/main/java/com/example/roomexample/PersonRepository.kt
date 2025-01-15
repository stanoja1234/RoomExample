import androidx.lifecycle.LiveData
import com.example.roomexample.Person
import com.example.roomexample.PersonDao

class PersonRepository(private val personDao: PersonDao) {
    val allPeople: LiveData<List<Person>> = personDao.getAllPeople()

    suspend fun insert(person: Person) {
        personDao.insert(person)
    }

    suspend fun delete(person: Person) {
        personDao.delete(person)
    }
}