package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coolman.buydisk.Adapter.GridAdapter
import com.coolman.buydisk.Adapter.GridAdapterMovie
import com.coolman.buydisk.Adapter.ListMovieAdapter
import com.coolman.buydisk.Adapter.ListMusikAdapter
import com.coolman.buydisk.Data.MovieData
import com.coolman.buydisk.Data.MusikData
import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelMusik

class Movie : AppCompatActivity() {
    private lateinit var rvMovie: RecyclerView
    private var list: ArrayList<ModelMovie> = arrayListOf()
    private val title = "Movie "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_movie)
        rvMovie = findViewById(R.id.rv_movie)
        rvMovie.setHasFixedSize(true)
        list.addAll(MovieData.listData)
        showRecyclerGrid()

    }
    private fun showRecyclerGrid() {
        rvMovie.setLayoutManager(GridLayoutManager(this, 2))
        val gridmovie = GridAdapterMovie(list)
        rvMovie.adapter = gridmovie
        gridmovie.setOnItemClickCallback(object : GridAdapterMovie.OnItemClickCallback {
            override fun onItemClicked(data: ModelMovie) {
                val moveIntent = Intent(this@Movie, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.movie)
                moveIntent.putExtra(Detail.EXTRA_HARGA, data.price)
                moveIntent.putExtra(Detail.EXTRA_DESK, data.deskripsi)
                moveIntent.putExtra(Detail.EXTRA_PHOTO, data.photo)
                startActivity(moveIntent)
            }
        })
    }



    private fun showRecyclerList() {
        rvMovie.layoutManager = LinearLayoutManager(this)
        val listmovieAdapter = ListMovieAdapter(list)
        rvMovie.adapter = listmovieAdapter
        listmovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelMovie) {
                val moveIntent = Intent(this@Movie, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.movie)
                moveIntent.putExtra(Detail.EXTRA_HARGA, data.price)
                moveIntent.putExtra(Detail.EXTRA_DESK, data.deskripsi)
                moveIntent.putExtra(Detail.EXTRA_PHOTO, data.photo)
                startActivity(moveIntent)
            }
        })
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        val inflater = menuInflater
        inflater.inflate(R.menu.fiture, menu)
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.getItemId() === R.id.list) {
            showRecyclerList()
        } else if (item.getItemId() === R.id.grid) {
            showRecyclerGrid()
        }

        return true
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
}
