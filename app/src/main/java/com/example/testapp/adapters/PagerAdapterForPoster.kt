package com.example.testapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.PagerItemBinding


class PagerAdapterForPoster() :
    RecyclerView.Adapter<PagerAdapterForPoster.YourViewHolder>() {

    private var imageResources: List<Int> = emptyList()

    class YourViewHolder(private val binding: PagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResources: Int) {
          binding.imageView.setImageResource(imageResources)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourViewHolder {
        val binding = PagerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return YourViewHolder(binding)
    }

    fun setImageList(list: List<Int>) {
        imageResources = list
    }

    override fun onBindViewHolder(holder: YourViewHolder, position: Int) {
        val item = imageResources[position]
        holder.bind(item)
    }

    override fun getItemCount() = imageResources.size
}
