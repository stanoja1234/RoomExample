package com.example.roomexample

import PersonRepository
import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope

class PersonViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PersonRepository
    val allPeople: LiveData<List<Person>>

    init {
        val personDao = PersonDatabase.getDatabase(application).personDao()
        repository = PersonRepository(personDao)
        allPeople = repository.allPeople
    }

    fun insert(person: Person) = viewModelScope.launch {
        repository.insert(person)
    }

    fun delete(person: Person) = viewModelScope.launch {
        repository.delete(person)
    }
}