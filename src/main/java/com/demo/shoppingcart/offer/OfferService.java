package com.demo.shoppingcart.offer;

import com.demo.shoppingcart.domain.Product;

public class OfferService {

	public static Offer getApplicableOffer(Product product) {
		Offer offer = null;
		
		switch(product.getProductId()) {
			case "DOVE":
				offer = new DiscountOffer();
				break;
			default : 
				offer = null;
		}
		
		return offer;
	}
	
	
}
