package com.demo.shoppingcart.cart;

import java.util.ArrayList;
import java.util.List;

import com.demo.shoppingcart.domain.CartItem;
import com.demo.shoppingcart.domain.Product;
import com.demo.shoppingcart.domain.Receipt;
import com.demo.shoppingcart.offer.Offer;
import com.demo.shoppingcart.offer.OfferService;

public class ShoppingCart {

	private List<CartItem> cartItemList = new ArrayList<CartItem>();
	private int totalCartPrice = -1;
	
	public void addProduct(Product product, int quantity) {
		cartItemList.add(new CartItem(product, quantity));
	}

	public int getTotalCartSize() {
		int totalSize = 0;
		for(CartItem item : cartItemList) {
			totalSize = totalSize + item.getQuantity();
		}
		return totalSize;
	}

	public int getTotalPrice() {
		if(totalCartPrice == -1) {
			totalCartPrice = 0;
			for(CartItem item : cartItemList) {
				totalCartPrice = totalCartPrice + item.getTotalPrice();
			}
		}
		return totalCartPrice;
	}

	public List<CartItem> getCartItems() {
		return cartItemList;
	}

	public Receipt checkout() {
		totalCartPrice = 0;
		Receipt receipt = new Receipt();
		for(CartItem item : cartItemList) {
			
			item.setTotalPrice(item.getQuantity() * item.getProduct().getPrice());
			
			Offer eligibleOffer = OfferService.getApplicableOffer(item.getProduct());
			if(eligibleOffer != null) {
				eligibleOffer.applyOffer(item);
				totalCartPrice = totalCartPrice + item.getOfferPrice();
			} else {
				totalCartPrice = totalCartPrice + item.getTotalPrice();
			}
			receipt.addItem(item);
			
		}
		return receipt;
	}
}
