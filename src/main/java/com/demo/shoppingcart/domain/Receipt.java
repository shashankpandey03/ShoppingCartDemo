package com.demo.shoppingcart.domain;

import java.util.ArrayList;
import java.util.List;

public class Receipt {

	List<CartItem> cartItemList = null;

	public List<CartItem> getItemList() {
		return cartItemList;
	}
	
	public void printReceipt() {
		
	}

	public void addItem(CartItem item) {
		if(cartItemList == null) {
			cartItemList = new ArrayList<CartItem>();
		}
		cartItemList.add(item);
	}
	
}
