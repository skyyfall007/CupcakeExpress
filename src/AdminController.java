import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Class: AdminController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the Admin Login, Icing, and Cupcake screen.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the Admin Login, Icing, and Cupcake screen,
 * 					 and provides access to add, remove, change the price, change the quantity, and create a new Icing or Cupcake.
 * 
 */
public class AdminController implements Initializable{

	@FXML
	private ImageView vanillaIcing, strawberryIcing, chocolateIcing,
	blueberryIcing, carrotIcing, appleIcing, pumpkinIcing, redVelvetIcing;
	@FXML
	private ImageView vanillaCupcake, strawberryCupcake, chocolateCupcake,
	blueberryCupcake, carrotCupcake, appleCupcake, pumpkinCupcake, redVelvetCupcake;
	@FXML
	private TextField userTextField, passwordTextField, displayBox;
	@FXML
	private Label incorrectLoginLabel, notAvailableLabel, outOfStockLabel;
	@FXML
	private SplitMenuButton optionMenu;
	@FXML
	private MenuItem removeButton;
	@FXML
	protected static Stage popOutStage;
	@FXML
	protected static Scene scene2;
	@FXML
	private Pane quantityPane;
	@FXML
	Parent root;
	@FXML
	private AnchorPane adminAnchorPane;
	@FXML
	private TableView<ImageView> icingTable;
	
	private static AdminController instance;
	private CupcakeUI cupcakeUI = new CupcakeUI();
	boolean isPriceClicked = false, isQuantityClicked = false, isRemoveClicked = false, isAddClicked = false;
	private static String icingFlavor, cupcakeFlavor;	
	private TableColumn<ImageView, ImageView> icingColumn; 
	private ObservableList<ImageView> imageList;
	private static boolean isRemoved, isAdded = false, isAdminIcing = true;
	private Icing adminIcingSelected;
	private Cupcake adminCupcakeSelected;
	private static ArrayList<String> addRemoveNameList = new ArrayList<String>();
	private static ArrayList<String> adminAddRemoveNameList = new ArrayList<String>();

	/**
	 * Method loginButtonClicked()
	 * 
	 * This method controls the functions of the Login button.
	 * The method loads the FXML and transitions to the Admin Icing screen
	 * 
	 */
	@FXML
	public void loginButtonClicked() {
		//USER NAME & PASSWORD
		if(userTextField.getText().equals("admin") && passwordTextField.getText().equalsIgnoreCase("000000")) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminIcing.fxml"));
				loader.setController(this);
				Parent root = (Parent) loader.load();
				cupcakeUI.getScene().setRoot(root);
				cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/adminIcing.css");
				
				instance = loader.getController();
				
				if(isRemoved) {					
					removeSelection();
					addSelection();
				
					instance.notAvailableLabel.setVisible(true);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			incorrectLoginLabel.setText("Incorrect Username or Password");
			userTextField.clear();
			passwordTextField.clear();
		}
	}
	
	/**
	 * Method returnButtonClicked()
	 * 
	 * This method loads the FXML and transitions back to the Home screen.
	 * 
	 */
	@FXML
	public void returnButtonClicked() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
			Parent root = (Parent)loader.load();
			cupcakeUI.getScene().setRoot(root);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method enterLoginPressed()
	 * 
	 * This method controls the functionality for the enter button, which calls the loginButtonClicked method.
	 * 
	 */
	@FXML 
	public void enterLoginPressed() {
		loginButtonClicked();
	}
	
