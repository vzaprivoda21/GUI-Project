package homework1;

import java.util.Arrays;

public class Items {
	private String description = "0";
	private double price =0.0;
	private String quantity ="0";

	
	public Items(){
		
	}
	
	public Items(String description, double price, String quantity) {
		this.description=description;
		this.price=price;
		this.quantity=quantity;
	}
	
	


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String toString() {
		return "Description = " + description + ", Price = " + price + ", Quantity = " + quantity + "\n";
	}
	
	
}
