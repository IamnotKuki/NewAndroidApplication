package ru.example.mynewapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val db = Dap.roomDB
    val users = MutableLiveData<List<Users>>()

    fun generateUsers(){
        viewModelScope.launch {
            for(i in 0..20){
                addUser("name ${i}")
            }
        }
    }

    fun addUser(name: String){
        viewModelScope.launch {
            db.getUserDao().addUser(Users(name))
        }
    }

    fun getAll(){
        viewModelScope.launch {
            users.postValue(db.getUserDao().getAllUsers())
        }
    }

}