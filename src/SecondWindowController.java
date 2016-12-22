import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/*
 * Class: SecondWindowController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the second stage window that opens the quantity selection.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the quantity selection screen,
 * 					  and handles how many Icings & Cupcakes are chosen.
 * 
 */
public class SecondWindowController implements Initializable {

	@FXML
	private ImageView icingSelectedImage;
	@FXML
	private ImageView cupcakeSelectedImage;
	@FXML
	private Label cupcakeName, quantityNumberLabel, remainingIcingQuantityLabel, remainingCupcakeQuantityLabel, 
	icingPriceLabel, cupcakePriceLabel;
	
	private static SecondWindowController instance = new SecondWindowController();
	private static int quantityNumber;
	int tempIcingQuantity;
	
	/**
	 * Method initialize()
	 * 
	 * This method is called upon when the FXML loader loads this controller.
	 * When called this method sets each icing, cupcake, label, and button nodes accordingly on the pane 
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//CUPCAKE Label
		cupcakeName.setText(MainController.getCupcakeName());
		
		if(MainController.getCupcakeName().length() >= 30) {
			cupcakeName.setLayoutX(75);
			cupcakeName.setLayoutY(0);
		}
		else if(MainController.getCupcakeName().length() >= 20 && (MainController.getCupcakeName().length() <= 29)) {
			cupcakeName.setLayoutX(130);
			cupcakeName.setLayoutY(0);
		}
		else {
			cupcakeName.setLayoutX(140);
			cupcakeName.setLayoutY(0);
		}
		
		
		//ICING Price Label
		icingPriceLabel.setText("Icing $ " + MainController.getIcingChoiceObject().getPrice());
		
		//CUPCAKE Price Label
		cupcakePriceLabel.setText("Cupcake $ " + MainController.getCupcakeChoiceObject().getPrice());
		
		
		//ICING Quantity Remaining Label
		remainingIcingQuantityLabel.setText("Icings Remaining: " + MainController.getIcingChoiceObject().getQuantity());
		if(MainController.getIcingChoiceObject().getQuantity() == 0) {
			remainingIcingQuantityLabel.setText("Icing Out Of Stock");
		}
		
		//CUPCAKE Quantity Remaining Label
		remainingCupcakeQuantityLabel.setText("Cupcakes Remaining: " + MainController.getCupcakeChoiceObject().getQuantity());
		if(MainController.getCupcakeChoiceObject().getQuantity() == 0) {
			remainingCupcakeQuantityLabel.setText("Cupcake Out Of Stock");
		}


		//ICINGS
		switch(MainController.getIcingFlavor()) {
		
		case "Velvety Vanilla":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(200);
			icingSelectedImage.setLayoutY(65);
			icingSelectedImage.setFitWidth(200);
			icingSelectedImage.setFitHeight(240);
			break;
		
		case "Strawberry Swirl":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(195);
			icingSelectedImage.setLayoutY(65);
			icingSelectedImage.setFitWidth(200);
			icingSelectedImage.setFitHeight(220);
			break;
			
		case "Chunky Chocolate":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(220);
			icingSelectedImage.setLayoutY(65);
			icingSelectedImage.setFitWidth(300);
			icingSelectedImage.setFitHeight(215);
			break;
			
		case "Bursting Blueberry":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(130);
			icingSelectedImage.setLayoutY(85);
			icingSelectedImage.setFitWidth(330);
			icingSelectedImage.setFitHeight(350);
			break;
			
		case "Creamy Carrot":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(180);
			icingSelectedImage.setLayoutY(95);
			icingSelectedImage.setFitWidth(220);
			icingSelectedImage.setFitHeight(220);
			break;
			
		case "Green Apple":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(190);
			icingSelectedImage.setLayoutY(65);
			icingSelectedImage.setFitWidth(200);
			icingSelectedImage.setFitHeight(240);
			break;
			
		case "Pumpkin Spice":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(180);
			icingSelectedImage.setLayoutY(110);
			icingSelectedImage.setFitWidth(230);
			icingSelectedImage.setFitHeight(250);
			break;
			
		case "Ruby Red Velvet":
			icingSelectedImage.setImage(MainController.getInstance().getIcingIMG());
			icingSelectedImage.setLayoutX(210);
			icingSelectedImage.setLayoutY(75);
			icingSelectedImage.setFitWidth(230);
			icingSelectedImage.setFitHeight(200);
			break;
			
		default: ;
	
			}
		
		//CUPCAKES
		switch(MainController.getInstance().getCupcakeFlavor()) {
				
		case "Vanilla":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(125);
			cupcakeSelectedImage.setLayoutY(165);
			cupcakeSelectedImage.setFitWidth(350);
			cupcakeSelectedImage.setFitHeight(350);
			break;
		
		case "Strawberry":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(190);
			cupcakeSelectedImage.setLayoutY(170);
			cupcakeSelectedImage.setFitWidth(300);
			cupcakeSelectedImage.setFitHeight(300);
			break;
			
		case "Chocolate":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(160);
			cupcakeSelectedImage.setLayoutY(150);
			cupcakeSelectedImage.setFitWidth(250);
			cupcakeSelectedImage.setFitHeight(250);
			break;
			
		case "Blueberry":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(120);
			cupcakeSelectedImage.setLayoutY(140);
			cupcakeSelectedImage.setFitWidth(350);
			cupcakeSelectedImage.setFitHeight(350);
			break;
			
		case "Carrot":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(190);
			cupcakeSelectedImage.setLayoutY(110);
			cupcakeSelectedImage.setFitWidth(300);
			cupcakeSelectedImage.setFitHeight(290);
			break;
			
		case "Apple":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(145);
			cupcakeSelectedImage.setLayoutY(160);
			cupcakeSelectedImage.setFitWidth(300);
			cupcakeSelectedImage.setFitHeight(300);
			break;
			
		case "Pumpkin":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(100);
			cupcakeSelectedImage.setLayoutY(140);
			cupcakeSelectedImage.setFitWidth(375);
			cupcakeSelectedImage.setFitHeight(375);
			break;
			
		case "Red Velvet":
			cupcakeSelectedImage.setImage(MainController.getInstance().getCupcakeIMG());
			cupcakeSelectedImage.setLayoutX(170);
			cupcakeSelectedImage.setLayoutY(150);
			cupcakeSelectedImage.setFitWidth(275);
			cupcakeSelectedImage.setFitHeight(275);
			break;
			
		default: ;
	
			}		
	}

	/**
	 * Method: leftArrowClicked()
	 * 
	 * This method controls the left arrow node that decreases the quantity of the cupcake.
	 * 
	 */
	@FXML
	public void leftArrowClicked() {
		
		if (quantityNumber <= 0) {
			quantityNumber = 0;
		}
		if (quantityNumber >= 1) {
			quantityNumber--;
		}
		String temp = Integer.toString(quantityNumber);
		quantityNumberLabel.setText(temp);
		
		if(quantityNumber < 10) {
			quantityNumberLabel.setLayoutX(270);
		}
	}
	
