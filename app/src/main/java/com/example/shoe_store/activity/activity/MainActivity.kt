package com.example.shoe_store.activity.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.shoe_store.R
import com.example.shoe_store.activity.data.Product.Product
import com.example.shoe_store.activity.data.Product.ProductService
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main + Job())
    private val searchQuery = MutableLiveData<String>()

    private val productService: ProductService = Retrofit.Builder()
        .baseUrl("http://167.71.188.241/hnba-dat-backend/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("http://167.71.188.241/hnba-dat-backend/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ProductService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val products = service.getProducts()
            withContext(Dispatchers.Main) {
                // Update the UI with the products data
                updateUiWithProducts(products)
            }
        }

    }

    @SuppressLint("ShowToast")
    private fun fetchProducts() {
        coroutineScope.launch {
            try {
                val products = productService.getProducts()
                updateUiWithProducts(products)
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG);
            }
        }
    }

    private fun updateUiWithProducts(products: List<Product>) {
        binding.progressBar.visibility = View.GONE
        binding.productsRecyclerView.visibility = View.VISIBLE

        productAdapter.setProducts(products)
        productAdapter.setOnItemClickListener { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra(ProductDetailActivity.EXTRA_PRODUCT_ID, product.id)
            startActivity(intent)
        }
    }
}