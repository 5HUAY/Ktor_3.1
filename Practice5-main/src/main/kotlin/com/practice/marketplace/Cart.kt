package com.practice.marketplace

/**
 * A simple shopping cart implementation in Kotlin.
 * It supports adding and removing products, calculating total price,
 * and printing the cart contents in a formatted table.
 *
 */
class Cart {
    val products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(product: Product) {
        products.remove(product)
    }

    fun totalPrice(): Double {
        return products.sumOf { it.price }
    }

    // Operator overloading
    operator fun plus(product: Product): Cart {
        addProduct(product)
        return this
    }

    operator fun minus(product: Product): Cart {
        removeProduct(product)
        return this
    }

    fun printCart() {
        if (products.isEmpty()) {
            println("Cart is empty.")
            return
        }

        println("+----+-----------+--------+")
        println("| ID | Product   | Price  |")
        println("+----+-----------+--------+")
        for (p in products) {
            println("| %-2d | %-9s | $%-5.2f |".format(p.id, p.name, p.price))
        }
        println("+----+-----------+--------+")
        println("Total: $${"%.2f".format(totalPrice())}")
    }
}
