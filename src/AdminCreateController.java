import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/*
 * Class: AdminCreateController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the Cupcake creation screen.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the Cupcake creation screen,
 * 					 and creates a new Icing & Cupcake with the id, name, price, quantity, and selection of image.
 * 
 */
public class AdminCreateController implements Initializable{
	
	private static AdminCreateController instance = new AdminCreateController();
	private CupcakeUI cupcakeUI = new CupcakeUI();
	//private Icing icing;
	private static Cupcake cupcake;
	
	@FXML
	private TextField nameTextField, idTextField, quantityTextField, priceTextField, xPosTextField, yPosTextField;
	@FXML 
	protected ImageView imageDisplay;
	private static Image image;
	private Icing icing;
	
	private String textName; 
	private int textId, textQuantity, textXPos,textYPos;
	
	private double textPrice;
	private static ArrayList<Icing> icingCreatedList = new ArrayList<Icing>();
	int count = 0;


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
	 * Method chooseImageClicked()
	 * 
	 * This method gets the image chose by the Administrator.
	 * 
	 */
	@FXML
	public void chooseImageClicked() {
		
		FileChooser chooser = new FileChooser();
		chooser.setTitle("Open Image File");
		    
		File file = chooser.showOpenDialog(new Stage());
		 
	    if(file != null) {
	        String imagepath = null;
			try {
				imagepath = file.toURI().toURL().toString();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	        
	        Image image = new Image(imagepath);
	        imageDisplay.setImage(image);	    	
	    	} 
	    
	    else {
	        Alert alert = new Alert(Alert.AlertType.INFORMATION);
	        alert.setTitle("Information Dialog");
	        alert.setHeaderText("Please Select a File");
	        alert.showAndWait();
	    	}
			
	}
	
	/**
	 * Method cancelButtonClicked()
	 * 
	 * This method closes the stage.
	 * 
	 */
	@FXML
	public void cancelButtonClicked() {
		AdminController.popOutStage.close();
	}
	
	/**
	 * Method createButtonClicked()
	 * 
	 * This method creates an object for the new icing and cupcake created.
	 * 
	 */
	@FXML
	public void createButtonClicked() {
		gatherInfo();
		icing = new Icing(textId, textQuantity, textPrice, textName, imageDisplay);

		CupcakeUI.getIcingArray().add(icing);
	//	System.out.println(CupcakeUI.getIcingArray());

		icingCreatedList.add(icing);
		//System.out.println(icingCreatedList.size());
		//System.out.println(icingCreatedList);

		
	
		    imageDisplay.setLayoutX(textXPos);
		    imageDisplay.setLayoutY(textYPos);
		    
		AdminController.popOutStage.close();
		AdminController.getInstance().getAdminAnchorPane().getChildren().add(imageDisplay);
		
	}
	
	/**
	 * Method gatherInfo()
	 * 
	 * This method gathers the info from the text fields.
	 * 
	 */
	public void gatherInfo() {
		int temp1;
		double temp2;
		
		try {
		textName = nameTextField.getText();
		
		temp1 = Integer.parseInt(idTextField.getText());
		textId = temp1; 
		
		temp1 = Integer.parseInt(quantityTextField.getText());
     	textQuantity = temp1;
		
		temp2 = Double.parseDouble(priceTextField.getText());
		textPrice = temp2;
		
		temp1 = Integer.parseInt(xPosTextField.getText());
     	textXPos = temp1;
     	
     	temp1 = Integer.parseInt(yPosTextField.getText());
     	textYPos = temp1;
		}catch(Exception e) {
			
		}
	
	}

	/**
	 * 
	 * @return imageDisplay
	 */
	public ImageView getImageDisplay() {
		return imageDisplay;
	}

	/**
	 * 
	 * @param imageDisplay
	 */
	public void setImageDisplay(ImageView imageDisplay) {
		this.imageDisplay = imageDisplay;
	}

	/**
	 * 
	 * @return image
	 */
	public static Image getImage() {
		return image;
	}

	/**
	 * 
	 * @param image
	 */
	public static void setImage(Image image) {
		AdminCreateController.image = image;
	}

	/**
	 * 
	 * @return instance
	 */
	public static AdminCreateController getInstance() {
		return instance;
	}
	
	/**
	 * 
	 * @param instance
	 */
	public static void setInstance(AdminCreateController instance) {
		AdminCreateController.instance = instance;
	}

	/**
	 * 
	 * @return icing
	 */
	public Icing getIcing() {
		return icing;
	}

	/**
	 * 
	 * @param icing
	 */
	public void setIcing(Icing icing) {
		this.icing = icing;
	}

	/**
	 * 
	 * @return icingCreatedList
	 */
	public static ArrayList<Icing> getIcingCreatedList() {
		return icingCreatedList;
	}

	/**
	 * 
	 * @param icingCreatedList
	 */
	public static void setIcingCreatedList(ArrayList<Icing> icingCreatedList) {
		AdminCreateController.icingCreatedList = icingCreatedList;
	}
}
