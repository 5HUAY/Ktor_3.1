package com.practice.marketplace

/**
 * Abstract class representing an action in the marketplace.
 * It defines a method to execute the action on a cart, optionally with a product.
 */
abstract class MarketplaceAction {
    abstract fun execute(cart: Cart, product: Product? = null)
}

/**
 * Concrete action to add a product to the cart.
 */
class AddProductAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        if (product != null) {
            cart.addProduct(product)
            println("Added ${product.name} to cart.")
        } else {
            println("Product not found or invalid.")
        }
    }
}

/**
 * Concrete action to remove a product from the cart.
 */
class RemoveProductAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        if (product != null) {
            cart.removeProduct(product)
            println("Removed ${product.name} from cart.")
        } else {
            println("Product not found in command.")
        }
    }
}

/**
 * Concrete action to view the cart.
 */
class ViewCartAction : MarketplaceAction() {
    override fun execute(cart: Cart, product: Product?) {
        cart.printCart()
    }
}