import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Class: MainController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the opening stage GUI that allows access to the home and selection screen.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the home and selection screen,
 * 					  and handles the choice for the selection of Icings & Cupcakes.
 * 
 */
public class MainController implements Initializable { 

	@FXML
	protected static Stage popOutStage;
	@FXML
	protected static Scene scene2;
	@FXML
	private Pane quantityPane;
	@FXML
	Parent root;
	@FXML
	private ImageView vanillaIcing, strawberryIcing, chocolateIcing,
	blueberryIcing, carrotIcing, appleIcing, pumpkinIcing, redVelvetIcing;
	@FXML
	private ImageView vanillaCupcake, strawberryCupcake, chocolateCupcake,
	blueberryCupcake, carrotCupcake, appleCupcake, pumpkinCupcake, redVelvetCupcake;
	@FXML
	private static ImageView icingImage;
	@FXML
	private ListView<String> editCartList;

	private static MainController instance;	
	private CupcakeUI cupcakeUI = new CupcakeUI();
	private static Image icingIMG, cupcakeIMG;
	private static String icingFlavor, cupcakeFlavor;
	private static String cupcakeName;
	private static Cupcake cupcakeSelected, cupcakeChoiceObject;
	private static Icing icingChoiceObject;	
	private static boolean isAddToCart = false, isCartSelect = true;
	private ObservableList<String> menuList = FXCollections.observableArrayList();
	private static ArrayList<Cupcake> cart = new ArrayList<Cupcake>();
	
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
	 * Method purchaseButtonClicked()
	 * 
	 * This method controls the functions of the Purchase Button on the home screen.
	 * The method transitions to the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void purchaseButtonClicked(ActionEvent event) {
		try {		
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CupcakeSelection.fxml"));
			loader.setController(this);
			Parent root = (Parent)loader.load();
			cupcakeUI.getScene().setRoot(root);
			cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/cupcakeSelection.css");
			
			instance = loader.getController();
		} catch (Exception e) {
		}
		
		addSelection();
		removeSelection();
	}

