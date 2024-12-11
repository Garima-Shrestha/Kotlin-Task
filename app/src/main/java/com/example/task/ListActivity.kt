package com.example.task

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListActivity : AppCompatActivity(), AdapterView.OnItemClickListener  {

    lateinit var listView : ListView

    val contact = arrayOf("Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita",
        "Ram", "Shyam", "hari", "sita", "gita"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)

        listView = findViewById(R.id.list)

        val adapter = ArrayAdapter(this@ListActivity,
            android.R.layout.simple_list_item_1,
            contact
        )
        listView.adapter=adapter
        listView.onItemClickListener=this

//        listView.setOnItemClickListener {
//                adapterView, view, position, l ->
//            Toast.makeText(
//                this@ListActivity,
//                adapterView.getItemAtPosition(position).toString(),
//                Toast.LENGTH_SHORT
//            ).show()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val clickedItem = contact[p2]
        Toast.makeText(this, "Clicked: $clickedItem", Toast.LENGTH_SHORT).show()    }
}