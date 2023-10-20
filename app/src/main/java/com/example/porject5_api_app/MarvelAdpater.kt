package com.example.porject5_api_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MarvelAdpater(val marvelList: MutableList<Heroes>) : RecyclerView.Adapter<MarvelAdpater.MarvelViewHolder>() {
    private lateinit var context: Context
    class MarvelViewHolder(view: View) : RecyclerView.ViewHolder(view){
         val heroImage = itemView.findViewById<ImageView>(R.id.hero_ima)
         val name = itemView.findViewById<TextView>(R.id.hero_NameText)
         val descrip =itemView.findViewById<TextView>(R.id.hero_DescriptionText)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelAdpater.MarvelViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.hero_image,parent, false)
        return MarvelViewHolder(view)


    }

    override fun getItemCount(): Int {
        return marvelList.size
    }

    override fun onBindViewHolder(holder: MarvelAdpater.MarvelViewHolder, position: Int) {
        val hero = marvelList[position]
        holder.heroImage.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Hero is in position $position", Toast.LENGTH_SHORT).show()
        }

        Glide.with(context).load(hero.image).into(holder.heroImage)
        holder.name.text = hero.name
        holder.descrip.text = hero.description





    }
}