	/**
	 * Method initialize()
	 * 
	 * This method is called upon when the FXML loader loads this controller.
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	/**
	 * Method vanillaIcingClicked()
	 * 
	 * This method controls the functions of the vanilla icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void vanillaIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(vanillaIcing.getLayoutX());
		optionMenu.setLayoutY(vanillaIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Velvety Vanilla";
		adminIcingSelected = cupcakeUI.getVelvetyVanillaIcing();
		
		vanillaIcing.setEffect(new DropShadow(30, Color.CHOCOLATE));
		strawberryIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
	}

	/**
	 * Method strawberryIcingClicked()
	 * 
	 * This method controls the functions of the strawberry icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void strawberryIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(strawberryIcing.getLayoutX());
		optionMenu.setLayoutY(strawberryIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Strawberry Swirl";
		adminIcingSelected = cupcakeUI.getStrawberrySwirlIcing();

		
		strawberryIcing.setEffect(new DropShadow(30, Color.RED));
		vanillaIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
	}

	/**
	 * Method chocolateIcingClicked()
	 * 
	 * This method controls the functions of the chocolate icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void chocolateIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(chocolateIcing.getLayoutX());
		optionMenu.setLayoutY(chocolateIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Chunky Chocolate";
		adminIcingSelected = cupcakeUI.getChunkyChocolateIcing();


		chocolateIcing.setEffect(new DropShadow(30, Color.DARKRED));
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
	}
	
	/**
	 * Method blueberryIcingClicked()
	 * 
	 * This method controls the functions of the blueberry icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void blueberryIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(blueberryIcing.getLayoutX() + 30);
		optionMenu.setLayoutY(blueberryIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Bursting Blueberry";
		adminIcingSelected = cupcakeUI.getBurstingBlueberryIcing();


		blueberryIcing.setEffect(new DropShadow(30, Color.BLUE));
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
	}
	
	/**
	 * Method carrotIcingClicked()
	 * 
	 * This method controls the functions of the carrot icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void carrotIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(carrotIcing.getLayoutX() + 30);
		optionMenu.setLayoutY(carrotIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Creamy Carrot";
		adminIcingSelected = cupcakeUI.getCreamyCarrotIcing();

		
		carrotIcing.setEffect(new DropShadow(30, Color.BROWN));
		blueberryIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
	}
	
	/**
	 * Method appleIcingClicked()
	 * 
	 * This method controls the functions of the apple icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void appleIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(appleIcing.getLayoutX());
		optionMenu.setLayoutY(appleIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Green Apple";
		adminIcingSelected = cupcakeUI.getGreenAppleIcing();


		appleIcing.setEffect(new DropShadow(30, Color.GREEN));
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
	}
	
	/**
	 * Method pumpkinIcingClicked()
	 * 
	 * This method controls the functions of the pumpkin icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void pumpkinIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(pumpkinIcing.getLayoutX() + 30);
		optionMenu.setLayoutY(pumpkinIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Pumpkin Spice";
		adminIcingSelected = cupcakeUI.getPumpkinSpiceIcing();


		pumpkinIcing.setEffect(new DropShadow(30, Color.ORANGE));
		appleIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
	}
	
	/**
	 * Method redVelvetIcingClicked()
	 * 
	 * This method controls the functions of the red velvet icing image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void redVelvetIcingClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(redVelvetIcing.getLayoutX());
		optionMenu.setLayoutY(redVelvetIcing.getLayoutY() + 180);
		optionMenu.show();
		icingFlavor = "Ruby Red Velvet";
		adminIcingSelected = cupcakeUI.getRubyRedVelvetIcing();


		redVelvetIcing.setEffect(new DropShadow(30, Color.RED));
		pumpkinIcing.setEffect(null);
		appleIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
	}
	
	/**
	 * Method vanillaCupcakeClicked()
	 * 
	 * This method controls the functions of the vanilla cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	//CUPCAKES
	@FXML
	public void vanillaCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(vanillaCupcake.getLayoutX() + 30);
		optionMenu.setLayoutY(vanillaCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Vanilla";
		adminCupcakeSelected = cupcakeUI.getVanillaCupcake();
		
		vanillaCupcake.setEffect(new DropShadow(30, Color.CHOCOLATE));
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}

	/**
	 * Method strawberryCupcakeClicked()
	 * 
	 * This method controls the functions of the strawberry cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void strawberryCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(strawberryCupcake.getLayoutX());
		optionMenu.setLayoutY(strawberryCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Strawberry";
		adminCupcakeSelected = cupcakeUI.getStrawberryCupcake();
		
		strawberryCupcake.setEffect(new DropShadow(30, Color.RED));
		vanillaCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}

	/**
	 * Method chocolateCupcakeClicked()
	 * 
	 * This method controls the functions of the chocolate cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void chocolateCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(chocolateCupcake.getLayoutX() + 20);
		optionMenu.setLayoutY(chocolateCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Chocolate";
		adminCupcakeSelected = cupcakeUI.getChocolateCupcake();

		chocolateCupcake.setEffect(new DropShadow(30, Color.DARKRED));
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method blueberryCupcakeClicked()
	 * 
	 * This method controls the functions of the blueberry cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void blueberryCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(blueberryCupcake.getLayoutX() + 30);
		optionMenu.setLayoutY(blueberryCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Blueberry";
		adminCupcakeSelected = cupcakeUI.getBlueberryCupcake();

		blueberryCupcake.setEffect(new DropShadow(30, Color.BLUE));
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
	}
	
	/**
	 * Method carrotCupcakeClicked()
	 * 
	 * This method controls the functions of the carrot cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void carrotCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(carrotCupcake.getLayoutX());
		optionMenu.setLayoutY(carrotCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Carrot";
		adminCupcakeSelected = cupcakeUI.getCarrotCupcake();
		
		carrotCupcake.setEffect(new DropShadow(30, Color.BROWN));
		blueberryCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
	}
	
	/**
	 * Method appleCupcakeClicked()
	 * 
	 * This method controls the functions of the apple cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void appleCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(appleCupcake.getLayoutX() + 30);
		optionMenu.setLayoutY(appleCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Apple";
		adminCupcakeSelected = cupcakeUI.getAppleCupcake();

		appleCupcake.setEffect(new DropShadow(30, Color.GREEN));
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
	}
	
	/**
	 * Method pumpkinCupcakeClicked()
	 * 
	 * This method controls the functions of the pumpkin cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void pumpkinCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(pumpkinCupcake.getLayoutX() + 40);
		optionMenu.setLayoutY(pumpkinCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Pumpkin";
		adminCupcakeSelected = cupcakeUI.getPumpkinCupcake();

		pumpkinCupcake.setEffect(new DropShadow(30, Color.ORANGE));
		appleCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
	}
	
	/**
	 * Method redVelvetCupcakeClicked()
	 * 
	 * This method controls the functions of the red velvet cupcake image on the Admin Icing screen.
	 * 
	 * @param event
	 */
	@FXML
	public void redVelvetCupcakeClicked(MouseEvent event) {
		
		optionMenu.setLayoutX(redVelvetCupcake.getLayoutX());
		optionMenu.setLayoutY(redVelvetCupcake.getLayoutY() + 180);
		optionMenu.show();
		cupcakeFlavor = "Red Velvet";
		adminCupcakeSelected = cupcakeUI.getRedVelvetCupcake();

		redVelvetCupcake.setEffect(new DropShadow(30, Color.RED));
		pumpkinCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
	}
	
