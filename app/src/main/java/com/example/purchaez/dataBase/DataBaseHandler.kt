package com.example.purchaez.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "UsersDB"
const val TABLE_NAME = "Users"
const val COL_USER_NAME = "UserName"
const val COL_USER_PASSWORD = "Password"
const val COL_EMAIL = "Email"
const val COL_ID = "id"

class DataBaseHandler(var context: Context?): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db:SQLiteDatabase?){
        val createTable = "CREATE TABLE "+ TABLE_NAME+" ("+
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT"
                COL_USER_NAME+" VARCHAR(256),"+
                COL_EMAIL +" VARCHAR(256),"+
                COL_USER_PASSWORD+" VARCHAR(256))";

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(users: Users){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_USER_NAME, users.UserName)
        cv.put(COL_EMAIL, users.Email)
        cv.put(COL_USER_PASSWORD, users.Password)
        db.insert(TABLE_NAME, null, cv)
    }

    fun readData(): MutableList<Users>{
        var list: MutableList<Users> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME"
        val result = db.rawQuery(query, null)

        if(result.moveToFirst()){
            do{
                var users = Users()
                users.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                users.UserName = result.getString(result.getColumnIndex(COL_USER_NAME))
                users.Email = result.getString(result.getColumnIndex(COL_EMAIL))
                users.Password = result.getString(result.getColumnIndex(COL_USER_PASSWORD))
                list.add(users)
            }while(result.moveToNext())
        }


        result.close()
        db.close()

        return  list
    }


    fun deleteData(){
        val db = this.writableDatabase
        db.delete(TABLE_NAME, null, null)
        db.close()
    }
}