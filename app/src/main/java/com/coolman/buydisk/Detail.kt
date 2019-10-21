package com.coolman.buydisk

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Detail : AppCompatActivity() {
    private val PREFS_NAME = "kotlincodes"
    private val title = "Detail "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setActionBarTitle(title)
        val produk = intent.getStringExtra(EXTRA_PODUK)
        val harga = intent.getStringExtra(EXTRA_HARGA)
        val deskripsi = intent.getStringExtra(EXTRA_DESK)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
            
        val tv_produk : TextView = findViewById(R.id.produk)
        val tv_harga : TextView = findViewById (R.id.price)
        val tv_desk : TextView= findViewById (R.id.desk)
        val imgPhoto : ImageView = findViewById (R.id.imageproduk)
        val tv_desk1 : TextView= findViewById (R.id.tv1)
        val toko : TextView= findViewById (R.id.tv2)
        val edt : EditText =findViewById(R.id.edtjm)
        val imgPhoto1 : ImageView = findViewById (R.id.img_item_photo1)
        val btnCart : Button = findViewById(R.id.btncart)

        val sharedPreference: com.coolman.buydisk.SharedPreferences =SharedPreferences(this)

        Glide.with(this)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(imgPhoto)

        tv_produk.text = produk
        tv_harga.text = "Rp."+harga
        tv_desk.text = deskripsi

        val desk = "Deskripsi"
        tv_desk1.text = desk

        val toko1 = "TOKO BUY-DISK"
        toko.text = toko1

        val img = R.drawable.logo

        Glide.with(this)
            .load(img)
            .apply(RequestOptions().override(350, 550))
            .into(imgPhoto1)

        btnCart.setOnClickListener {

            val produk = tv_produk.text.toString()
            val gambar= photo.toString()
            val edt1 = edt.editableText.toString()



            sharedPreference.save("produk",produk)
            sharedPreference.save("harga",harga)
            sharedPreference.save("photo",gambar)
            sharedPreference.save("jml",edt1)



            Toast.makeText(this@Detail,"Saved to Cart",Toast.LENGTH_SHORT).show()

        }

    }
    fun kali(harga1: Int, edt1: Int): Int {
        return harga1 * edt1
    }

    companion object {
        const val EXTRA_PODUK = "extra_produk"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DESK =  "extra_desk"
        const val EXTRA_PHOTO = "extra_photo"
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = title
        }
    }

}
