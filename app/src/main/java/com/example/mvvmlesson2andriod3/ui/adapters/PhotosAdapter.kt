package com.example.mvvmlesson2andriod3.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmlesson2andriod3.R
import com.example.mvvmlesson2andriod3.databinding.ItemListBinding
import com.example.mvvmlesson2andriod3.models.Photo
import com.example.mvvmlesson2andriod3.utils.loadImage

class PhotosAdapter(private val onItemClick: (photo: Photo) -> Unit) : ListAdapter<Photo, PhotosAdapter.PhotoViewHolder>(diffUtil) {

    inner class PhotoViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(getItem(adapterPosition))
            }
        }

        fun bind(photo: Photo) = with(binding){
            ivPhoto.contentDescription = root.context.getString(R.string.photo, photo.title)
            val imageUrl = "https://farm66.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"
            ivPhoto.loadImage(imageUrl)
            tvTitle.text = photo.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    //это дифутил это сделан через обжект
    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
                return oldItem == newItem
            }

        }
    }
}