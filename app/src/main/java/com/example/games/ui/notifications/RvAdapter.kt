package com.example.games.ui.notifications

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.games.databinding.RvItemBinding


class RvAdapter : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    private val items = mutableListOf<RvItems>()

    inner class RvViewHolder(private val binding: RvItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item: RvItems) {
            binding.imageView.setImageResource(item.images)
            binding.text.text = item.name
            binding.text2.text = item.description
            binding.text3.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun setUpItems(rvItems: List<RvItems>){
        items.clear()
        items.addAll(rvItems)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val item = items[position]
        holder.bindItems(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
