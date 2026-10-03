package com.example.talasalim.project1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate (savedInstanceState: Bundle?) {
        super. onCreate (savedInstanceState)
        setContentView (R. layout. activity_main)

        btnadd.setOnClickListener {
            val inte = Intent(this, add::class.java)
            startActivity(inte)}

            btnsave.setOnClickListener {
                val intet = Intent (  this, Save::class.java)
                startActivity (intet)}

                btnsearchDetails.setOnClickListener {
                    val intet = Intent (  this, search_details::class.java)
                    startActivity(intet)}







    }
}