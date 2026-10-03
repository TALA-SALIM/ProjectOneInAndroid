package com.example.talasalim.project1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues

class MyDatabase(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(
            db: SQLiteDatabase?,
            oldVersion: Int,
            newVersion: Int
    ) {
        db!!.execSQL("DROP TABLE IF EXISTS $DATABASE_TABLE_NAME")
        onCreate(db)
    }

    // حفظ السورة
    fun addSurah(
            surahName: String,
            name: String,
            startName: String,
            start: String,
            endName: String,
            end: String,
            notesName: String,
            notes: String
    ) {
        val db = writableDatabase
        val values = ContentValues()

        values.put(surahName, name)
        values.put(startName, start)
        values.put(endName, end)
        values.put(notesName, notes)

        db.insert(DATABASE_TABLE_NAME, null, values)
        db.close()
    }

    // جلب جميع السور المحفوظة
    fun databaseToString(): ArrayList<Surah> {

        val surahs = ArrayList<Surah>()
        val db = readableDatabase

        val query = "SELECT * FROM $DATABASE_TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {

            do {

                val name = cursor.getString(
                        cursor.getColumnIndexOrThrow(NAME)
                )

                val start = cursor.getString(
                        cursor.getColumnIndexOrThrow(START)
                )

                val end = cursor.getString(
                        cursor.getColumnIndexOrThrow(END)
                )

                val pages = "من الآية $start إلى الآية $end"

                surahs.add(
                        Surah(name, pages)
                )

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return surahs
    }

    // البحث عن سورة بالاسم
    fun findSurah(name: String): ArrayList<Surah> {

        val surahs = ArrayList<Surah>()
        val db = readableDatabase

        val cursor = db.rawQuery(
                "SELECT * FROM $DATABASE_TABLE_NAME WHERE $NAME LIKE ?",
                arrayOf("%$name%")
        )

        if (cursor.moveToFirst()) {

            do {

                val surahName = cursor.getString(
                        cursor.getColumnIndexOrThrow(NAME)
                )

                val start = cursor.getString(
                        cursor.getColumnIndexOrThrow(START)
                )

                val end = cursor.getString(
                        cursor.getColumnIndexOrThrow(END)
                )

                val pages = "من الآية $start إلى الآية $end"

                surahs.add(
                        Surah(surahName, pages)
                )

            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return surahs
    }

    companion object {

        private const val DATABASE_NAME = "quran.db"

        private const val DATABASE_VERSION = 2

        private const val DATABASE_TABLE_NAME = "surahs"

        private const val ID = "id"

        const val NAME = "name"
        const val START = "start"
        const val END = "end"
        const val NOTES = "notes"

        private const val DATABASE_CREATE =
                "CREATE TABLE $DATABASE_TABLE_NAME (" +
                        "$ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "$NAME TEXT NOT NULL, " +
                        "$START TEXT NOT NULL, " +
                        "$END TEXT NOT NULL, " +
                        "$NOTES TEXT)"
    }
}