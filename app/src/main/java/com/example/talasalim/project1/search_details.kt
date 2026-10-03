package com.example.talasalim.project1


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class search_details : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_details)

        val myDatabase = MyDatabase(this)

        val search = findViewById<EditText>(R.id.Search)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val searchResults = findViewById<ListView>(R.id.SearchResults)

        btnSearch.setOnClickListener {

            val name = search.text.toString().trim()

            val dbString = myDatabase.findSurah(name)

            val adapter = CustomAdapter(this, dbString)

            searchResults.adapter = adapter
        }
    }
}