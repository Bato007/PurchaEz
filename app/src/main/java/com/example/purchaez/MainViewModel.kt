package com.example.purchaez

import android.content.Context
import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.purchaez.dataBase.DataBaseHandler
import com.example.purchaez.dataBase.Users
import com.example.purchaez.recycleView.Items

class MainViewModel: ViewModel() {

    // Live Data
    private val _totalMoney = MutableLiveData<String>()
    val totalMoney: LiveData<String>
            get() = _totalMoney

    private var item: ArrayList<Items> = ArrayList()
    private lateinit var dataBase: DataBaseHandler
    private var logged = 0

    init {
        _totalMoney.value = "0"
    }

    // Crear cuenta
    // Arraylist (0) username (1) password (2) confirmpassword (3) email
    fun createUser(userInfo: ArrayList<String>, context: Context):Boolean{
        dataBase = DataBaseHandler(context)
        if(userInfo.get(1) == "" || userInfo.get(2) == ""){
            return false
        }
        if(userInfo.get(1).equals(userInfo.get(2))){
            val user = Users(userInfo.get(0),userInfo.get(3) , userInfo.get(1))
            dataBase.insertData(user)
            return true
        }
        else{
            return false
        }
    }

    // Iniciar sesion
    fun login(user:String, password:String, context: Context):Boolean{
        dataBase = DataBaseHandler(context)
        val userList = dataBase.readData()
        for(usuario in userList){
            if(usuario.UserName.equals(user) && usuario.Password.equals(password) ){
                logged = 1
                return true
            }
        }
        return false

    }

    fun checkLogged(): Int {
        return logged
    }

    fun sendItem(sent: Items){
        _totalMoney.value = ((_totalMoney.value!!.toFloat()).plus(sent.cost * sent.number)).toString()
        
        item.add(sent)
    }

    fun getList(): ArrayList<Items> {
        return item
    }

    fun getTotalValue(): String{
        return _totalMoney.value.toString()
    }

}