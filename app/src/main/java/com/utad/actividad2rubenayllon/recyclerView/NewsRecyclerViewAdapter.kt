package com.utad.actividad2rubenayllon.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.actividad2rubenayllon.databinding.ItemNewsBinding

class NewsRecyclerViewAdapter(
    private val newsList: List<New>,
    private val onClickAction: (New) -> Unit

): RecyclerView.Adapter<NewsRecyclerViewAdapter.AllNewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNewsBinding.inflate(inflater, parent, false)
        return AllNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllNewsViewHolder, position: Int) {
        val new = newsList[position]
        Glide.with(holder.itemView.context).load(new.image).into(holder.binding.ivItemNews)
        holder.binding.tvItemNews.text = new.title

        holder.binding.root.setOnClickListener{
            onClickAction(new)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class AllNewsViewHolder(val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

}