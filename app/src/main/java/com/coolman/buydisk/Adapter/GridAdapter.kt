package com.coolman.buydisk.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.R

class GridAdapter (var gridmusik: ArrayList<ModelMusik>): RecyclerView.Adapter<GridAdapter.GridViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapter.GridViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.gridmusik, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridmusik.size
    }

    override fun onBindViewHolder(holder: GridAdapter.GridViewHolder, position: Int) {
        val gm = gridmusik[position]

        Glide.with(holder.itemView.context)
            .load(gridmusik[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvAlbum.text = gm.album
        holder.tvArtis.text = gm.artist
        holder.tvPrice.text = "Rp."+gm.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(gridmusik[holder.adapterPosition]) }
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvAlbum: TextView = itemView.findViewById(R.id.tv_item_album)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var tvArtis: TextView = itemView.findViewById(R.id.tv_item_artis)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelMusik)
    }
}