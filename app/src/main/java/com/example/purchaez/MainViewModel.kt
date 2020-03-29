package com.example.purchaez

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.purchaez.dataBase.DataBaseHandler
import com.example.purchaez.dataBase.Users

class MainViewModel: ViewModel() {

    private lateinit var dataBase: DataBaseHandler


    // Crear cuenta
    // Arraylist (0) username (1) password (2) confirmpassword (3) email
    fun createUser(userInfo: ArrayList<String>, context: Context):Boolean{
        dataBase = DataBaseHandler(context)
        if(userInfo.get(1).equals(userInfo.get(2))){
            val user = Users(userInfo.get(0),userInfo.get(3) , userInfo.get(1))
            dataBase.insertData(user)
            return true
        }else{
            return false
        }
    }

    // Iniciar sesion
    fun login(){

    }

}