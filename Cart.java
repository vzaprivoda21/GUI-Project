package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Cart {
	
	Items items = new Items();

	ArrayList<Items> itemsInCart = new ArrayList<Items>();
	
	
	
	public Cart() {
		
	}
	
	public void addItem(Items items) {
		

		
		itemsInCart.add(items);
		System.out.println("Item added");
	}
	
	public String toString() {
		return Arrays.toString(itemsInCart.toArray()) ;
	}
	

	
	
	
}
