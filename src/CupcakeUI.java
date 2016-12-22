import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/*
 * Class: CupcakeUI
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the main unit of the application that is in control of the initial stage and the creation of Cupcakes.
 * 
 * 			Purpose: This class creates each initial Icing and Cupcake and sets the attributes to each Cupcake.
 * 
 */
public class CupcakeUI extends Application {

	protected static final int WIDTH = 900;
	protected static final int HEIGHT = 750;
	protected static Stage stage, popOutStage;
	protected static Scene scene;
	private static Icing velvetyVanillaIcing, chunkyChocolateIcing,
			strawberrySwirlIcing, greenAppleIcing, burstingBlueberryIcing,
			creamyCarrotIcing, pumpkinSpiceIcing, rubyRedVelvetIcing;
	private static Cupcake vanillaCupcake, strawberryCupcake, chocolateCupcake,
			blueberryCupcake, carrotCupcake, appleCupcake, pumpkinCupcake, redVelvetCupcake;		
	private static ArrayList<Icing> icingArray = new ArrayList<Icing>();
	private static ArrayList<Cupcake> cupcakeArray = new ArrayList<Cupcake>();

	/**
	 * Method start()
	 * 
	 * This method is the starts the stage from the Application class.
	 * 
	 * @param primaryStage
	 * 
	 */
	public void start(Stage primaryStage) throws Exception {

		try {
		Parent root1 = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
		stage = primaryStage;
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);
		// Sets the scene to the Home Screen
		scene = new Scene(root1, WIDTH, HEIGHT);
		scene.getStylesheets().add("/fxml/styleSheet/main.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("Cupcake Vending Machine");
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> {
			primaryStage.close();
			System.exit(0);
		});		
		
		createCupcakes();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method createCupcake()
	 * 
	 * This method creates an inventory of icings and cupcake with their attributes.
	 *	  
	 */
	public void createCupcakes() {
	
		// Creates Icing Objects
		velvetyVanillaIcing = new Icing(1, 10, .99, "Velvety Vanilla Icing", new ImageView(new Image("Vanilla Icing (Project).png")));
		chunkyChocolateIcing = new Icing(2, 10, .99, "Chunky Chocolate Icing", new ImageView(new Image("Chocolate Icing (Project).png")));
		strawberrySwirlIcing = new Icing(3, 10, .99, "Strawberry Swirl Icing", new ImageView(new Image("Strawberry Icing (Project).png")));
		burstingBlueberryIcing = new Icing(4, 10, .99, "Bursting Blueberry Icing", new ImageView(new Image("Blueberry Icing .png")));
		creamyCarrotIcing = new Icing(5, 10, .99, "Creamy Carrot Icing", new ImageView(new Image("Carrot Icing (Project).png")));
		greenAppleIcing = new Icing(6, 10, .99, "Green Apple Icing", new ImageView(new Image("Apple Icing (Project).png")));
		pumpkinSpiceIcing = new Icing(7, 10, .99, "Pumpkin Spice Icing", new ImageView(new Image("Pumpkin Icing.png")));
		rubyRedVelvetIcing = new Icing(8, 10, .99, "Ruby Red Velvet Icing", new ImageView(new Image("RedVelvetIcing.png")));

		// Creates Cupcake Bottom Objects
		vanillaCupcake = new Cupcake(1, 10, 1.99, "Vanilla Cupcake", new ImageView(new Image("Vanilla Cupcake (Project).png")));
		strawberryCupcake = new Cupcake(2, 10, 1.99, "Strawberry Cupcake", new ImageView(new Image("Strawberry Cupcake (Project).png")));
		chocolateCupcake = new Cupcake(3, 10, 1.99, "Chocolate Cupcake", new ImageView(new Image("Chocolate Cupcake (Project).png")));
		blueberryCupcake = new Cupcake(4, 10, 1.99, "Blueberry Cupcake", new ImageView(new Image("blueberry cupcake base.png")));
		carrotCupcake = new Cupcake(5, 10, 1.99, "Carrot Cupcake", new ImageView(new Image("Carrot Cupcake (Project).png")));
		appleCupcake = new Cupcake(6, 10, 1.99, "Apple Cupcake", new ImageView(new Image("Apple Cupcake (Project).png")));
		pumpkinCupcake = new Cupcake(7, 10, 1.99, "Pumpkin Cupcake", new ImageView(new Image("Pumpkin Cupcake Base.png")));
		redVelvetCupcake = new Cupcake(8, 10, 1.99, "Red Velvet Cupcake", new ImageView(new Image("Red Velvet Cupcake (Project).png")));
		
		icingArray.add(velvetyVanillaIcing);
		icingArray.add(strawberrySwirlIcing);
		icingArray.add(chunkyChocolateIcing);
		icingArray.add(burstingBlueberryIcing);
		icingArray.add(creamyCarrotIcing);
		icingArray.add(greenAppleIcing);
		icingArray.add(pumpkinSpiceIcing);
		icingArray.add(rubyRedVelvetIcing);
		
		cupcakeArray.add(vanillaCupcake);
		cupcakeArray.add(strawberryCupcake);
		cupcakeArray.add(chocolateCupcake);
		cupcakeArray.add(blueberryCupcake);
		cupcakeArray.add(carrotCupcake);
		cupcakeArray.add(appleCupcake);
		cupcakeArray.add(pumpkinCupcake);
		cupcakeArray.add(redVelvetCupcake);

	}

	/**
	 * 
	 * @return scene
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * 
	 * @return popOutStage
	 */
	public Stage getPopOutStage() {
		return popOutStage;
	}

	/**
	 * 
	 * @return WIDTH
	 */
	public static int getWidth() {
		return WIDTH;
	}

	/**
	 * 
	 * @return HEIGHT
	 */
	public static int getHeight() {
		return HEIGHT;
	}

	/**
	 * 
	 * @return stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * 
	 * @return velvetyVanillaIcing
	 */
	public Icing getVelvetyVanillaIcing() {
		return velvetyVanillaIcing;
	}

	/**
	 * 
	 * @return chunkyChocolateIcing
	 */
	public Icing getChunkyChocolateIcing() {
		return chunkyChocolateIcing;
	}

	/**
	 * 
	 * @return strawberrySwirlIcing
	 */
	public Icing getStrawberrySwirlIcing() {
		return strawberrySwirlIcing;
	}

	/**
	 * 
	 * @return burstingBlueberryIcing
	 */
	public Icing getBurstingBlueberryIcing() {
		return burstingBlueberryIcing;
	}

	/**
	 * 
	 * @return creamyCarrotIcing
	 */
	public Icing getCreamyCarrotIcing() {
		return creamyCarrotIcing;
	}

	/**
	 * 
	 * @return greenAppleIcing
	 */
	public Icing getGreenAppleIcing() {
		return greenAppleIcing;
	}

	/**
	 * 
	 * @return rubyRedVelvetIcing
	 */
	public Icing getRubyRedVelvetIcing() {
		return rubyRedVelvetIcing;
	}

	/**
	 * 
	 * @return pumpkinSpiceIcing
	 */
	public Icing getPumpkinSpiceIcing() {
		return pumpkinSpiceIcing;
	}

	/**
	 * 
	 * @return vanillaCupcake
	 */
	public Cupcake getVanillaCupcake() {
		return vanillaCupcake;
	}

	/**
	 * 
	 * @return strawberryCupcake
	 */
	public Cupcake getStrawberryCupcake() {
		return strawberryCupcake;
	}

	/**
	 * 
	 * @return chocolateCupcake
	 */
	public Cupcake getChocolateCupcake() {
		return chocolateCupcake;
	}

	/**
	 * 
	 * @return blueberryCupcake
	 */
	public Cupcake getBlueberryCupcake() {
		return blueberryCupcake;
	}

	/**
	 * 
	 * @return carrotCupcake
	 */
	public Cupcake getCarrotCupcake() {
		return carrotCupcake;
	}

	/**
	 * 
	 * @return appleCupcake
	 */
	public Cupcake getAppleCupcake() {
		return appleCupcake;
	}

	/**
	 * 
	 * @return pumpkinCupcake
	 */
	public Cupcake getPumpkinCupcake() {
		return pumpkinCupcake;
	}

	/**
	 * 
	 * @return redVelvetCupcake
	 */
	public Cupcake getRedVelvetCupcake() {
		return redVelvetCupcake;
	}

	/**
	 * 
	 * @return icingArray
	 */
	public static ArrayList<Icing> getIcingArray() {
		return icingArray;
	}

	/**
	 * 
	 * @return cupcakeArray
	 */
	public static ArrayList<Cupcake> getCupcakeArray() {
		return cupcakeArray;
	}

	/**
	 * 
	 * @param icingArray
	 */
	public static void setIcingArray(ArrayList<Icing> icingArray) {
		CupcakeUI.icingArray = icingArray;
	}

	/**
	 * 
	 * @param cupcakeArray
	 */
	public static void setCupcakeArray(ArrayList<Cupcake> cupcakeArray) {
		CupcakeUI.cupcakeArray = cupcakeArray;
	}
}
