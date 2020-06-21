package com.example.sqlliteexampleinkotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DbOpenHelper(
    context: Context?
) : SQLiteOpenHelper(context, ContactContract.Entry.DATABASE_NAME, null, ContactContract.Entry.DATABASE_VERSION) {

    public val CREATE_TABLE:String = "CREATE TABLE IF NOT EXISTS " + ContactContract.Entry.CONTACT_TABLE +
            "(" + ContactContract.Entry.CONTACT_ID + " number," + ContactContract.Entry.CONTACT_NAME +
            " text," + ContactContract.Entry.CONTACT_Email + " text);"
    public val DROP_TABLE = "DROP TABLE IF EXISTS " + ContactContract.Entry.CONTACT_TABLE


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
        Log.i("Database Operations", "Table created successfully ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE)
        onCreate(db)
    }

    public fun AddContact(id: Int, name: String, email: String, sqlSQLiteDatabase: SQLiteDatabase){

        var contentValues:ContentValues = ContentValues()
        contentValues.put(ContactContract.Entry.CONTACT_ID, id)
        contentValues.put(ContactContract.Entry.CONTACT_NAME, name)
        contentValues.put(ContactContract.Entry.CONTACT_Email, email)

        sqlSQLiteDatabase.insert(ContactContract.Entry.CONTACT_TABLE, null, contentValues)

        Log.i("Database Operations", "One row affected ")

    }

    public fun DisplayContacts(sqlSQLiteDatabase: SQLiteDatabase): Cursor{

        val selection:Array<String> = arrayOf(ContactContract.Entry.CONTACT_ID, ContactContract.Entry.CONTACT_NAME, ContactContract.Entry.CONTACT_Email)
        val cursor: Cursor = sqlSQLiteDatabase.query(ContactContract.Entry.CONTACT_TABLE, selection, null, null, null, null, null)

        return cursor
    }

    public fun UpdateContact(id: Int, name: String, email: String, sqLiteDatabase: SQLiteDatabase){

        val contentValues: ContentValues = ContentValues()
        contentValues.put(ContactContract.Entry.CONTACT_NAME, name)
        contentValues.put(ContactContract.Entry.CONTACT_Email, email)

        val selection: String = "${ContactContract.Entry.CONTACT_ID} = $id"

        sqLiteDatabase.update(ContactContract.Entry.CONTACT_TABLE, contentValues, selection, null)

    }

    public fun DeleteContact(id:Int, sqlSQLiteDatabase: SQLiteDatabase){

        val selection: String = "${ContactContract.Entry.CONTACT_ID} = $id"
        sqlSQLiteDatabase.delete(ContactContract.Entry.CONTACT_TABLE, selection, null)
    }






}