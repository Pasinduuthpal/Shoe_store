package com.example.shoe_store.activity.data.Product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoe_store.R

class ProductAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner  class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val productNameTextView: TextView = itemView.findViewById(R.id.productNameTextView)
            val productDescriptionTextView: TextView = itemView.findViewById(R.id.productDescriptionTextView)
            val productPriceTextView: TextView = itemView.findViewById(R.id.productPriceTextView)
            val productImageView: ImageView = itemView.findViewById(R.id.productImageView)
            productNameTextView.text = product.name
            productDescriptionTextView.text = product.description
            productPriceTextView.text = "$${product.price}"
            Glide.with(itemView.context).load(product.image).into(productImageView)
        }
    }
}


