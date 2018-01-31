package com.demo.shoppingcart.cart;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.demo.shoppingcart.domain.Product;
import com.demo.shoppingcart.domain.Receipt;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShoppingCartAddProduct() {
		ShoppingCart cart = new ShoppingCart();
		Product product = createProduct();
		
		cart.addProduct(product,5);
		
		assertEquals(5, cart.getTotalCartSize());
		assertEquals(150, cart.getTotalPrice());
		assertEquals(1, cart.getCartItems().size());
		
		Product p =cart.getCartItems().get(0).getProduct();
		assertTrue("DOVE".equals(p.getProductId()));
		assertTrue("DOVE".equals(p.getProductName()));
		assertTrue(30 == p.getPrice());
	}
	
	@Test
	public void testCheckout() {
		ShoppingCart cart = new ShoppingCart();
		Product product = createProduct();
		
		cart.addProduct(product,5);
		
		Receipt receipt = cart.checkout();
		assertNotNull(receipt);
		assertTrue(1 == receipt.getItemList().size());
	}
	
	@Test
	public void testCheckoutWithDiscountOfferOnProductId() {
		ShoppingCart cart = new ShoppingCart();
		Product product = createProduct();
		
		cart.addProduct(product,3);
		
		Receipt receipt = cart.checkout();
		assertNotNull(receipt);
		assertTrue(60 == cart.getTotalPrice());
		assertTrue(1 == receipt.getItemList().size());
	}

	private Product createProduct() {
		Product product = new Product();
		product.setProductId("DOVE");
		product.setProductName("DOVE");
		product.setPrice(30);
		return product;
	}

}
