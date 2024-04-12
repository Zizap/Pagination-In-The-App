package com.example.testapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.testapp.R
import com.example.testapp.databinding.MovieItemBinding
import com.example.testapp.models.MovieApp


class MovieAdapter(private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.ProductsHolder>() {

    private var movies = ArrayList<MovieApp>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsHolder {
        val binding: MovieItemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ProductsHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ProductsHolder, position: Int) {
        holder.bind(
            movies[position]
        )
    }

    fun setList(list: List<MovieApp>) {
        movies.clear()
        movies.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProductsHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            movie: MovieApp,
        ) {
            binding.nameMovie.text = movie.name

            var requestOptions = RequestOptions()

            requestOptions = requestOptions.transforms(FitCenter(), RoundedCorners(16))
            Glide.with(context).load(movie.poster.previewUrl).placeholder(R.drawable.no_photo)
                .apply(requestOptions)
                .skipMemoryCache(true)
                .into(binding.poster)

            binding.rating.text = movie.rating.kp.toString()

            binding.description.text = movie.description

            binding.years.text = movie.year.toString()

            binding.count.text = String.format("(%d)", movie.votes.kp)

            binding.genres.text = movie.genres.joinToString { it.name }

            binding.containerItem.setOnClickListener {
                if (binding.description.maxLines == 5) {
                    binding.description.maxLines = Integer.MAX_VALUE
                } else {
                    binding.description.maxLines = 5
                }
            }
        }
    }
}