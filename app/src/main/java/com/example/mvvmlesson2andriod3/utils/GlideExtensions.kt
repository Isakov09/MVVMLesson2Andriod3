package com.example.mvvmlesson2andriod3.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmlesson2andriod3.R

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        // до загруски стоит
        // .placeholder(R.drawable.fallback_image)

        //когда не загрузился изображение будет показывать это
        .fallback(R.drawable.fallback)

        // это если призошол ашибка при загрузки
        //.error(R.drawable.img)
        .into(this)
}