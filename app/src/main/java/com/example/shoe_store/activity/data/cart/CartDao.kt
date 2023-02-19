package com.example.shoe_store.activity.data.cart

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartItem: CartItem)

    @Update
    suspend fun update(cartItem: CartItem)

    @Delete
    suspend fun delete(cartItem: CartItem)

    @Query("DELETE FROM cart_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM cart_table")
    fun getAllCartItems(): LiveData<List<CartItem>>

    @Query("SELECT * FROM cart_table WHERE id = :cartItemId")
    fun getCartItemById(cartItemId: Int): LiveData<CartItem>

    @Query("SELECT SUM(price * quantity) FROM cart_table")
    fun getTotalPrice(): LiveData<Double>
}
