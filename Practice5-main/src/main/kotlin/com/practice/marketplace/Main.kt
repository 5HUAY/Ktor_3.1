package com.practice.marketplace

fun main() {
    // Define test products
    val products = listOf(
        Product(1, "Laptop", 999.99),
        Product(2, "Mouse", 19.99),
        Product(3, "Keyboard", 49.99),
        Product(4, "Monitor", 199.99),
        Product(5, "Headset", 79.99)
    )

    val cart = Cart()
    val addAction = AddProductAction()
    val removeAction = RemoveProductAction()
    val viewAction = ViewCartAction()

    while (true) {
        println("\n=== Marketplace ===")
        println("Available Products:")
        println("+----+-----------+--------+")
        println("| ID | Product   | Price  |")
        println("+----+-----------+--------+")
        for (p in products) {
            println("| %-2d | %-9s | $%-5.2f |".format(p.id, p.name, p.price))
        }
        println("+----+-----------+--------+")
        println("Current Cart Total: $${"%.2f".format(cart.totalPrice())}")
        println("Choose action: add <id>, remove <id>, view, exit")

        val input = readLine()?.trim() ?: continue
        if (input == "exit") break

        when {
            input.startsWith("add") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                val product = products.find { it.id == id }
                // Execute add action
                if (product != null) {
                    addAction.execute(cart, product)
                } else {
                    println("Product with ID $id not found.")
                }
            }

            input.startsWith("remove") -> {
                val id = input.split(" ").getOrNull(1)?.toIntOrNull()
                // We need to find the product in the cart to remove it (or by generic definition)
                // For simplicity, let's match by ID from the catalog logic
                val product = products.find { it.id == id }
                // Execute remove action
                if (product != null) {
                    removeAction.execute(cart, product)
                } else {
                    println("Invalid Product ID.")
                }
            }

            input == "view" -> {
                // Execute view action
                viewAction.execute(cart)
            }
            else -> println("Invalid command.")
        }
    }
}