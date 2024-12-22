package com.example.task.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R

class NatureAdapter (
    val context: Context,
    val imageList : ArrayList<Int>,
    val titleList : ArrayList<String>,
    val descList : ArrayList<String>
) : RecyclerView.Adapter<NatureAdapter.NatureViewHolder>(){
    class NatureViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.abc)
        var title : TextView = itemView.findViewById(R.id.night_title)
        var desc : TextView = itemView.findViewById(R.id.night_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NatureViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.sample_nature, parent,false)       //should always have false, if true then error will occur
        return NatureViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: NatureViewHolder, position: Int) {
        holder.image.setImageResource(imageList[position])
        holder.title.text = titleList[position]
        holder.desc.text = descList[position]
    }
}