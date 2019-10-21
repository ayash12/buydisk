package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coolman.buydisk.Adapter.CartAdapter
import com.coolman.buydisk.Adapter.ListMovieAdapter
import com.coolman.buydisk.Data.MusikData
import com.coolman.buydisk.Model.ModelCart
import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelMusik

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button


class Cart : AppCompatActivity() {
    private lateinit var rvCart: RecyclerView
    private var list: ArrayList<ModelCart> = arrayListOf()

     private val title = "Cart "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        setActionBarTitle(title)
        val sharedPreference = SharedPreferences(this)
        rvCart = findViewById(R.id.rv_cart)
        rvCart.setHasFixedSize(true)

        val btncheck : Button = findViewById(R.id.btncart)

        val produk1 = sharedPreference.getValueString("produk")!!
        val harga = sharedPreference.getValueString("harga")!!
        val photo1 = sharedPreference.getValueString("photo")!!
        val edt2 = sharedPreference.getValueString("jml")!!
        val hasil = (harga.toInt() * edt2.toInt()).toString()

        for (position in arrayOf(produk1).indices) {
            val modelCart = ModelCart()
            modelCart.produk = produk1
            modelCart.price = "Rp.$hasil"
            modelCart.jumlah = edt2
            modelCart.photo = photo1.toInt()
            list.add(modelCart)


        }
        btncheck.setOnClickListener {
            val moveIntent = Intent(this@Cart, Pembayaran::class.java)
            moveIntent.putExtra(Pembayaran.EXTRA_HARGA1, "Rp.$hasil")
            startActivity(moveIntent)
        }

        showRecyclerList()
    }


    private fun showRecyclerList() {
        rvCart.layoutManager = LinearLayoutManager(this)
        val cart = CartAdapter(list)
        rvCart.adapter = cart
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }
}

