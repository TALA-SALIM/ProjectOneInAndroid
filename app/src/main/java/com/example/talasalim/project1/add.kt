package com.example.talasalim.project1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*
import android.widget.Toast;

class add : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContentView(R.layout.activity_add)

            var myDatabase = MyDatabase(this)

            Save.setOnClickListener {

                if (Name.text.toString().isNotEmpty() &&
                        Start.text.toString().isNotEmpty() &&
                        End.text.toString().isNotEmpty()) {

                    val name = Name.text.toString()
                    val start = Start.text.toString()
                    val end = End.text.toString()
                    val notes = Notes.text.toString()

                    myDatabase.addSurah(
                            MyDatabase.NAME,
                            name,
                            MyDatabase.START,
                            start,
                            MyDatabase.END,
                            end,
                            MyDatabase.NOTES,
                            notes
                    )

                    Toast.makeText(
                            this,
                            "تم حفظ السورة",
                            Toast.LENGTH_LONG
                    ).show()

                } else {

                    Toast.makeText(
                            this,
                            "يرجى تعبئة البيانات المطلوبة",
                            Toast.LENGTH_LONG
                    ).show()
                }
            }

            back.setOnClickListener {

                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
            }
        }
    }
