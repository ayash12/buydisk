package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coolman.buydisk.Adapter.GridAdapter
import com.coolman.buydisk.Data.MusikData
import com.coolman.buydisk.Model.ModelMusik
import androidx.recyclerview.widget.GridLayoutManager
import com.coolman.buydisk.Adapter.ListMusikAdapter
import com.mancj.materialsearchbar.MaterialSearchBar
import android.view.MenuInflater
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Menu
import android.view.MenuItem


class Musik : AppCompatActivity() {

    private lateinit var rvMusik: RecyclerView
    private var list: ArrayList<ModelMusik> = arrayListOf()

    private val title = "Musik "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_musik)
        rvMusik = findViewById(R.id.rv_musik)
        rvMusik.setHasFixedSize(true)
        list.addAll(MusikData.listData)
        showRecyclerGrid()

    }

    private fun showRecyclerGrid() {
        rvMusik.setLayoutManager(GridLayoutManager(this, 2))
        val gridmusik = GridAdapter(list)
        rvMusik.adapter = gridmusik

        gridmusik.setOnItemClickCallback(object : GridAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelMusik) {
                val moveIntent = Intent(this@Musik, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.album)
                moveIntent.putExtra(Detail.EXTRA_HARGA, data.price)
                moveIntent.putExtra(Detail.EXTRA_DESK, data.deskripsi)
                moveIntent.putExtra(Detail.EXTRA_PHOTO, data.photo)
                startActivity(moveIntent)
            }
        })


    }



    private fun showRecyclerList() {
        rvMusik.layoutManager = LinearLayoutManager(this)
        val listmusikAdapter = ListMusikAdapter(list)
        rvMusik.adapter = listmusikAdapter

        listmusikAdapter.setOnItemClickCallback(object : ListMusikAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelMusik) {
                val moveIntent = Intent(this@Musik, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.album)
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




