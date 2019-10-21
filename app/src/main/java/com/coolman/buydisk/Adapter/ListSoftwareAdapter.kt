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
import com.coolman.buydisk.Model.ModelSoft
import com.coolman.buydisk.R

class ListSoftwareAdapter (val listsoft : ArrayList<ModelSoft>) :
    RecyclerView.Adapter<ListSoftwareAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: ListSoftwareAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: ListSoftwareAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSoftwareAdapter.ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.listsoft, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listsoft.size
    }

    override fun onBindViewHolder(holder: ListSoftwareAdapter.ListViewHolder, position: Int) {
        val ls = listsoft[position]

        Glide.with(holder.itemView.context)
            .load(ls.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvSoft.text = ls.soft
        holder.tvPrice.text = "Rp."+ls.price
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listsoft[holder.adapterPosition]) }
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvSoft: TextView = itemView.findViewById(R.id.tv_item_soft)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: ModelSoft)
    }
}