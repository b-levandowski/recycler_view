package com.example.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.R.id.*
import com.example.recyclerview.model.Movie

class Adapter(var movieList: List<Movie>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(textViewTitle)
        val year: TextView = itemView.findViewById(textViewYear)
        val genre: TextView = itemView.findViewById(textViewGenre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val recyclerViewLayout: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_recyclerview_movies, parent, false)
        return MyViewHolder(recyclerViewLayout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie: Movie = movieList[position]
        holder.title.text = movie.title
        holder.year.text = movie.year
        holder.genre.text = movie.genre
    }

    override fun getItemCount(): Int = movieList.size
}