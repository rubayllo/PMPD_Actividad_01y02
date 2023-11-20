package com.utad.actividad2rubenayllon.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.utad.actividad2rubenayllon.databinding.ItemNewsBinding

class NewsListAdapter(
    private val onClickAction: (New) -> Unit

): ListAdapter<New, NewsListAdapter.ListNewsViewHolder> (NewItemCallBack){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNewsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemNewsBinding = ItemNewsBinding.inflate(inflater, parent, false)
        return ListNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListNewsViewHolder, position: Int) {
        val new: New = getItem(position)

        Glide.with(holder.itemView.context).load(new.image).into(holder.binding.ivItemNews)
        holder.binding.tvItemNews.text = new.title
        holder.binding.root.setOnClickListener{
            onClickAction(new)
        }
    }

    inner class ListNewsViewHolder(val binding: ItemNewsBinding): RecyclerView.ViewHolder(binding.root)

}

object NewItemCallBack: DiffUtil.ItemCallback<New>() {
    override fun areItemsTheSame(oldItem: New, newItem: New): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: New, newItem: New): Boolean {
        return oldItem == newItem
    }

}
