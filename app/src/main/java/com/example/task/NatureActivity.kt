package com.example.task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task.adapter.NatureAdapter

class NatureActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var imageList = ArrayList<Int>()
    var titleList = ArrayList<String>()
    var descList = ArrayList<String>()
    lateinit var adapter: NatureAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nature)

        recyclerView = findViewById(R.id.recycleView)

        imageList.add(R.drawable.abc)
        imageList.add(R.drawable.download)
        imageList.add(R.drawable.efg)

        titleList.add("Night Scenerio")
        titleList.add("Sunset")
        titleList.add("Greenery")

        descList.add("This is Night Scenerio")
        descList.add("This is sunset")
        descList.add("This is greenery")

        adapter = NatureAdapter(this@NatureActivity, imageList, titleList, descList)

        recyclerView.adapter = adapter

        //vertical scroll
//        recyclerView.layoutManager = LinearLayoutManager(this@NatureActivity)

        //Horizontal scroll
//        recyclerView.layoutManager = LinearLayoutManager(this@NatureActivity, LinearLayoutManager.HORIZONTAL, false)

        //grid scroll
        recyclerView.layoutManager = GridLayoutManager(this@NatureActivity,2)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}