package com.example.shoe_store.activity.data.Product

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoe_store.R

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val productName: TextView = itemView.findViewById(R.id.product_name)
    private val productPrice: TextView = itemView.findViewById(R.id.product_price)
    private val productImage: ImageView = itemView.findViewById(R.id.product_image)

    fun bind(product: Product) {
        productName.text = product.name
        productPrice.text = itemView.context.getString(R.string.price_format, product.price)
        Glide.with(itemView.context)
            .load(product.image)
            .into(productImage)
    }
}
