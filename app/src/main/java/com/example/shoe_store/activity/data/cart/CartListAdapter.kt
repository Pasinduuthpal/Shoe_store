package com.example.shoe_store.activity.data.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoe_store.R

class CartListAdapter(
    private val context: Context,
    private var cartItems: List<CartItem>
) : RecyclerView.Adapter<CartListAdapter.CartViewHolder>() {

    inner class CartViewHolder(private val binding: CartListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: CartItem) {
            binding.productName.text = cartItem.product.name
            binding.productPrice.text = context.getString(R.string.product_price, cartItem.product.price)
            binding.productQuantity.text = context.getString(R.string.product_quantity, cartItem.quantity)
            binding.productTotalPrice.text = context.getString(R.string.product_total_price, cartItem.product.price * cartItem.quantity)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position])
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun updateData(cartItems: List<CartItem>) {
        this.cartItems = cartItems
        notifyDataSetChanged()
    }
}
