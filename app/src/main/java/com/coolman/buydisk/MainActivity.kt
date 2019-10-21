package com.coolman.buydisk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener



class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var carouselView: CarouselView

    private val sampleImages = intArrayOf(R.drawable.coverso7, R.drawable.coverkiminonawa, R.drawable.coverwindows)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        carouselView = findViewById(R.id.carouselView)
        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imageListener)

        val btnMoveActivity: Button = findViewById(R.id.btn1)
        btnMoveActivity.setOnClickListener(this)
        val btnMovieActivity: Button = findViewById(R.id.btn2)
        btnMovieActivity.setOnClickListener(this)
        val btnSoftActivity: Button = findViewById(R.id.btn3)
        btnSoftActivity.setOnClickListener(this)
        val btnCartActivity: Button = findViewById(R.id.btn4)
        btnCartActivity.setOnClickListener(this)
    }


    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
            imageView.setImageResource(sampleImages[position])
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> {
                val musikIntent = Intent(this@MainActivity, Musik::class.java)
                startActivity(musikIntent)
            }
            R.id.btn2 -> {
                val movieIntent = Intent(this@MainActivity, Movie::class.java)
                startActivity(movieIntent)
            }
            R.id.btn3 -> {
                val movieIntent = Intent(this@MainActivity, Software::class.java)
                startActivity(movieIntent)
            }
            R.id.btn4 -> {
                val movieIntent = Intent(this@MainActivity, Cart::class.java)
                startActivity(movieIntent)
            }
            }

        }

}
