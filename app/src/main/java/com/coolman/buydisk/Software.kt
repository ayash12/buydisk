package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coolman.buydisk.Adapter.*
import com.coolman.buydisk.Data.MusikData
import com.coolman.buydisk.Data.SoftData
import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.Model.ModelSoft

class Software : AppCompatActivity() {

    private lateinit var rvSoft: RecyclerView
    private var list: ArrayList<ModelSoft> = arrayListOf()
    private val title = "Software "
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setActionBarTitle(title)
        setContentView(R.layout.activity_software)
        rvSoft = findViewById(R.id.rv_soft)
        rvSoft.setHasFixedSize(true)
        list.addAll(SoftData.listData)
        showRecyclerGrid()

    }
    private fun showRecyclerGrid() {
        rvSoft.setLayoutManager(GridLayoutManager(this, 2))
        val gridsoft = GridAdapterSoftware(list)
        rvSoft.setAdapter(gridsoft)
        gridsoft.setOnItemClickCallback(object : GridAdapterSoftware.OnItemClickCallback {
            override fun onItemClicked(data: ModelSoft) {
                val moveIntent = Intent(this@Software, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.soft)
                moveIntent.putExtra(Detail.EXTRA_HARGA, data.price)
                moveIntent.putExtra(Detail.EXTRA_DESK, data.deskripsi)
                moveIntent.putExtra(Detail.EXTRA_PHOTO, data.photo)
                startActivity(moveIntent)
            }
        })
    }



    private fun showRecyclerList() {
        rvSoft.layoutManager = LinearLayoutManager(this)
        val listsoft = ListSoftwareAdapter(list)
        rvSoft.adapter = listsoft
        listsoft.setOnItemClickCallback(object : ListSoftwareAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ModelSoft) {
                val moveIntent = Intent(this@Software, Detail::class.java)
                moveIntent.putExtra(Detail.EXTRA_PODUK, data.soft)
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
