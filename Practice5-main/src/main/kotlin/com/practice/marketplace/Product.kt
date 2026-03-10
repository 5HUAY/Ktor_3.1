package com.practice.marketplace

/**
 * A data class representing a product in the marketplace.
 * It includes an ID, name, and price.
 *
 * @property id The unique identifier for the product.
 * @property name The name of the product.
 * @property price The price of the product.
 */
data class Product(val id: Int, val name: String, val price: Double)
