package com.sample.redditmini.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("count")
fun setCount(textView: TextView, count: Int) {
    textView.text = if (count >= 1000 || count <= -1000) {
        "${String.format("%.1f", count / 1000f)}K"
    } else {
        count.toString()
    }
}