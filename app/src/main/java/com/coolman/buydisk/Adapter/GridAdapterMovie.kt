package com.coolman.buydisk.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.coolman.buydisk.Model.ModelMovie
import com.coolman.buydisk.Model.ModelMusik
import com.coolman.buydisk.R

class GridAdapterMovie (var gridmovie: ArrayList<ModelMovie>): RecyclerView.Adapter<GridAdapterMovie.GridViewHolder>(){

    private lateinit var onItemClickCallback: GridAdapterMovie.OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: GridAdapterMovie.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapterMovie.GridViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.gridmovie, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridmovie.size
    }

    override fun onBindViewHolder(holder: GridAdapterMovie.GridViewHolder, position: Int) {
        val gm = gridmovie[position]

        Glide.with(holder.itemView.context)
            .load(gridmovie[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvAlbum.text = gm.movie
        holder.tvPrice.text = "Rp."+gm.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(gridmovie[holder.adapterPosition]) }
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvAlbum: TextView = itemView.findViewById(R.id.tv_item_movie)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelMovie)
    }
}