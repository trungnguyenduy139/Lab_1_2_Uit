package com.example.trungnguyen.labuit.helper

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.trungnguyen.labuit.bean.Contact

/**
 * Author : Trung Nguyen
 * Date : 10/16/2017
 */
class ContactDbHelper internal constructor(
        context: Context, dbName: String, cursorFactory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, dbName, cursorFactory, version) {

    companion object {
        private const val DB_NAME = "ContactManagement"
        private const val DB_VERSION = 1
        private const val DB_TABLE_NAME = "Contact"
        private const val KEY_ID = "id"
        private const val KEY_NAME = "name"
        private const val KEY_PHONE_NUMBER = "number"
    }

    private var mContactDbHelper: SQLiteDatabase? = null

    constructor(context: Context) : this(context, DB_NAME, null, DB_VERSION) {
        openDb()
    }

    fun openDb() {
        if (mContactDbHelper == null || !mContactDbHelper?.isOpen!!) {
            mContactDbHelper = writableDatabase
        }
    }

    fun closeDb() {
        if (mContactDbHelper != null && mContactDbHelper?.isOpen!!) {
            mContactDbHelper?.close()
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $DB_TABLE_NAME ($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, $KEY_NAME TEXT, $KEY_PHONE_NUMBER TEXT);"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        // Drop older table if existed
        db?.execSQL("DROP TABLE IF EXISTS $DB_TABLE_NAME")
        // Create tables again
        onCreate(db)

    }

    fun updateContactByName(name: String, phone: String) {
        val updateQuery = "UPDATE $DB_TABLE_NAME SET $KEY_PHONE_NUMBER = '$phone' WHERE $KEY_NAME = '$name'"
        mContactDbHelper?.execSQL(updateQuery)
    }

    fun deleteAllContact() {
        val deleteAllQuery = "DELETE FROM $DB_TABLE_NAME"
        mContactDbHelper?.execSQL(deleteAllQuery)
        resetAutoIncrementId()
    }

    private fun resetAutoIncrementId() {
        val resetQuery = "DELETE FROM SQLITE_SEQUENCE WHERE name = '$DB_TABLE_NAME'"
        mContactDbHelper?.execSQL(resetQuery)
    }

    fun deleteById(id: Int) {
        val deleteByIdQuery = "DELETE FROM $DB_TABLE_NAME WHERE $KEY_ID = '$id'"
        mContactDbHelper?.execSQL(deleteByIdQuery)
    }

    fun addNewContact(name: String, phoneNum: String) {
        val insertIntoQuery = "INSERT INTO $DB_TABLE_NAME ($KEY_NAME, $KEY_PHONE_NUMBER) VALUES ('$name', '$phoneNum');"
        mContactDbHelper?.execSQL(insertIntoQuery)
    }

    fun getAllContact(): ArrayList<Contact> {
        val listContact = ArrayList<Contact>()
        val cursor = mContactDbHelper?.rawQuery("SELECT * FROM $DB_TABLE_NAME", null) as Cursor
        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val phoneNum = cursor.getString(2)
            listContact.add(Contact(id, name, phoneNum))
        }
        cursor.close()
        return listContact
    }
}