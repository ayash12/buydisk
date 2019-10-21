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

class ListMusikAdapter (val listmusik : ArrayList<ModelMusik>) :
    RecyclerView.Adapter<ListMusikAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: ListMusikAdapter.OnItemClickCallback


    fun setOnItemClickCallback(onItemClickCallback: ListMusikAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMusikAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.listmusik, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listmusik.size
}

    override fun onBindViewHolder(holder: ListMusikAdapter.ListViewHolder, position: Int) {
        val lm = listmusik[position]

        Glide.with(holder.itemView.context)
            .load(lm.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvAlbum.text = lm.album
        holder.tvArtis.text = lm.artist
        holder.tvPrice.text = "Rp."+lm.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listmusik[holder.adapterPosition]) }
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvAlbum: TextView = itemView.findViewById(R.id.tv_item_album)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
        var tvArtis: TextView = itemView.findViewById(R.id.tv_item_artis)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: ModelMusik)
    }

}