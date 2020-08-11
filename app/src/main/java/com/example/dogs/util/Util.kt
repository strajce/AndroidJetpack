package com.example.dogs.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.dogs.R

fun getProgressDrawer(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(url: String?, circularProgressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(circularProgressDrawable)
        .error(R.mipmap.ic_dog_app_icon)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}