	/**
	 * Method clearDisplay()
	 * 
	 * This method clears the display box.
	 * 
	 */
	@FXML
	public void clearDisplay() {
		displayBox.clear();
	}
	
	/**
	 * Method enetrDisplayPressed()
	 * 
	 * This method provides the functionality for the enter button on the display box.
	 * 
	 */
	@FXML 
	public void enterDisplayPressed() {
		displayBox.getParent().requestFocus();
		confirmButtonClicked();
	}
	
	/**
	 * Method priceClicked()
	 * 
	 * This method sets the display box for a price to be entered.
	 * 
	 */
	@FXML
	public void priceClicked() {
		isPriceClicked = true;
		displayBox.setEditable(true);
		displayBox.setVisible(true);
		if(isAdminIcing) {
			displayBox.setText("Enter Price:                Current Price: $" + adminIcingSelected.getPrice());			
		}
		else {
			displayBox.setText("Enter Price:                Current Price: $" + adminCupcakeSelected.getPrice());			
		}
	}

	/**
	 * Method quantityClicked()
	 * 
	 * This method sets the display box for a quantity to be enetered.
	 * 
	 */
	@FXML
	public void quantityClicked() {
		isQuantityClicked = true;
		displayBox.setEditable(true);
		displayBox.setVisible(true);
		if(isAdminIcing) {
		displayBox.setText("Enter Quantity:                Current Quantity: " + adminIcingSelected.getQuantity());
		}
		else {
			displayBox.setText("Enter Quantity:                Current Quantity: " + adminCupcakeSelected.getQuantity());
		}
	}
	
	/**
	 * Method removeClicked()
	 * 
	 * This method sets the display box for removal of the icing or cupcake.
	 * 
	 */
	@FXML
	public void removeClicked() {
		isRemoveClicked = true;
		displayBox.setVisible(true);
		displayBox.setText("		Press Confirm To Remove");
	}
	
	/**
	 * Method addClicked()
	 * 
	 * This method sets the display box for addition of the icing or cupcake.
	 * 
	 */
	@FXML
	public void addClicked() {
		isAddClicked = true;
		displayBox.setVisible(true);
		displayBox.setText("		Press Confirm To Add");
	}

