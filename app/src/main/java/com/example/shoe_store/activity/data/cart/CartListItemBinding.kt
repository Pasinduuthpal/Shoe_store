package com.example.shoe_store.activity.data.cart

class CartListItemBinding(
    private val binding: ItemCartBinding,
    private val onRemoveClickListener: (CartItem) -> Unit,
    private val onQuantityClickListener: (CartItem) -> Unit
) {
    fun bind(cartItem: CartItem) {
        binding.productName.text = cartItem.product.name
        binding.productPrice.text = cartItem.product.price
        binding.productQuantity.text = cartItem.quantity.toString()

        binding.removeButton.setOnClickListener { onRemoveClickListener(cartItem) }
        binding.quantityButton.setOnClickListener { onQuantityClickListener(cartItem) }
    }
}
