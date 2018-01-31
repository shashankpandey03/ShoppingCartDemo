package com.demo.shoppingcart.offer;

import com.demo.shoppingcart.domain.CartItem;

public class DiscountOffer implements Offer {

	@Override
	public void applyOffer(CartItem item) {
		System.out.println("Applying discount");
		item.setOfferPrice(item.getTotalPrice()-30);
	}

}
