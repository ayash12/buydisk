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
import com.coolman.buydisk.Model.ModelSoft
import com.coolman.buydisk.R

class GridAdapterSoftware (var gridsoft: ArrayList<ModelSoft>): RecyclerView.Adapter<GridAdapterSoftware.GridViewHolder>(){

    private lateinit var onItemClickCallback: GridAdapterSoftware.OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: GridAdapterSoftware.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapterSoftware.GridViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.softgrid, parent, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gridsoft.size
    }

    override fun onBindViewHolder(holder: GridAdapterSoftware.GridViewHolder, position: Int) {
        val gs = gridsoft[position]

        Glide.with(holder.itemView.context)
            .load(gridsoft[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvSoft.text = gs.soft
        holder.tvPrice.text = "Rp."+gs.price
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(gridsoft[holder.adapterPosition]) }
    }
    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvSoft: TextView = itemView.findViewById(R.id.tv_item_soft)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)

    }
    interface OnItemClickCallback {
        fun onItemClicked(data: ModelSoft)
    }


}