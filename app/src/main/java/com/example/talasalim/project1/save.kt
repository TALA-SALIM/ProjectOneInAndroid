package com.example.talasalim.project1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView

class Save : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save)

        val myDatabase = MyDatabase(this)
        val surahs = myDatabase.databaseToString()

        val listView = findViewById<ListView>(R.id.list)

        val adapter = CustomAdapter(this, surahs)

        listView.adapter = adapter
    }
}