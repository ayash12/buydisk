package com.coolman.buydisk.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.coolman.buydisk.Model.ModelCart
import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.R

class CartAdapter (var listcard: ArrayList<ModelCart>): RecyclerView.Adapter<CartAdapter.ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.cart, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listcard.size
    }

    override fun onBindViewHolder(holder: CartAdapter.ListViewHolder, position: Int) {
        val lc = listcard[position]

        Glide.with(holder.itemView.context)
            .load(lc.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvProduk.text = lc.produk
        holder.tvPrice.text = lc.price
        holder.tvJumlah.text = lc.jumlah


    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvProduk: TextView = itemView.findViewById(R.id.tv_item_produk)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var tvJumlah: TextView = itemView.findViewById(R.id.tvjm)

    }
}