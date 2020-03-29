package com.example.purchaez.dataBase

class Users {

    var id: Int = 0
    var UserName : String =""
    var Email :String =""
    var Password : String = ""

    constructor(UserName:String, Email: String, Password:String){
        this.UserName = UserName
        this.Email = Email
        this.Password = Password
    }

    constructor(){

    }


}