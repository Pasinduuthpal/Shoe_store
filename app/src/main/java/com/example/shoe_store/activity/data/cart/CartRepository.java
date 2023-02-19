package com.example.shoe_store.activity.data.cart;

import androidx.lifecycle.LiveData;

import java.util.List;

import kotlin.jvm.Volatile;

class  CartRepository(val cartDao: CartDao) {

    fun getCartItems(): LiveData<List<CartItem>> {
        return cartDao.getAll()
    }

    suspend fun insertCartItem(cartItem: CartItem) {
        cartDao.insert(cartItem)
    }

    suspend fun deleteCartItem(cartItem: CartItem) {
        cartDao.delete(cartItem)
    }

    suspend fun deleteAllCartItems() {
        cartDao.deleteAll()
    }

    companion object {
        @Volatile
        private var instance: CartRepository? = null

        fun getInstance(cartDao: CartDao): CartRepository {
            return instance ?: synchronized(this) {
                instance ?: CartRepository(cartDao).also { instance = it }
            }
        }
    }
}
}
