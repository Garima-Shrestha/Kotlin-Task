package com.example.task

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{

    lateinit var spinner: Spinner
    lateinit var textView: TextView
    lateinit var  autoCompleteTextView: AutoCompleteTextView
    val countries = arrayOf("Nepal", "India", "China", "Japan")
    val citites = arrayOf("Kathmandu", "Bhaktapur", "Lalitpur", "Kitipur", "Kanchanpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)


        spinner = findViewById(R.id.spinnerCountry)
        textView = findViewById(R.id.displayCountry)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)

        val autoAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            citites
        )
        autoCompleteTextView.setAdapter(autoAdapter)
        autoCompleteTextView.threshold = 2

        val adapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_dropdown_item_1line
        )
        spinner.adapter = adapter
        spinner.onItemSelectedListener=this

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(p0 != null){
            textView.text = p0.getItemAtPosition(p2).toString()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
