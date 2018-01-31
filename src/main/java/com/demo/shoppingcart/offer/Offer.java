package com.demo.shoppingcart.offer;

import com.demo.shoppingcart.domain.CartItem;

public interface Offer {
	
	public void applyOffer(CartItem item);
}
