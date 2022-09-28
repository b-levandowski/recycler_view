package com.example.recyclerview.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.RecyclerItemClickListener
import com.example.recyclerview.RecyclerItemClickListener.OnItemClickListener
import com.example.recyclerview.adapter.Adapter
import com.example.recyclerview.model.Movie

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private val movies : ArrayList<Movie> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        fillingMovieList()
        instancingRecyclerView()
        clickAbleRecyclerView()
    }

    private fun instancingRecyclerView() {
        recyclerView.run {
            layoutManager = LinearLayoutManager(applicationContext)
            setHasFixedSize(true)
            adapter = Adapter(movies)
        }
    }

    private fun fillingMovieList() {
        movies.add(Movie("Sherek", "2001", "ação"))
        movies.add(Movie("Avatar", "2011", "aventura"))
        movies.add(Movie("The Hobitt", "2016", "aventura"))
    }

    private fun clickAbleRecyclerView() {
        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(
                applicationContext,
                recyclerView,
                object: OnItemClickListener {
                    override fun onItemClick(view: View?, position: Int) {
                        val movie: Movie = movies[position]
                        Toast.makeText(applicationContext, "Normal click: " + movie.title, Toast.LENGTH_SHORT).show()
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        val movie: Movie = movies[position]
                        Toast.makeText(applicationContext, "Long click: " + movie.title, Toast.LENGTH_SHORT).show()
                    }
                }
        ))
    }

}