	/**
	 * Method administratorButtonClicked()
	 * 
	 * This method controls the functions of the Admin Button on the home screen.
	 * The method transitions to the Admin Login screen.
	 * 
	 * @param event
	 */
	@FXML
	public void administratorButtonClicked(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AdminLogin.fxml"));
			loader.setController(new AdminController());
			Parent root = (Parent)loader.load();
			cupcakeUI.getScene().setRoot(root);
			cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/adminLogin.css");
			
		} catch (Exception e) {
		}
	}

	
	/**
	 * Method vanillaIcingClicked()
	 * 
	 * This method controls the functions of the vanilla icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void vanillaIcingClicked(MouseEvent event) {
		//Gets the flavor for when Cupcake is clicked
		icingFlavor = "Velvety Vanilla";
		//Gets the Icing Object
		icingChoiceObject = cupcakeUI.getVelvetyVanillaIcing();
		//Sets the Icing Image for Pop Out Window
		setIcingIMG(new Image("Vanilla Icing (Project).png"));
		
		vanillaIcing.setEffect(new DropShadow(30, Color.CHOCOLATE));
		strawberryIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		
	}

	/**
	 * Method strawberryIcingClicked()
	 * 
	 * This method controls the functions of the strawberry icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void strawberryIcingClicked(MouseEvent event) {
		icingFlavor = "Strawberry Swirl";
		icingChoiceObject = cupcakeUI.getStrawberrySwirlIcing();
		setIcingIMG(new Image("Strawberry Icing (Project).png"));
		
		strawberryIcing.setEffect(new DropShadow(30, Color.RED));
		vanillaIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}

	/**
	 * Method chocolateIcingClicked()
	 * 
	 * This method controls the functions of the chocolate icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void chocolateIcingClicked(MouseEvent event) {
		icingFlavor = "Chunky Chocolate";
		icingChoiceObject = cupcakeUI.getChunkyChocolateIcing();
		setIcingIMG(new Image("Chocolate Icing (Project).png"));
		
		chocolateIcing.setEffect(new DropShadow(30, Color.DARKRED));
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method blueberryIcingClicked()
	 * 
	 * This method controls the functions of the blueberry icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void blueberryIcingClicked(MouseEvent event) {
		icingFlavor = "Bursting Blueberry";
		icingChoiceObject = cupcakeUI.getBurstingBlueberryIcing();
		setIcingIMG(new Image("Blueberry Icing .png"));
		
		blueberryIcing.setEffect(new DropShadow(30, Color.BLUE));
		carrotIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method carrotIcingClicked()
	 * 
	 * This method controls the functions of the carrot icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void carrotIcingClicked(MouseEvent event) {
		icingFlavor = "Creamy Carrot";
		icingChoiceObject = cupcakeUI.getCreamyCarrotIcing();
		setIcingIMG(new Image("Carrot Icing (Project).png"));
		
		carrotIcing.setEffect(new DropShadow(30, Color.BROWN));
		blueberryIcing.setEffect(null);
		appleIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method appleIcingClicked()
	 * 
	 * This method controls the functions of the apple icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void appleIcingClicked(MouseEvent event) {
		icingFlavor = "Green Apple";
		icingChoiceObject = cupcakeUI.getGreenAppleIcing();
		setIcingIMG(new Image("Apple Icing (Project).png"));
		
		appleIcing.setEffect(new DropShadow(30, Color.GREEN));
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		pumpkinIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method pumpkinIcingClicked()
	 * 
	 * This method controls the functions of the pumpkin icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void pumpkinIcingClicked(MouseEvent event) {
		icingFlavor = "Pumpkin Spice";
		icingChoiceObject = cupcakeUI.getPumpkinSpiceIcing();
		setIcingIMG(new Image("Pumpkin Icing.png"));
		
		pumpkinIcing.setEffect(new DropShadow(30, Color.ORANGE));
		appleIcing.setEffect(null);
		redVelvetIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method redVelvetIcingClicked()
	 * 
	 * This method controls the functions of the red velvet icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void redVelvetIcingClicked(MouseEvent event) {
		icingFlavor = "Ruby Red Velvet";
		icingChoiceObject = cupcakeUI.getRubyRedVelvetIcing();
		setIcingIMG(new Image("RedVelvetIcing.png"));
		
		redVelvetIcing.setEffect(new DropShadow(30, Color.RED));
		pumpkinIcing.setEffect(null);
		appleIcing.setEffect(null);
		blueberryIcing.setEffect(null);
		carrotIcing.setEffect(null);
		chocolateIcing.setEffect(null);
		strawberryIcing.setEffect(null);
		vanillaIcing.setEffect(null);
		
		vanillaCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
	}
	
	/**
	 * Method newIcingIcingClicked()
	 * 
	 * This method controls the functions of the new icing image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	public void newIcingClicked(MouseEvent event) {
	//	AdminCreateController.getInstance().getImageDisplay().setOnMouseClicked();
		for(int i = 0; i < CupcakeUI.getIcingArray().size(); i++) {
			
			if(CupcakeUI.getIcingArray().get(i).getIcingName().equals(AdminCreateController.getIcingCreatedList().get(i).getIcingName())) {
			
				icingFlavor = CupcakeUI.getIcingArray().get(i).getIcingName();
				icingChoiceObject = CupcakeUI.getIcingArray().get(i);				
				
				}
				
		}
	
	}
	
	/**
	 * Method vanillaCupcakeClicked()
	 * 
	 * This method controls the functions of the vanilla cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void vanillaCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Vanilla";
		cupcakeChoiceObject = cupcakeUI.getVanillaCupcake();
		setCupcakeIMG(new Image("Vanilla Cupcake (Project).png"));
		
		if(icingFlavor != null) {
		vanillaCupcake.setEffect(new DropShadow(30, Color.CHOCOLATE));
		strawberryCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		
		if(icingFlavor.equals("Velvety Vanilla")) {
		
			 Cupcake velvetyVanillaCupcake = new Cupcake(0, SecondWindowController.getInstance().getQuantityNumber(), cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Velvety Vanilla Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = velvetyVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}

		else if(icingFlavor.equals("Strawberry Swirl")) {
				
			Cupcake strawberrySwirlVanillaCupcake = new Cupcake(1, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Strawberry Swirl Vanilla Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = strawberrySwirlVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
			
		else if(icingFlavor.equals("Chunky Chocolate")) {
			
			Cupcake chunkyChocolateVanillaCupcake = new Cupcake(2, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Chunky Chocolate Vanilla Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = chunkyChocolateVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
			
		else if(icingFlavor.equals("Bursting Blueberry")) {

			Cupcake burstingBlueberryVanillaCupcake = new Cupcake(3, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Bursting Blueberry Vanilla Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = burstingBlueberryVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
		
		else if(icingFlavor.equals("Creamy Carrot")) {
	
			Cupcake creamyCarrotVanillaCupcake = new Cupcake(4, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Creamy Carrot Vanilla Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = creamyCarrotVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
		
		else if(icingFlavor.equals("Green Apple")) {
			Cupcake greenAppleVanillaCupcake = new Cupcake(5, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Green Apple Vanilla Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = greenAppleVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
			
		else if(icingFlavor.equals("Pumpkin Spice")) {

			Cupcake pumpkinSpiceVanillaCupcake = new Cupcake(6, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Pumpkin Spice Vanilla Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = pumpkinSpiceVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
			
		else if(icingFlavor.equals("Ruby Red Velvet")) {

			Cupcake rubyRedVelvetVanillaCupcake = new Cupcake(7, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getVanillaCupcake().getPrice(),
					 "Ruby Red Velvet Vanilla Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getVanillaCupcake());
			 cupcakeSelected = rubyRedVelvetVanillaCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
		}
			 
	/*	else if(icingFlavor.equals(AdminCreateController.getInstance().getIcing().getIcingName())) {
			
			Cupcake adminChoice = new Cupcake(AdminCreateController.getInstance().getIcing().getId(), 
					AdminCreateController.getInstance().getIcing().getQuantity(),
					AdminCreateController.getInstance().getIcing().getPrice(), adminCupcakeName, adminImage)
			
			
	
			}*/
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
		}
	}

	/**
	 * Method strawberryCupcakeClicked()
	 * 
	 * This method controls the functions of the strawberry cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void strawberryCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Strawberry";
		cupcakeChoiceObject = cupcakeUI.getStrawberryCupcake();
		setCupcakeIMG(new Image("Strawberry Cupcake (Project).png"));

		
		if(icingFlavor != null) {
		strawberryCupcake.setEffect(new DropShadow(30, Color.RED));
		vanillaCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);	
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaStrawberryCupcake = new Cupcake(8, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Velvety Vanilla Strawberry Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = velvetyVanillaStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlCupcake = new Cupcake(9, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Strawberry Swirl Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = strawberrySwirlCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateStrawberryCupcake = new Cupcake(10, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Chunky Chocolate Strawberry Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = chunkyChocolateStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryStrawberryCupcake = new Cupcake(11, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Bursting Blueberry Strawberry Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = burstingBlueberryStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotStrawberryCupcake = new Cupcake(12, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Creamy Carrot Strawberry Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = creamyCarrotStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleStrawberryCupcake = new Cupcake(13, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Green Apple Strawberry Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = greenAppleStrawberryCupcake;	
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceStrawberryCupcake = new Cupcake(14, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Pumpkin Spice Strawberry Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = pumpkinSpiceStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetStrawberryCupcake = new Cupcake(15, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getStrawberryCupcake().getPrice(),
					 "Ruby Red Velvet Strawberry Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getStrawberryCupcake());
			 cupcakeSelected = rubyRedVelvetStrawberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
		}
	}

	/**
	 * Method chocolateCupcakeClicked()
	 * 
	 * This method controls the functions of the chocolate cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void chocolateCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Chocolate";
		cupcakeChoiceObject = cupcakeUI.getChocolateCupcake();
		setCupcakeIMG(new Image("Chocolate Cupcake (Project).png"));
		
		if(icingFlavor != null) {
		chocolateCupcake.setEffect(new DropShadow(30, Color.DARKRED));
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Velvety Vanilla Chocolate Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = velvetyVanillaChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Strawberry Swirl Chocolate Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = strawberrySwirlChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Chunky Chocolate Chocolate Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = chunkyChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Bursting Blueberry Chocolate Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = burstingBlueberryChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Creamy Carrot Chocolate Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = creamyCarrotChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Green Apple Chocolate Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = greenAppleChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Pumpkin Spice Chocolate Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = pumpkinSpiceChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetChocolateCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getChocolateCupcake().getPrice(),
					 "Ruby Red Velvet Chocolate Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getChocolateCupcake());
			 cupcakeSelected = rubyRedVelvetChocolateCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
		}
	}
	
	/**
	 * Method blueberryCupcakeClicked()
	 * 
	 * This method controls the functions of the blueberry cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void blueberryCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Blueberry";
		cupcakeChoiceObject = cupcakeUI.getBlueberryCupcake();
		setCupcakeIMG(new Image("blueberry cupcake base.png"));

		
		if(icingFlavor != null) {
		blueberryCupcake.setEffect(new DropShadow(30, Color.BLUE));
		carrotCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Velvety Vanilla Blueberry Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = velvetyVanillaBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Strawberry Swirl Blueberry Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = strawberrySwirlBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Chunky Chocolate Blueberry Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = chunkyChocolateBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Bursting Blueberry Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = burstingBlueberryCupcake;	
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Creamy Carrot Blueberry Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = creamyCarrotBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Green Apple Blueberry Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = greenAppleBlueberryCupcake;	
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Pumpkin Spice Blueberry Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = pumpkinSpiceBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetBlueberryCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getBlueberryCupcake().getPrice(),
					 "Ruby Red Velvet Blueberry Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getBlueberryCupcake());
			 cupcakeSelected = rubyRedVelvetBlueberryCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
		}
	}
	
	/**
	 * Method carrotCupcakeClicked()
	 * 
	 * This method controls the functions of the carrot cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void carrotCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Carrot";
		cupcakeChoiceObject = cupcakeUI.getCarrotCupcake();
		setCupcakeIMG(new Image("Carrot Cupcake (Project).png"));

		
		if(icingFlavor != null) {
		carrotCupcake.setEffect(new DropShadow(30, Color.BROWN));
		blueberryCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Velvety Vanilla Carrot Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = velvetyVanillaCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Strawberry Swirl Carrot Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = strawberrySwirlCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Chunky Chocolate Carrot Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = chunkyChocolateCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Bursting Blueberry Carrot Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = burstingBlueberryCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Creamy Carrot Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = creamyCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Green Apple Carrot Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = greenAppleCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Pumpkin Spice Carrot Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = pumpkinSpiceCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetCarrotCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getCarrotCupcake().getPrice(),
					 "Ruby Red Velvet Carrot Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getCarrotCupcake());
			 cupcakeSelected = rubyRedVelvetCarrotCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
			
			}
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}
		}
	}
	
	/**
	 * Method appleCupcakeClicked()
	 * 
	 * This method controls the functions of the apple cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void appleCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Apple";
		cupcakeChoiceObject = cupcakeUI.getAppleCupcake();
		setCupcakeIMG(new Image("Apple Cupcake (Project).png"));
		
		if(icingFlavor != null) {
		appleCupcake.setEffect(new DropShadow(30, Color.GREEN));
		pumpkinCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaAppleCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Velvety Vanilla Apple Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = velvetyVanillaAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlAppleCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Strawberry Swirl Apple Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = strawberrySwirlAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateAppleCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Chunky Chocolate Apple Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = chunkyChocolateAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryAppleCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Bursting Blueberry Apple Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = burstingBlueberryAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotAppleCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Creamy Carrot Apple Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = creamyCarrotAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Green Apple Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = greenAppleCupcake;	
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceAppleCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Pumpkin Spice Apple Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = pumpkinSpiceAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetAppleCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getAppleCupcake().getPrice(),
					 "Ruby Red Velvet Apple Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getAppleCupcake());
			 cupcakeSelected = rubyRedVelvetAppleCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
		try {
			root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

			scene2 = new Scene(root, 600, 500);
			scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
			popOutStage = new Stage();
			popOutStage.setScene(scene2);
			popOutStage.initModality(Modality.WINDOW_MODAL);
			popOutStage.initOwner(cupcakeUI.getStage());
			popOutStage.showAndWait();
			}catch(IOException e) {
				
			}		
		}
	}
	
	/**
	 * Method pumpkinCupcakeClicked()
	 * 
	 * This method controls the functions of the pumpkin cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void pumpkinCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Pumpkin";
		cupcakeChoiceObject = cupcakeUI.getPumpkinCupcake();
		setCupcakeIMG(new Image("Pumpkin Cupcake Base.png"));
		
		if(icingFlavor != null) {
		pumpkinCupcake.setEffect(new DropShadow(30, Color.ORANGE));
		appleCupcake.setEffect(null);
		redVelvetCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaPumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Velvety Vanilla Pumpkin Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = velvetyVanillaPumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlPumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Strawberry Swirl Pumpkin Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = strawberrySwirlPumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolatePumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Chunky Chocolate Pumpkin Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = chunkyChocolatePumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryPumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Bursting Blueberry Pumpkin Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = burstingBlueberryPumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotPumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Creamy Carrot Pumpkin Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = creamyCarrotPumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenApplePumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Green Apple Pumpkin Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = greenApplePumpkinCupcake;	
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Pumpkin Spice Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = pumpkinSpiceCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetPumpkinCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getPumpkinCupcake().getPrice(),
					 "Ruby Red Velvet Pumpkin Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getPumpkinCupcake());
			 cupcakeSelected = rubyRedVelvetPumpkinCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
			try {
				root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

				scene2 = new Scene(root, 600, 500);
				scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
				popOutStage = new Stage();
				popOutStage.setScene(scene2);
				popOutStage.initModality(Modality.WINDOW_MODAL);
				popOutStage.initOwner(cupcakeUI.getStage());
				popOutStage.showAndWait();
			} catch (IOException e) {

			}
		}
	}
	
	/**
	 * Method redVelvetCupcakeClicked()
	 * 
	 * This method controls the functions of the red velvet cupcake image on the Cupcake Selection screen.
	 * 
	 * @param event
	 */
	@FXML
	public void redVelvetCupcakeClicked(MouseEvent event) {
		cupcakeFlavor = "Red Velvet";
		cupcakeChoiceObject = cupcakeUI.getRedVelvetCupcake();
		setCupcakeIMG(new Image("Red Velvet Cupcake (Project).png"));
		
		if(icingFlavor != null) {
		redVelvetCupcake.setEffect(new DropShadow(30, Color.RED));
		pumpkinCupcake.setEffect(null);
		appleCupcake.setEffect(null);
		blueberryCupcake.setEffect(null);
		carrotCupcake.setEffect(null);
		chocolateCupcake.setEffect(null);
		strawberryCupcake.setEffect(null);
		vanillaCupcake.setEffect(null);
		
		switch(icingFlavor) {
		
		case "Velvety Vanilla":
			 Cupcake velvetyVanillaRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getVelvetyVanillaIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Velvety Vanilla Red Velvet Cupcake", cupcakeUI.getVelvetyVanillaIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = velvetyVanillaRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
		
		case "Strawberry Swirl":
			Cupcake strawberrySwirlRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getStrawberrySwirlIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Strawberry Swirl Red Velvet Cupcake", cupcakeUI.getStrawberrySwirlIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = strawberrySwirlRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Chunky Chocolate":
			Cupcake chunkyChocolateRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getChunkyChocolateIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Chunky Chocolate Red Velvet Cupcake", cupcakeUI.getChunkyChocolateIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = chunkyChocolateRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Bursting Blueberry":
			Cupcake burstingBlueberryRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getBurstingBlueberryIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Bursting Blueberry Red Velvet Cupcake", cupcakeUI.getBurstingBlueberryIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = burstingBlueberryRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Creamy Carrot":
			Cupcake creamyCarrotRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getCreamyCarrotIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Creamy Carrot Red Velvet Cupcake", cupcakeUI.getCreamyCarrotIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = creamyCarrotRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Green Apple":
			Cupcake greenAppleRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getGreenAppleIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Green Apple Red Velvet Cupcake", cupcakeUI.getGreenAppleIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = greenAppleRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Pumpkin Spice":
			Cupcake pumpkinSpiceRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getPumpkinSpiceIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Pumpkin Spice Red Velvet Cupcake", cupcakeUI.getPumpkinSpiceIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = pumpkinSpiceRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		case "Ruby Red Velvet":
			Cupcake rubyRedVelvetCupcake = new Cupcake(0, 0, cupcakeUI.getRubyRedVelvetIcing().getPrice() + cupcakeUI.getRedVelvetCupcake().getPrice(),
					 "Ruby Red Velvet Cupcake", cupcakeUI.getRubyRedVelvetIcing(), cupcakeUI.getRedVelvetCupcake());
			 cupcakeSelected = rubyRedVelvetCupcake;
			 cupcakeName = cupcakeSelected.getCupcakeName();
			 break;
			
		default: ;
	
			}
		
			try {
				root = FXMLLoader.load(getClass().getResource("/fxml/QuantitySelection.fxml"));

				scene2 = new Scene(root, 600, 500);
				scene2.getStylesheets().add("/fxml/styleSheet/quantitySelection.css");
				popOutStage = new Stage();
				popOutStage.setScene(scene2);
				popOutStage.initModality(Modality.WINDOW_MODAL);
				popOutStage.initOwner(cupcakeUI.getStage());
				popOutStage.showAndWait();
			} catch (IOException e) {

			}
		}
	}
	
	/**
	 * Method homeButtonClicked()
	 * 
	 * This method controls the functions of the Home button on the Cupcake Selection screen.
	 * The method loads the FXML and transitions to the Home screen.
	 * 
	 * @param event
	 */
	@FXML
	public void homeButtonClicked(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
			Parent root = (Parent)loader.load();
			cupcakeUI.getScene().setRoot(root);		
			
			icingFlavor = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method nextButtonClicked()
	 * 
	 * This method controls the functions of the Next button on the Cupcake Selection screen.
	 * The method loads the FXML and transitions to the Cupcake Transaction screen.
	 * 
	 * @param event
	 */
	@FXML
	public void nextButtonClicked(ActionEvent event) {

		if(isAddToCart) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CupcakeCheckout.fxml"));
				loader.setController(new CupcakeTransactionsController());
				Parent root = (Parent)loader.load();
				cupcakeUI.getScene().setRoot(root);
				cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/cupcakeCheckout.css");
			
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	/**
	 * Method editCartClicked()
	 * 
	 * This method controls the functions of the cart image on the Cupcake Selection screen.
	 * The method displays the Cupcakes in the cart.
	 * 
	 */
	@FXML 
	public void editCartClicked() {
		
		if(isCartSelect) {
		editCartList.setVisible(true);
		editCartList.getSelectionModel().getSelectedItem();
		int itemQuantity = 0;	
		
		for(Cupcake item : cart) {
			
			itemQuantity = item.getQuantity();
			
			menuList.add(itemQuantity + "  "  + item.getCupcakeName());
		}	
			System.out.println(menuList);
	
			editCartList.getItems().setAll(menuList);
			isCartSelect = false;
		}
		
		else if(!isCartSelect) {
			editCartList.setVisible(false);
			isCartSelect = true;
			menuList.clear();
		}
	}

	
	/**
	 * Method removeCupcakeClicked()
	 * 
	 * This method removes the cupcakes selected from the cart and restores the quantity.
	 * 
	 */
	@FXML
	public void removeCupcakeClicked() {
		editCartList.setVisible(false);

		String cartDescription;
		int tempNum1 = 0;
		int tempNum2 = 0; 
		
		for(int i = 0; i < cart.size(); i++) {
			
			cartDescription = cart.get(i).getQuantity() + "  " + cart.get(i).getCupcakeName();
			
				if(cartDescription.equals(editCartList.getSelectionModel().getSelectedItem())) {					
					
					tempNum1 = cart.get(i).getQuantity() + cart.get(i).getIcing().getQuantity();
					tempNum2 = cart.get(i).getQuantity() + cart.get(i).getCupcake().getQuantity();
					
					cart.get(i).getIcing().setQuantity(tempNum1);
					cart.get(i).getCupcake().setQuantity(tempNum2);
									
					editCartList.getItems().remove(editCartList.getSelectionModel().getSelectedItem());
					menuList.remove(editCartList.getSelectionModel().getSelectedItem());
					cart.remove(i);
				}			
		}
	}
	
	/**
	 * Method removeSelection()
	 * 
	 * This method disables the icings and cupcakes when removed by the Administrator.
	 * 
	 */
	public void removeSelection() {
		try {
		if(AdminController.isRemoved()) {
			for(int i = 0; i < AdminController.getAddRemoveNameList().size(); i++) {
				
			if(AdminController.getAddRemoveNameList().get(i).equals("Velvety Vanilla")) {
				vanillaIcing.setOpacity(0.4);
				vanillaIcing.setDisable(true);
			}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Strawberry Swirl")) {
				strawberryIcing.setOpacity(0.4);
				strawberryIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Chunky Chocolate")) {
				chocolateIcing.setOpacity(0.4);
				chocolateIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Bursting Blueberry")) {
				blueberryIcing.setOpacity(0.4);
				blueberryIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Creamy Carrot")) {
				carrotIcing.setOpacity(0.4);
				carrotIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Green Apple")) {
				appleIcing.setOpacity(0.4);
				appleIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Pumpkin Spice")) {
				pumpkinIcing.setOpacity(0.4);
				pumpkinIcing.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Ruby Red Velvet")) {
				redVelvetIcing.setOpacity(0.4);
				redVelvetIcing.setDisable(true);
				}	
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Vanilla")) {
				vanillaCupcake.setOpacity(0.4);
				vanillaCupcake.setDisable(true);
			}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Strawberry")) {
				strawberryCupcake.setOpacity(0.4);
				strawberryCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Chocolate")) {
				chocolateCupcake.setOpacity(0.4);
				chocolateCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Blueberry")) {
				blueberryCupcake.setOpacity(0.4);
				blueberryCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Carrot")) {
				carrotCupcake.setOpacity(0.4);
				carrotCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Apple")) {
				appleCupcake.setOpacity(0.4);
				appleCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Pumpkin")) {
				pumpkinCupcake.setOpacity(0.4);
				pumpkinCupcake.setDisable(true);
				}
			
			if(AdminController.getAddRemoveNameList().get(i).equals("Red Velvet")) {
				redVelvetCupcake.setOpacity(0.4);
				redVelvetCupcake.setDisable(true);
				}
		     }
			}
		} catch (Exception e) {

		}
	}
	
	/**
	 * Method addSelection()
	 * 
	 * This method enables the icings and cupcakes when added by the Administrator.
	 * 
	 */
	public void addSelection() {
		try {
		if(AdminController.isAdded()) {
			for(int i = 0; i < AdminController.getAddRemoveNameList().size(); i++) {
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Velvety Vanilla")) {
					vanillaIcing.setOpacity(1);
					vanillaIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
				}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Strawberry Swirl")) {
					strawberryIcing.setOpacity(1);
					strawberryIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Chunky Chocolate")) {
					chocolateIcing.setOpacity(1);
					chocolateIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Bursting Blueberry")) {
					blueberryIcing.setOpacity(1);
					blueberryIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Creamy Carrot")) {
					carrotIcing.setOpacity(1);
					vanillaIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Green Apple")) {
					appleIcing.setOpacity(1);
					appleIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Pumpkin Spice")) {
					pumpkinIcing.setOpacity(1);
					pumpkinIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Ruby Red Velvet")) {
					redVelvetIcing.setOpacity(1);
					redVelvetIcing.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Vanilla")) {
					vanillaCupcake.setOpacity(1);
					vanillaCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
				}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Strawberry")) {
					strawberryCupcake.setOpacity(1);
					strawberryCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Chocolate")) {
					chocolateCupcake.setOpacity(1);
					chocolateCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Blueberry")) {
					blueberryCupcake.setOpacity(1);
					blueberryCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Carrot")) {
					carrotCupcake.setOpacity(1);
					carrotCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Apple")) {
					appleCupcake.setOpacity(1);
					appleCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Pumpkin")) {
					pumpkinCupcake.setOpacity(1);
					pumpkinCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				
				if(AdminController.getAddRemoveNameList().get(i).equals("Red Velvet")) {
					redVelvetCupcake.setOpacity(1);
					redVelvetCupcake.setDisable(false);
					AdminController.getAddRemoveNameList().remove(i);
					}
				}
			}
		} catch (Exception e) {

		}
	}

	 /**
     * @return icingImage
     */
	@FXML
	public ImageView getIcingImage() {
		return icingImage;
	}
	
	 /**
	  * 
	  * @return icingIMG
	  */
	@FXML
	public Image getIcingIMG() {
		return icingIMG;
	}

	/**
	 * 
	 * @return cupcakeIMG
	 */
	public Image getCupcakeIMG() {
		return cupcakeIMG;
	}

	/**
	 * 
	 * @param cupcakeIMG
	 */
	public static void setCupcakeIMG(Image cupcakeIMG) {
		MainController.cupcakeIMG = cupcakeIMG;
	}

	/**
	 * 
	 * @param icingIMG
	 */
	public static void setIcingIMG(Image icingIMG) {
		MainController.icingIMG = icingIMG;
	}

	/**
	 * 
	 * @return
	 */
	public static MainController getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param instance
	 */
	public static void setInstance(MainController instance) {
		MainController.instance = instance;
	}

	/**
	 * 
	 * @return icingFlavor
	 */
	public static String getIcingFlavor() {
		return icingFlavor;
	}

	/**
	 * 
	 * @param icingFlavor
	 */
	public static void setIcingFlavor(String icingFlavor) {
		MainController.icingFlavor = icingFlavor;
	}

	/**
	 * 
	 * @return cupcakeFlavor
	 */
	public String getCupcakeFlavor() {
		return cupcakeFlavor;
	}

	/**
	 * 
	 * @param cupcakeFlavor
	 */
	public static void setCupcakeFlavor(String cupcakeFlavor) {
		MainController.cupcakeFlavor = cupcakeFlavor;
	}

	/**
	 * 
	 * @return cupcakeName
	 */
	public static String getCupcakeName() {
		return cupcakeName;
	}

	/**
	 * 
	 * @param cupcakeName
	 */
	public static void setCupcakeName(String cupcakeName) {
		MainController.cupcakeName = cupcakeName;
	}

	/**
	 * 
	 * @return cupcakeSelected
	 */
	public static Cupcake getCupcakeSelected() {
		return cupcakeSelected;
	}

	/**
	 * 
	 * @param cupcakeSelected
	 */
	public static void setCupcakeSelected(Cupcake cupcakeSelected) {
		MainController.cupcakeSelected = cupcakeSelected;
	}

	/**
	 * 
	 * @return icingChoiceObject
	 */
	public static Icing getIcingChoiceObject() {
		return icingChoiceObject;
	}

	/**
	 * 
	 * @param icingChoiceObject
	 */
	public static void setIcingChoiceObject(Icing icingChoiceObject) {
		MainController.icingChoiceObject = icingChoiceObject;
	}

	/**
	 * 
	 * @return cupcakeChoiceObject
	 */
	public static Cupcake getCupcakeChoiceObject() {
		return cupcakeChoiceObject;
	}

	/**
	 * 
	 * @param cupcakeChoiceObject
	 */
	public static void setCupcakeChoiceObject(Cupcake cupcakeChoiceObject) {
		MainController.cupcakeChoiceObject = cupcakeChoiceObject;
	}

	/**
	 * 
	 * @return popOutStage
	 */
	public static Stage getPopOutStage() {
		return popOutStage;
	}

	/**
	 * 
	 * @param popOutStage
	 */
	public static void setPopOutStage(Stage popOutStage) {
		MainController.popOutStage = popOutStage;
	}

	/**
	 * 
	 * @return scene2
	 */
	public static Scene getScene2() {
		return scene2;
	}

	/**
	 * 
	 * @param scene2
	 */
	public static void setScene2(Scene scene2) {
		MainController.scene2 = scene2;
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

	/**
	 * 
	 * @return carrotCupcake
	 */
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
	 * @param vanillaIcing
	 */
	public void setVanillaIcing(ImageView vanillaIcing) {
		this.vanillaIcing = vanillaIcing;
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

	/**
	 * 
	 * @return cart
	 */
	public List<Cupcake> getCart() {
		return cart;
	}

	/**
	 * 
	 * @param cart
	 */
	public static void setCart(ArrayList<Cupcake> cart) {
		MainController.cart = cart;
	}

	/**
	 * 
	 * @return isAddToCart
	 */
	public static boolean isAddToCart() {
		return isAddToCart;
	}

	/**
	 * 
	 * @param isAddToCart
	 */
	public static void setAddToCart(boolean isAddToCart) {
		MainController.isAddToCart = isAddToCart;
	}
}
