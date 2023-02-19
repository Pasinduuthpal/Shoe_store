package com.example.shoe_store.activity.data.cart

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.shoe_store.activity.data.Product.Product

@Entity(tableName = "cart_items")
data class CartItem(
    @Embedded val product: Product,
    var quantity: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