	/**
	 * Method homeButtonClicked()
	 * 
	 * This method loads the FXML and transitions to the Home screen.
	 * 
	 */
	@FXML
	public void homeButtonClicked(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
			Parent root = (Parent) loader.load();
			cupcakeUI.getScene().setRoot(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method confirmButtonClicked()
	 * 
	 * This method generates the price, quantity, removal and addition for each icing and cupcake.
	 * 
	 */
	//CONFIRM BUTTON
	@FXML
	public void confirmButtonClicked() {
		//ADMIN ICING
		if(icingFlavor != null) {
			
			//PRICE SELECTED
			if(isPriceClicked) {

				String price;
				double temp;

				try {
				switch(icingFlavor) {
				
				case "Velvety Vanilla":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getVelvetyVanillaIcing().setPrice(temp);
					displayBox.setText("Velvety Vanilla Icing is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
							
				case "Strawberry Swirl":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getStrawberrySwirlIcing().setPrice(temp);
					displayBox.setText("Strawberry Swirl Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Chunky Chocolate":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getChunkyChocolateIcing().setPrice(temp);
					displayBox.setText("Chunky Chocolate Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Bursting Blueberry":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getBurstingBlueberryIcing().setPrice(temp);
					displayBox.setText("Bursting Blueberry Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Creamy Carrot":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getCreamyCarrotIcing().setPrice(temp);
					displayBox.setText("Creamy Carrot Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Green Apple":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getGreenAppleIcing().setPrice(temp);
					displayBox.setText("Green Apple Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Pumpkin Spice":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getPumpkinSpiceIcing().setPrice(temp);
					displayBox.setText("Pumpkin Spice Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				
				case "Ruby Red Velvet":
					price = displayBox.getText();
					temp = Double.parseDouble(price);
					cupcakeUI.getRubyRedVelvetIcing().setPrice(temp);
					displayBox.setText("Ruby Red Velvet Icing price is now " + price);
					isPriceClicked = false;
					icingFlavor = null;
					break;
				}
			}catch(Exception e) {
				
			}
		}
		
		//QUANTITY SELECTED
		if(isQuantityClicked) {
			
			String quantity;
			int temp;

			try {
			switch(icingFlavor) {
			
			case "Velvety Vanilla":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getVelvetyVanillaIcing().setQuantity(temp);
				displayBox.setText("Velvety Vanilla Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
						
			case "Strawberry Swirl":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getStrawberrySwirlIcing().setQuantity(temp);
				displayBox.setText("Strawberry Swirl Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Chunky Chocolate":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getChunkyChocolateIcing().setQuantity(temp);
				displayBox.setText("Chunky Chocolate Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Bursting Blueberry":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getBurstingBlueberryIcing().setQuantity(temp);
				displayBox.setText("Bursting Blueberry Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Creamy Carrot":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getCreamyCarrotIcing().setQuantity(temp);
				displayBox.setText("Creamy Carrot Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Green Apple":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getGreenAppleIcing().setQuantity(temp);
				displayBox.setText("Green Apple Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Pumpkin Spice":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getPumpkinSpiceIcing().setQuantity(temp);
				displayBox.setText("Pumpkin Spice Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
			
			case "Ruby Red Velvet":
				quantity = displayBox.getText();
				temp = Integer.parseInt(quantity);
				cupcakeUI.getRubyRedVelvetIcing().setQuantity(temp);
				displayBox.setText("Ruby Red Velvet Icing quantity is now " + quantity);
				isQuantityClicked = false;
				icingFlavor = null;
				break;
				}
			}catch(Exception e) {
				
			}
		}
			
		
		//REMOVE SELECTED
		if(isRemoveClicked) {
			
			try {
			switch(icingFlavor) {
			
			case "Velvety Vanilla":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Velvety Vanilla Icing is now removed");
				vanillaIcing.setOpacity(0.4);
				//notAvailableLabel.setVisible(true);
				isRemoveClicked = false;
				break;
						
			case "Strawberry Swirl":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Strawberry Swirl Icing is now removed");
				strawberryIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Chunky Chocolate":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Chunky Chocolate Icing is now removed");
				chocolateIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Bursting Blueberry":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Bursting Blueberry Icing quantity is now removed");
				blueberryIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Creamy Carrot":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Creamy Carrot Icing quantity is now removed");
				carrotIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Green Apple":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Green Apple Icing quantity is now removed");
				appleIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Pumpkin Spice":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Pumpkin Spice Icing quantity is now removed");
				pumpkinIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
			
			case "Ruby Red Velvet":
				isRemoved = true;
				isAdded = false;
				addRemoveNameList.add(icingFlavor);
				adminAddRemoveNameList.add(icingFlavor);
				displayBox.setText("Ruby Red Velvet Icing quantity is now removed");
				redVelvetIcing.setOpacity(0.4);
				isRemoveClicked = false;
				break;
				}
			}catch(Exception e) {
				
			}
		}
		
		//ADD SELECTED
		if(isAddClicked) {
			
			try {
			switch(icingFlavor) {
			
			case "Velvety Vanilla":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Velvety Vanilla Icing is now added");
				vanillaIcing.setOpacity(1);
				isAddClicked = false;
				break;
						
			case "Strawberry Swirl":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Strawberry Swirl Icing is now added");
				strawberryIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Chunky Chocolate":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Chunky Chocolate Icing is now added");
				chocolateIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Bursting Blueberry":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Bursting Blueberry Icing quantity is now added");
				blueberryIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Creamy Carrot":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Creamy Carrot Icing quantity is now added");
				carrotIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Green Apple":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Green Apple Icing quantity is now added");
				appleIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Pumpkin Spice":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Pumpkin Spice Icing quantity is now added");
				pumpkinIcing.setOpacity(1);
				isAddClicked = false;
				break;
			
			case "Ruby Red Velvet":
				isAdded = true;
				isRemoved = false;
				displayBox.setText("Ruby Red Velvet Icing quantity is now added");
				redVelvetIcing.setOpacity(1);
				isAddClicked = false;
				break;
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	//ADMIN CUPCAKE
	if(cupcakeFlavor != null) {

		//PRICE SELECTED
		if(isPriceClicked) {

			String price;
			double temp;

			try {
			switch(cupcakeFlavor) {
			
			case "Vanilla":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getVanillaCupcake().setPrice(temp);
				displayBox.setText("Vanilla Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
						
			case "Strawberry":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getStrawberryCupcake().setPrice(temp);
				displayBox.setText("Strawberry Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Chocolate":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getChocolateCupcake().setPrice(temp);
				displayBox.setText("Chocolate Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Blueberry":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getBlueberryCupcake().setPrice(temp);
				displayBox.setText("Blueberry Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Carrot":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getCarrotCupcake().setPrice(temp);
				displayBox.setText("Carrot Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Apple":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getAppleCupcake().setPrice(temp);
				displayBox.setText("Apple Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Pumpkin":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getPumpkinCupcake().setPrice(temp);
				displayBox.setText("Pumpkin Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
			
			case "Red Velvet":
				price = displayBox.getText();
				temp = Double.parseDouble(price);
				cupcakeUI.getRedVelvetCupcake().setPrice(temp);
				displayBox.setText("Red Velvet Cupcake price is now " + price);
				isPriceClicked = false;
				cupcakeFlavor = null;
				break;
				}
			}catch(Exception e) {
				
			}
	}
	
	//QUANTITY SELECTED
	if(isQuantityClicked) {
		
		String quantity;
		int temp;

		try {
		switch(cupcakeFlavor) {
		
		case "Vanilla":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getVanillaCupcake().setQuantity(temp);
			displayBox.setText("Vanilla Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
					
		case "Strawberry":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getStrawberryCupcake().setQuantity(temp);
			displayBox.setText("Strawberry Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Chocolate":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getChocolateCupcake().setQuantity(temp);
			displayBox.setText("Chocolate Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Blueberry":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getBlueberryCupcake().setQuantity(temp);
			displayBox.setText("Blueberry Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Carrot":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getCarrotCupcake().setQuantity(temp);
			displayBox.setText("Carrot Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Apple":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getAppleCupcake().setQuantity(temp);
			displayBox.setText("Apple Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Pumpkin":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getPumpkinCupcake().setQuantity(temp);
			displayBox.setText("Pumpkin Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
		
		case "Red Velvet":
			quantity = displayBox.getText();
			temp = Integer.parseInt(quantity);
			cupcakeUI.getRedVelvetCupcake().setQuantity(temp);
			displayBox.setText("Red Velvet Cupcake quantity is now " + quantity);
			isQuantityClicked = false;
			cupcakeFlavor = null;
			break;
			}
		}catch(Exception e) {
			
		}
	}
	
	//REMOVE SELECTED
	if(isRemoveClicked) {
		
		try {
		switch(cupcakeFlavor) {
		
		case "Vanilla":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Vanilla Cupcake is now removed");
			vanillaCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
			
		case "Strawberry":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Strawberry Cupcake is now removed");
			strawberryCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Chocolate":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Chocolate Cupcake is now removed");
			chocolateCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Blueberry":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Blueberry Cupcake is now removed");
			blueberryCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Carrot":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Carrot Cupcake is now removed");
			carrotCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Apple":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Apple Cupcake is now removed");
			appleCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Pumpkin":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Pumpkin Cupcake is now removed");
			pumpkinCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
		
		case "Red Velvet":
			isRemoved = true;
			isAdded = false;
			addRemoveNameList.add(cupcakeFlavor);
			displayBox.setText("Red Velvet Cupcake is now removed");
			redVelvetCupcake.setOpacity(0.4);
			isRemoveClicked = false;
			break;
			}
		}catch(Exception e) {
			
		}
	}
	
	//ADD SELECTED
	if(isAddClicked) {
		
		try {
		switch(cupcakeFlavor) {
		
		case "Vanilla":
			displayBox.setText("Vanilla Cupcake is now added");
			vanillaCupcake.setOpacity(1);
			isAddClicked = false;
			break;
					
		case "Strawberry":
			displayBox.setText("Strawberry Cupcake is now added");
			strawberryCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Chocolate":
			displayBox.setText("Chocolate Cupcake is now added");
			chocolateCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Blueberry":
			displayBox.setText("Blueberry Cupcake is now added");
			blueberryCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Carrot":
			displayBox.setText("Carrot Cupcake is now added");
			carrotCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Apple":
			displayBox.setText("Apple Cupcake is now added");
			removeButton.setDisable(true);
			appleCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Pumpkin":
			displayBox.setText("Pumpkin Cupcake is now added");
			pumpkinCupcake.setOpacity(1);
			isAddClicked = false;
			break;
		
		case "Red Velvet":
			displayBox.setText("Red Velvet Cupcake is now added");
			redVelvetCupcake.setOpacity(1);
			isAddClicked = false;
			break;
			}
		}catch(Exception e) {
			
		}
	  }	
	}
}
	
	/**
	 * Method cupcakeOptionsClicked()
	 * 
	 * This method loads the FXML and transitions to the Admin Cupcake Screen.
	 * 
	 */
	public void cupcakeOptionsClicked() {
		try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminCupcake.fxml"));
			loader.setController(this);
			Parent root = (Parent) loader.load();
			cupcakeUI.getScene().setRoot(root);
			cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/adminCupcake.css");
			isAdminIcing = false;
			icingFlavor = null;	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method icingOptionsClicked()
	 * 
	 * This method loads the FXML and transitions to the Admin Icing Screen.
	 * 
	 */
	public void icingOptionsClicked() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminIcing.fxml"));
			loader.setController(this);
			Parent root = (Parent) loader.load();
			cupcakeUI.getScene().setRoot(root);
			cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/adminIcing.css");
			isAdminIcing = true;
							
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method createCupcake()
	 * 
	 * This method loads the FXML and transitions to the Admin Create Screen.
	 * 
	 */
	public void createCupcake() {
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/AdminCreate.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/adminCreate.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
	}
	
	/**
	 * Method removeSelection()
	 * 
	 * This method sets the opacity the icings and cupcakes when removed by the Administrator.
	 * 
	 */
	public void removeSelection() {
		try {
		if(AdminController.isRemoved()) {
			for(int i = 0; i < adminAddRemoveNameList.size(); i++) {
				
			if(adminAddRemoveNameList.get(i).equals("Velvety Vanilla")) {
				vanillaIcing.setOpacity(0.4);
			}
			
			if(adminAddRemoveNameList.get(i).equals("Strawberry Swirl")) {
				strawberryIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Chunky Chocolate")) {
				chocolateIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Bursting Blueberry")) {
				blueberryIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Creamy Carrot")) {
				carrotIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Green Apple")) {
				appleIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Pumpkin Spice")) {
				pumpkinIcing.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Ruby Red Velvet")) {
				redVelvetIcing.setOpacity(0.4);
				}	
			
			if(adminAddRemoveNameList.get(i).equals("Vanilla")) {
				vanillaCupcake.setOpacity(0.4);
			}
			
			if(adminAddRemoveNameList.get(i).equals("Strawberry")) {
				strawberryCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Chocolate")) {
				chocolateCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Blueberry")) {
				blueberryCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Carrot")) {
				carrotCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Apple")) {
				appleCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Pumpkin")) {
				pumpkinCupcake.setOpacity(0.4);
				}
			
			if(adminAddRemoveNameList.get(i).equals("Red Velvet")) {
				redVelvetCupcake.setOpacity(0.4);
				}
		     }
	    	}
		}catch(Exception e) {
			
		}
		}
		
	/**
	 * Method addSelection()
	 * 
	 * This method sets the opacity the icings and cupcakes when added by the Administrator.
	 * 
	 */
	public void addSelection() {
		try {
		if(AdminController.isAdded()) {
			for(int i = 0; i < adminAddRemoveNameList.size(); i++) {
				
				if(adminAddRemoveNameList.get(i).equals("Velvety Vanilla")) {
					vanillaIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
				}
				
				if(adminAddRemoveNameList.get(i).equals("Strawberry Swirl")) {
					strawberryIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Chunky Chocolate")) {
					chocolateIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Bursting Blueberry")) {
					blueberryIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Creamy Carrot")) {
					carrotIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Green Apple")) {
					appleIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Pumpkin Spice")) {
					pumpkinIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Ruby Red Velvet")) {
					redVelvetIcing.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Vanilla")) {
					vanillaCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
				}
				
				if(adminAddRemoveNameList.get(i).equals("Strawberry")) {
					strawberryCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Chocolate")) {
					chocolateCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Blueberry")) {
					blueberryCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Carrot")) {
					carrotCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Apple")) {
					appleCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Pumpkin")) {
					pumpkinCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(adminAddRemoveNameList.get(i).equals("Red Velvet")) {
					redVelvetCupcake.setOpacity(1);
					AdminController.getAddRemoveNameList().remove(i);
					}
			}
		}
		}catch(Exception e) {
			
		}
	}
	
	/**
	 * Method createdSelection()
	 * 
	 * This method sets the opacity the icings and cupcakes created by the Administrator.
	 * 
	 */
	public void createdSelection() {
		try {
			for(int i = 0; i < AdminCreateController.getIcingCreatedList().size(); i++) {
				
			if(adminAddRemoveNameList.get(i).equals("Velvety Vanilla")) {
				vanillaIcing.setOpacity(0.4);
			}
			
		
		
		     
	    	}
		}catch(Exception e) {
			
		}
		}
	
	/**
	 * 
	 * @return adminAnchorPane
	 */
	public AnchorPane getAdminAnchorPane() {
		return adminAnchorPane;
	}

	/**
	 * 
	 * @param adminAnchorPane
	 */
	public void setAdminAnchorPane(AnchorPane adminAnchorPane) {
		this.adminAnchorPane = adminAnchorPane;
	}

	/**
	 * 
	 * @return
	 */
	public static AdminController getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param instance
	 */
	public static void setInstance(AdminController instance) {
		AdminController.instance = instance;
	}

	/**
	 * 
	 * @return isRemoved
	 */
	public static boolean isRemoved() {
		return isRemoved;
	}

	/**
	 * 
	 * @param isRemoved
	 */
	public static void setRemoved(boolean isRemoved) {
		AdminController.isRemoved = isRemoved;
	}

	/**
	 * 
	 * @return isAdded
	 */
	public static boolean isAdded() {
		return isAdded;
	}

	/**
	 * 
	 * @param isAdded
	 */
	public static void setAdded(boolean isAdded) {
		AdminController.isAdded = isAdded;
	}

	/**
	 * 
	 * @return addRemoveNameList
	 */
	public static ArrayList<String> getAddRemoveNameList() {
		return addRemoveNameList;
	}

	/**
	 * 
	 * @param addRemoveNameList
	 */
	public static void setAddRemoveNameList(ArrayList<String> addRemoveNameList) {
		AdminController.addRemoveNameList = addRemoveNameList;
	}

	/**
	 * 
	 * @return vanillaIcing
	 */
	public ImageView getVanillaIcing() {
		return vanillaIcing;
	}

	/**
	 * 
	 * @param vanillaIcing
	 */
	public void setVanillaIcing(ImageView vanillaIcing) {
		this.vanillaIcing = vanillaIcing;
	}

	/**
	 * 
	 * @return strawberryIcing
	 */
	public ImageView getStrawberryIcing() {
		return strawberryIcing;
	}

	/**
	 * 
	 * @return chocolateIcing
	 */
	public ImageView getChocolateIcing() {
		return chocolateIcing;
	}

	/**
	 * 
	 * @return blueberryIcing
	 */
	public ImageView getBlueberryIcing() {
		return blueberryIcing;
	}

	/**
	 * 
	 * @return carrotIcing
	 */
	public ImageView getCarrotIcing() {
		return carrotIcing;
	}

	/**
	 * 
	 * @return appleIcing
	 */
	public ImageView getAppleIcing() {
		return appleIcing;
	}

	/**
	 * 
	 * @return pumpkinIcing
	 */
	public ImageView getPumpkinIcing() {
		return pumpkinIcing;
	}

	/**
	 * 
	 * @return redVelvetIcing
	 */
	public ImageView getRedVelvetIcing() {
		return redVelvetIcing;
	}

	/**
	 * 
	 * @return vanillaCupcake
	 */
	public ImageView getVanillaCupcake() {
		return vanillaCupcake;
	}

	/**
	 * 
	 * @return strawberryCupcake
	 */
	public ImageView getStrawberryCupcake() {
		return strawberryCupcake;
	}

	/**
	 * 
	 * @return chocolateCupcake
	 */
	public ImageView getChocolateCupcake() {
		return chocolateCupcake;
	}

	/**
	 * 
	 * @return blueberryCupcake
	 */
	public ImageView getBlueberryCupcake() {
		return blueberryCupcake;
	}

	public ImageView getCarrotCupcake() {
		return carrotCupcake;
	}

	/**
	 * 
	 * @return appleCupcake
	 */
	public ImageView getAppleCupcake() {
		return appleCupcake;
	}

	/**
	 * 
	 * @return pumpkinCupcake
	 */
	public ImageView getPumpkinCupcake() {
		return pumpkinCupcake;
	}

	/**
	 * 
	 * @return redVelvetCupcake
	 */
	public ImageView getRedVelvetCupcake() {
		return redVelvetCupcake;
	}

	/**
	 * 
	 * @param strawberryIcing
	 */
	public void setStrawberryIcing(ImageView strawberryIcing) {
		this.strawberryIcing = strawberryIcing;
	}

	/**
	 * 
	 * @param chocolateIcing
	 */
	public void setChocolateIcing(ImageView chocolateIcing) {
		this.chocolateIcing = chocolateIcing;
	}

	/**
	 * 
	 * @param blueberryIcing
	 */
	public void setBlueberryIcing(ImageView blueberryIcing) {
		this.blueberryIcing = blueberryIcing;
	}

	/**
	 * 
	 * @param carrotIcing
	 */
	public void setCarrotIcing(ImageView carrotIcing) {
		this.carrotIcing = carrotIcing;
	}

	/**
	 * 
	 * @param appleIcing
	 */
	public void setAppleIcing(ImageView appleIcing) {
		this.appleIcing = appleIcing;
	}

	/**
	 * 
	 * @param pumpkinIcing
	 */
	public void setPumpkinIcing(ImageView pumpkinIcing) {
		this.pumpkinIcing = pumpkinIcing;
	}

	/**
	 * 
	 * @param redVelvetIcing
	 */
	public void setRedVelvetIcing(ImageView redVelvetIcing) {
		this.redVelvetIcing = redVelvetIcing;
	}

	/**
	 * 
	 * @param vanillaCupcake
	 */
	public void setVanillaCupcake(ImageView vanillaCupcake) {
		this.vanillaCupcake = vanillaCupcake;
	}

	/**
	 * 
	 * @param strawberryCupcake
	 */
	public void setStrawberryCupcake(ImageView strawberryCupcake) {
		this.strawberryCupcake = strawberryCupcake;
	}

	/**
	 * 
	 * @param chocolateCupcake
	 */
	public void setChocolateCupcake(ImageView chocolateCupcake) {
		this.chocolateCupcake = chocolateCupcake;
	}

	/**
	 * 
	 * @param blueberryCupcake
	 */
	public void setBlueberryCupcake(ImageView blueberryCupcake) {
		this.blueberryCupcake = blueberryCupcake;
	}

	/**
	 * 
	 * @param carrotCupcake
	 */
	public void setCarrotCupcake(ImageView carrotCupcake) {
		this.carrotCupcake = carrotCupcake;
	}

	/**
	 * 
	 * @param appleCupcake
	 */
	public void setAppleCupcake(ImageView appleCupcake) {
		this.appleCupcake = appleCupcake;
	}

	/**
	 * 
	 * @param pumpkinCupcake
	 */
	public void setPumpkinCupcake(ImageView pumpkinCupcake) {
		this.pumpkinCupcake = pumpkinCupcake;
	}

	/**
	 * 
	 * @param redVelvetCupcake
	 */
	public void setRedVelvetCupcake(ImageView redVelvetCupcake) {
		this.redVelvetCupcake = redVelvetCupcake;
	}
}
