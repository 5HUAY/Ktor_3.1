package com.practice.marketplace

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CartTest {

    @Test
    fun `Verify product creation`() {
        val book = Product(1, "Book", 9.99)
        assertEquals("Book", book.name)
        assertEquals(9.99, book.price)
    }

    @Test
    fun `Verify adding product to cart`() {
        val cart = Cart()
        val book = Product(1, "Book", 9.99)
        cart.addProduct(book)

        assertTrue(cart.products.contains(book))
        assertEquals(1, cart.products.size)
    }

    @Test
    fun `Verify removing product from cart`() {
        val cart = Cart()
        val laptop = Product(2, "Laptop", 799.0)
        cart.addProduct(laptop)
        cart.removeProduct(laptop)

        assertTrue(cart.products.isEmpty())
    }

    @Test
    fun `Verify total price calculation`() {
        val cart = Cart()
        val book = Product(1, "Book", 10.0)
        val laptop = Product(2, "Laptop", 90.0)
        cart.addProduct(book)
        cart.addProduct(laptop)

        assertEquals(100.0, cart.totalPrice())
    }

    @Test
    fun `Verify operator overloading works`() {
        val cart = Cart()
        val phone = Product(3, "Phone", 499.0)

        cart + phone
        assertTrue(cart.products.contains(phone))

        cart - phone
        assertTrue(cart.products.isEmpty())
    }

    @Test
    fun `Verify marketplace actions`() {
        val cart = Cart()
        val book = Product(1, "Book", 9.99)

        AddProductAction().execute(cart, book)
        assertTrue(cart.products.contains(book))

        RemoveProductAction().execute(cart, book)
        assertTrue(cart.products.isEmpty())
    }

    @Test
    fun `Verify empty cart total is zero`() {
        val cart = Cart()
        assertEquals(0.0, cart.totalPrice())
    }
}
