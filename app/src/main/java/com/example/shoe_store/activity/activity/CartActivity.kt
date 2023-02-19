package com.example.shoe_store.activity.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.shoe_store.R

class CartActivity : AppCompatActivity() {

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var totalTextView: TextView

    private lateinit var cartAdapter: CartAdapter

    private val cartViewModel: CartViewModel by viewModels {
        CartViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        cartRecyclerView = findViewById(R.id.cartRecyclerView)
        totalTextView = findViewById(R.id.totalTextView)

        cartAdapter = CartAdapter { product -> removeFromCart(product) }
        cartRecyclerView.adapter = cartAdapter

        cartViewModel.cartItems.observe(this, { cartItems ->
            cartAdapter.submitList(cartItems)

            val total = cartItems.fold(0.0) { acc, cartItem ->
                acc + cartItem.product.price * cartItem.quantity
            }
            totalTextView.text = "Total: $${"%.2f".format(total)}"
        })
    }

    private fun removeFromCart(product: Product) {
        cartViewModel.removeFromCart(product)
    }
}
