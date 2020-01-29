package homework1;

import java.awt.ItemSelectable;
import java.util.Arrays;
import java.util.Objects;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
	public void start(Stage primaryStage) {
		
		Items items = new Items();
		Items items2 = new Items();
		Items items3 = new Items();
		
		
		Cart cart = new Cart();
		
		String price = "0";
		

		Label label = new Label("$200");
		Label label2 = new Label("$400");
		Label label3 = new Label("$100");
		Image img = new Image("https://images.costco-static.com/ImageDelivery/imageService?profileId=12026540&itemId=1299984-847&recipeName=680");
		ImageView imgview = new ImageView(img);
		Image img1 = new Image("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MWUQ2_VW_34FR+watch-44-alum-silver-nc-5s_VW_34FR_WF_CO?wid=750&hei=712&fmt=p-jpg&qlt=80&op_usm=0.5,0.5&.v=1572037927131,1569365637670");
		ImageView imgview2 = new ImageView(img1);
		Image img3 = new Image("https://slimages.macysassets.com/is/image/MCY/products/9/optimized/793049_fpx.tif?op_sharpen=1&wid=500&hei=613&fit=fit,1&$filtersm$");
		ImageView imgview3 = new ImageView(img3);
		Button addToCart = new Button("Add To cart");
		Button checkout = new Button("Checkout");
		Text message = new Text("Welcome");
		Text quantity = new Text("Quantity");
		TextField input = new TextField();
		price = input.getText();
		TextField input2 = new TextField();
		TextField input3 = new TextField();
		AnchorPane window = new AnchorPane();
		Button exit = new Button("Exit");
		
		items.setDescription("Cool Watch");
		items.setPrice(100.0);
		items.setQuantity("0");
		
		items2.setDescription("Apple Watch");
		items2.setPrice(400.0);
		items2.setQuantity("0");
		
		items3.setDescription("Sylvania");
		items3.setPrice(200.0);
		items3.setQuantity("0");
		
		window.setStyle("-fx-background-color: #FFFFFF;");
		input2.setPrefWidth(30.0);
		input3.setPrefWidth(30.0);
		

		
		
		addToCart.setOnAction((new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(!input.getText().isEmpty() || !input.getText().equalsIgnoreCase("0")) {
					System.out.println(input.getText());
					items.setQuantity(input.getText());
					if(input.getText().isEmpty()) {
						items.setQuantity("0");}
					else {
						cart.addItem(items);}
					cart.toString();
					addToCart.setDisable(true);
					}
				else {
					System.out.println("Please type an amount");
				}
				
				if(!input2.getText().isEmpty() || !input2.getText().equalsIgnoreCase("0")) {
					System.out.println(input2.getText());
					items2.setQuantity(input2.getText());
					if(input2.getText().isEmpty()) {
						items2.setQuantity("0");}
					else {
						cart.addItem(items2);}
					

					cart.toString();
					addToCart.setDisable(true);
					
				}
				else {
					System.out.println("Please type an amount");
				}
				
				if(!input3.getText().isEmpty() || !input3.getText().equalsIgnoreCase("0")) {
					System.out.println(input3.getText());
					items3.setQuantity(input3.getText());
					if(input3.getText().isEmpty()) {
						items3.setQuantity("0");}
					else {
					cart.addItem(items3);}
					
					cart.toString();
					addToCart.setDisable(true);
					}
				else if (input3.getText().isEmpty()) {
					items3.setQuantity("0");
				}
				
				
				
			}
			
			
	}));
		
		exit.setOnAction((new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
			
		}));
		checkout.setOnAction((new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
				String itemsInTheCart;
				itemsInTheCart = cart.itemsInCart.toString();
				System.out.println(itemsInTheCart);
				Label label = new Label(itemsInTheCart);
				Stage second = new Stage();
				AnchorPane window2 = new AnchorPane();
				window2.setMinSize(400.0, 400.0);
				System.out.println(message);
				
			
				
				
				Double taxes = Double.parseDouble(items.getQuantity())*items.getPrice()*0.06 + Double.parseDouble(items2.getQuantity())*items2.getPrice()*0.06 + Double.parseDouble(items3.getQuantity())*items3.getPrice()*0.06;
				Double totalPrice = taxes + items.getPrice()*Double.parseDouble(items.getQuantity()) + items2.getPrice()*Double.parseDouble(items2.getQuantity())+ items3.getPrice()*Double.parseDouble(items3.getQuantity());
				Label tax = new Label("Taxes = " + taxes);
				Label total = new Label("Total = "+ totalPrice );
				

				
				Button exit = new Button("Exit");
				exit.setOnAction((new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						System.exit(0);
					}}));
				AnchorPane.setBottomAnchor(exit, 20.0);
				AnchorPane.setLeftAnchor(exit, 20.0);
				AnchorPane.setRightAnchor(tax, 70.0);
				AnchorPane.setBottomAnchor(tax, 60.0);
				AnchorPane.setRightAnchor(total, 70.0);
				AnchorPane.setBottomAnchor(total, 40.0);
				
				
				window2.getChildren().add(exit);
				window2.getChildren().add(label);
				window2.getChildren().add(tax);
				window2.getChildren().add(total);
				
				
				
				Scene scene = new Scene(window2);
				second.setTitle("Cart");
				second.setScene(scene);
				second.show();
			
		}}));
		
		input.setPrefWidth(30.0);
		imgview.setFitHeight(100.0);
		imgview.setFitWidth(100.0);
		imgview2.setFitHeight(100.0);
		imgview2.setFitWidth(100.0);
		imgview3.setFitHeight(100.0);
		imgview3.setFitWidth(100.0);
		
		AnchorPane.setBottomAnchor(imgview2, 100.0);
		AnchorPane.setLeftAnchor(imgview2, 130.0);
		AnchorPane.setBottomAnchor(imgview3, 100.0);
		AnchorPane.setLeftAnchor(imgview3, 270.0);
		AnchorPane.setBottomAnchor(imgview, 100.0);
		AnchorPane.setLeftAnchor(imgview, 20.0);
		AnchorPane.setBottomAnchor(exit, 20.0);
		AnchorPane.setLeftAnchor(exit, 20.0);
		AnchorPane.setBottomAnchor(addToCart, 20.0);
		AnchorPane.setRightAnchor(addToCart, 20.0);
		AnchorPane.setBottomAnchor(checkout, 20.0);
		AnchorPane.setRightAnchor(checkout, 120.0);
		AnchorPane.setBottomAnchor(input, 60.0);
		AnchorPane.setLeftAnchor(input, 50.0);
		AnchorPane.setBottomAnchor(label, 200.0);
		AnchorPane.setLeftAnchor(label, 50.0);
		AnchorPane.setBottomAnchor(label2, 200.0);
		AnchorPane.setLeftAnchor(label2, 170.0);
		AnchorPane.setBottomAnchor(label3, 200.0);
		AnchorPane.setLeftAnchor(label3, 300.0);
		AnchorPane.setBottomAnchor(input2, 60.0);
		AnchorPane.setLeftAnchor(input3, 300.0);
		AnchorPane.setBottomAnchor(input3, 60.0);
		AnchorPane.setLeftAnchor(input2, 170.0);
		window.setMinSize(400, 400);
		
		
		window.getChildren().add(addToCart);
		window.getChildren().add(checkout);
		window.getChildren().add(message);
		window.getChildren().add(quantity);
		window.getChildren().add(input);
		window.getChildren().add(exit);
		window.getChildren().add(imgview);
		window.getChildren().add(imgview2);
		window.getChildren().add(input2);
		window.getChildren().add(imgview3);
		window.getChildren().add(input3);
		window.getChildren().add(label);
		window.getChildren().add(label2);
		window.getChildren().add(label3);
		
		
		Scene scene = new Scene(window);
		primaryStage.setScene(scene);
		primaryStage.show();
}
	
	public static void main(String[] args) {
		launch(args);
		}
	
	
	
}



