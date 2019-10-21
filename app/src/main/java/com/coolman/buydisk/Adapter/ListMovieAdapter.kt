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

class ListMovieAdapter (val listmovie : ArrayList<ModelMovie>) :
    RecyclerView.Adapter<ListMovieAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: ListMovieAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: ListMovieAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.listmovie, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listmovie.size
    }

    override fun onBindViewHolder(holder: ListMovieAdapter.ListViewHolder, position: Int) {
        val lm = listmovie[position]

        Glide.with(holder.itemView.context)
            .load(lm.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvAlbum.text = lm.movie
        holder.tvPrice.text = "Rp."+lm.price
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listmovie[holder.adapterPosition]) }
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvAlbum: TextView = itemView.findViewById(R.id.tv_item_movie)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ModelMovie)
    }
}