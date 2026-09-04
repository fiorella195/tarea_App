package com.example.notasapp_sqlite

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NotasDatasBaseHelp (context: Context) : SQLiteOpenHelper(
    context,DATABASE_NAME, null, DATABASE_VERSION
){
    override fun onCreate(p0: SQLiteDatabase?) {
        val createTableQuery =
            "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMNS_TITLE TEXT, $COLUMN_DESCRIPTION TEXT)"
        p0?.execSQL(createTableQuery)
    }

    override fun onUpgrade(
        p0: SQLiteDatabase?,
        p1: Int,
        p2: Int
    ) {
       val dropTableQuery =
           "DROP TABLE IF EXISTS $TABLE_NAME"
        p0?.execSQL(dropTableQuery)
        onCreate(p0)

    }

    companion object{
        private const val DATABASE_NAME ="Notas.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "notas"
        private const val COLUMN_ID = "id"
        private const val COLUMNS_TITLE = "titulo"
        private const val COLUMN_DESCRIPTION = "descripcion"
    }


    fun inserNota (nota: Nota) {
        val p0= writableDatabase

        val values = ContentValues().apply {
            put(COLUMNS_TITLE, nota.titulo)
            put(COLUMN_DESCRIPTION, nota.descripcion)
        }


        p0.insert(TABLE_NAME, null, values)
        p0.close()
    }









}