	/**
	 * Method: rightArrowClicked()
	 * 
	 * This method controls the right arrow node that increases the quantity of the cupcake.
	 * 
	 */
	@FXML
	public void rightArrowClicked() {
		
		if (quantityNumber >= MainController.getCupcakeSelected().getIcing().getQuantity()) {
			if(MainController.getCupcakeSelected().getIcing().getQuantity() <= MainController.getCupcakeSelected().getCupcake().getQuantity()) {
				quantityNumber = MainController.getCupcakeSelected().getIcing().getQuantity();
			}
		}
		
		else if (quantityNumber >= MainController.getCupcakeSelected().getCupcake().getQuantity()) {
			if(MainController.getCupcakeSelected().getCupcake().getQuantity() <= MainController.getCupcakeSelected().getIcing().getQuantity()) {
				quantityNumber = MainController.getCupcakeSelected().getCupcake().getQuantity();
			}
		}
		
		else if (quantityNumber < MainController.getCupcakeSelected().getIcing().getQuantity() || quantityNumber < MainController.getCupcakeSelected().getCupcake().getQuantity()) {
			quantityNumber++;
		}
		
		else if(quantityNumber == 10) {
			quantityNumberLabel.setLayoutX(245);
		}
		
		String temp = Integer.toString(quantityNumber);
		quantityNumberLabel.setText(temp);
		
	}
	
	/**
	 * Method: backButtonClicked()
	 * 
	 * This method closes the second window.
	 * 
	 */
	@FXML
	public void backButtonClicked() {
		quantityNumber = 0;
		MainController.getPopOutStage().close();
	}
	
