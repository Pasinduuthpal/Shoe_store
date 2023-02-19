# Shoe_store

This is an Android app that displays a list of products fetched from an API and allows the user to view product details and add products to a cart.

# Features

Fetches products from API using Retrofit
Displays a list of products with their names, prices, and images
Allows the user to click on a product to view its details, including its name, price, image, and description
Allows the user to add products to a cart, which is stored in a local SQLite database using Room
Displays a cart total and list of products in the cart
Uses the Model-View-ViewModel (MVVM) architecture
Handles errors and displays appropriate error messages to the user
Includes unit tests for the ViewModel

# Libraries Used

Retrofit: For making API calls
Glide: For loading images from the web
Room: For local storage of cart items
ViewModel and LiveData: For implementing the MVVM architecture
Espresso and Mockito: For unit testing

# Installation

Clone this repository and import into Android Studio. Build and run the app.

Copy code
git clone https://github.com/your-username/ecommerce-android-app.git

# API

This app uses the following API:
http://167.71.188.241/hnba-dat-backend/api/v1/
Endpoints
GET /products: Get a list of products

# License

This project is licensed under the MIT License. See the LICENSE file for details.
