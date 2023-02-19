package com.example.shoe_store.activity.data.cart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.shoe_store.activity.data.Product.Product
import com.example.shoe_store.activity.data.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CartRepository
    val cartItems: LiveData<List<CartItem>>

    init {
        val cartDao = AppDatabase.getInstance(application).cartDao()
        repository = CartRepository(cartDao)
        cartItems = repository.cartItems
    }

    fun addCartItem(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            val cartItem = repository.getCartItemByProductId(product.id)
            if (cartItem != null) {
                cartItem.quantity++
                repository.updateCartItem(cartItem)
            } else {
                val newCartItem = CartItem(product, 1)
                repository.addCartItem(newCartItem)
            }
        }
    }

    fun removeCartItem(cartItem: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            if (cartItem.quantity > 1) {
                cartItem.quantity--
                repository.updateCartItem(cartItem)
            } else {
                repository.deleteCartItem(cartItem)
            }
        }
    }

    fun clearCart() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.clearCart()
        }
    }
}
