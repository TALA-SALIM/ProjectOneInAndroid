package com.example.talasalim.project1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomAdapter(
        context: Context,
        private val objects: ArrayList<Surah>
) : ArrayAdapter<Surah>(context, 0, objects) {

    override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
    ): View {

        val view = LayoutInflater.from(context)
                .inflate(R.layout.box, parent, false)

        val name = view.findViewById<TextView>(R.id.name)
        val pages = view.findViewById<TextView>(R.id.pages)

        val surah = getItem(position)!!

        name.text = surah.name
        pages.text = surah.pages

        return view
    }
}