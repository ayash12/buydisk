package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_pembayaran.*

class Pembayaran : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pembayaran)
        supportActionBar!!.hide()
        val sharedPreference = SharedPreferences(this)
        val harga = intent.getStringExtra(EXTRA_HARGA1)
        val btnbuy : Button = findViewById(R.id.btnnayar)
        val total : TextView = findViewById(R.id.tvbayar)
        val kurir : TextView = findViewById(R.id.kurir)
        val imgkurir : ImageView = findViewById(R.id.img_kurir)
        val bank : TextView = findViewById(R.id.bank)
        val imgbank : ImageView = findViewById(R.id.img_bank)

        total.text = harga

        val kurir1 = "JNE"
        kurir.text = kurir1

        val img = R.drawable.ic_airport

        Glide.with(this)
            .load(img)
            .apply(RequestOptions().override(350, 550))
            .into(imgkurir)

        val bank1 = "BANK BNI"
        bank.text = bank1

        val img1 = R.drawable.ic_account24dp

        Glide.with(this)
            .load(img1)
            .apply(RequestOptions().override(350, 550))
            .into(imgbank)

        btnbuy.setOnClickListener {
            sharedPreference.clearSharedPreference()
            val moveIntent = Intent(this@Pembayaran, MainActivity::class.java)
            startActivity(moveIntent)
            Toast.makeText(this@Pembayaran,"Pembayaran Diterima",Toast.LENGTH_SHORT).show()
        }
    }
    companion object {
        const val EXTRA_HARGA1 = "extra_harga1"
    }
}