	/**
	 * Method: backButtonClicked()
	 * 
	 * This method adds the icings, cupcakes and quantity to the cart .
	 * 
	 */
	@FXML
	public void cartButtonClicked() {
		MainController.setAddToCart(true);
		
		if((MainController.getCupcakeSelected().getIcing().getQuantity() < quantityNumber) || 
				(MainController.getCupcakeSelected().getCupcake().getQuantity() < quantityNumber) || (quantityNumber == 0)) {
			//Do Nothing
		}
		
		else {	
			//Setting Object
			MainController.getCupcakeSelected().getIcing().setQuantity(MainController.getCupcakeSelected().getIcing().getQuantity() - quantityNumber);
			MainController.getCupcakeSelected().getCupcake().setQuantity(MainController.getCupcakeSelected().getCupcake().getQuantity() - quantityNumber);
			
			MainController.getCupcakeSelected().setQuantity(quantityNumber);
			
			//ADDING To Cart
			MainController.getInstance().getCart().add(MainController.getCupcakeSelected());
			System.out.println("Cart: " + MainController.getInstance().getCart());
			System.out.println("Cart Size: " + MainController.getInstance().getCart().size());
			quantityNumber = 0;
			MainController.getPopOutStage().close();
		}
	}

	/**
	 * 
	 * @return quantityNumber
	 */
	public int getQuantityNumber() {
		return quantityNumber;
	}

	/**
	 * 
	 * @param quantityNumber
	 */
	public static void setQuantityNumber(int quantityNumber) {
		SecondWindowController.quantityNumber = quantityNumber;
	}

	/**
	 * 
	 * @return instance
	 */
	public static SecondWindowController getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param instance
	 */
	public static void setInstance(SecondWindowController instance) {
		SecondWindowController.instance = instance;
	}	
}


	/*	  
		 "Velvety Vanilla Strawberry Cupcake"
		 "Strawberry Swirl Cupcake"
		 "Chunky Chocolate Strawberry Cupcake"
		 "Bursting Blueberry Strawberry Cupcake"
		 "Creamy Carrot Strawberry Cupcake"
		 "Green Apple Strawberry Cupcake"
		 "Pumpkin Spice Strawberry Cupcake"
		 "Ruby Red Velvet Strawberry Cupcake"
		 "Velvety Vanilla Chocolate Cupcake"
		 "Strawberry Swirl Chocolate Cupcake"
		 "Chunky Chocolate Chocolate Cupcake"
		 "Bursting Blueberry Chocolate Cupcake"
		 "Creamy Carrot Chocolate Cupcake"
		 "Green Apple Chocolate Cupcake"
		 "Pumpkin Spice Chocolate Cupcake"
		 "Ruby Red Velvet Chocolate Cupcake"
		 "Velvety Vanilla Blueberry Cupcake"
		 "Strawberry Swirl Blueberry Cupcake"
		 "Chunky Chocolate Blueberry Cupcake"
		 "Bursting Blueberry Cupcake"
		 "Creamy Carrot Blueberry Cupcake",
		 "Green Apple Blueberry Cupcake"
		 "Pumpkin Spice Blueberry Cupcake"
		 "Ruby Red Velvet Blueberry Cupcake"
		 "Velvety Vanilla Carrot Cupcake"
		 "Strawberry Swirl Carrot Cupcake"
		 "Chunky Chocolate Carrot Cupcake"
		 "Bursting Blueberry Carrot Cupcake"
		 "Creamy Carrot Cupcake"
		 "Green Apple Carrot Cupcake"
		 "Pumpkin Spice Carrot Cupcake"
		 "Ruby Red Velvet Carrot Cupcake"
		 "Velvety Vanilla Apple Cupcake"
		 "Strawberry Swirl Apple Cupcake"
		 "Chunky Chocolate Apple Cupcake"
		 "Bursting Blueberry Apple Cupcake"
		 "Creamy Carrot Apple Cupcake"
		 "Green Apple Cupcake"
		 "Pumpkin Spice Apple Cupcake"
		 "Ruby Red Velvet Apple Cupcake"
		 "Velvety Vanilla Pumpkin Cupcake"
		 "Strawberry Swirl Pumpkin Cupcake"
		 "Chunky Chocolate Pumpkin Cupcake"
		 "Bursting Blueberry Pumpkin Cupcake"
		 "Creamy Carrot Pumpkin Cupcake"
		 "Green Apple Pumpkin Cupcake"
		 "Pumpkin Spice Pumpkin Cupcake"
		 "Ruby Red Velvet Pumpkin Cupcake"
		 "Velvety Vanilla Red Velvet Cupcake"
		 "Strawberry Swirl Red Velvet Cupcake"
		 "Chunky Chocolate Red Velvet Cupcake",
		 "Bursting Blueberry Red Velvet Cupcake"
		 "Creamy Carrot Red Velvet Cupcake"
		 "Green Apple Red Velvet Cupcake"
		 "Pumpkin Spice Red Velvet Cupcake"
		 "Ruby Red Velvet Cupcake"*/
