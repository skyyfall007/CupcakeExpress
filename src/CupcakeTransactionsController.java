import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/*
 * Class: CupcakeTransactionController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the transaction screen.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the transaction screen,
 * 					 and handles the calculations for each Icing & Cupcake selected.
 * 
 */
public class CupcakeTransactionsController implements Initializable { 

	@FXML 
	private Label insertCardLabel, insertCashLabel;
	@FXML
	private ImageView insertCardImage, creditCardImage;
	@FXML
	private ScrollPane scrollPane;
	@FXML
	private Label subTotalLabel, taxLabel, totalLabel;
	@FXML
	private TableView<ImageView> table;
	
	private CupcakeUI cupcakeUI = new CupcakeUI();
	private boolean isCash, isCredit;
	private Thread thread;
	private TableColumn<ImageView, ImageView> column; 
	private TableCell<ImageView, ImageView> cell;
	private ObservableList<ImageView> imageList;
	private ObservableList<String> attributeList;

	/**
	 * Method initialize()
	 * 
	 * This method is called upon when the FXML loader loads this controller.
	 * The method sets each cupcake selected onto a table view
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		for(Cupcake item : MainController.getInstance().getCart()) {
			if(item != null) {
			table.setSelectionModel(null);
			column = new TableColumn<>(item.getCupcakeName());
			column.setMinWidth(400);
			       
			column.setCellFactory(new Callback<TableColumn<ImageView, ImageView>, TableCell<ImageView, ImageView>>() {
	           
				@Override
	            public TableCell<ImageView, ImageView> call(TableColumn<ImageView, ImageView> param) {
	                return new TableCell<ImageView, ImageView>() {	            	
	             
		            	HBox box;
		            	Label attributeLabel;
		            	ImageView image1, image2;
		            	
		            	{
		            		
		            	//for(int i = 0; i < MainController.getInstance().getCart().size(); i++) {
		            /*	image1 = new ImageView();
		            	image1 = item.getIcing().getImage();
		            	
		            	image2 = new ImageView();
		            	image2 = item.getCupcake().getImage();
		            	
		            	image1.setFitHeight(150);
    	            	image1.setFitWidth(150);					//USING ONLY ONE ICING OR CUPCAKE FOR EACH SELECTION
    	            	image2.setFitHeight(150);
    	            	image2.setFitWidth(150);
    	            	*/
		            	
		            	}

		            	@Override
	                    public void updateItem(ImageView image, boolean empty) {
	                    	setStyle("-fx-background-color:#fdf5e6");
	                    	//Set up the ImageView
	    	            	
	                    	box = new HBox();
	                    	box.setAlignment(Pos.CENTER);
	                    	box.setMinWidth(400);
	                    	
	                    		
			            		
			            //	image1 = new ImageView();
			            	image1 = item.getIcing().getImage();
			            	
			          //  	image2 = new ImageView();
			            	image2 = item.getCupcake().getImage();
			            	
			            	image1.setFitHeight(150);
			            	image1.setFitWidth(150);					//USING ONLY ONE ICING OR CUPCAKE FOR EACH SELECTION
	    	            	image2.setFitHeight(150);
	    	            	image2.setFitWidth(150);
	                    	
	                    	
	                    //	imageList.add(image1);
	                    //	imageList.add(image2);
	                    	System.out.println(imageList);
	                    	
	                    	attributeLabel = new Label("     X " + item.getQuantity());
	                    	attributeLabel.setStyle("-fx-text-fill:red");
	                    	box.getChildren().add(image1);
	                    	box.getChildren().add(image2); 
	                    	box.getChildren().add(attributeLabel);
	    	               
	                    	setGraphic(box);	    
	                    }	                
	                };
				}
	        });
			
			table.getColumns().add(column);
			
			//attributeList = FXCollections.observableArrayList();
			imageList = FXCollections.observableArrayList(item.getIcing().getImage());
			}
			table.setItems(imageList);	

		}

		calculate();
	}

	/**
	 * Method creditCardClicked()
	 * 
	 * This method controls the functions of the credit card  image on the Cupcake Transaction screen.
	 * The method sets the credit card image & label to visible.
	 * 
	 */
	@FXML
	public void creditCardClicked() {
		isCash = true;
		isCredit = false;
		
		insertCardLabel.setVisible(true);
		insertCardImage.setVisible(true);
		insertCashLabel.setVisible(false);
	}
	
	/**
	 * Method cashClicked()
	 * 
	 * This method controls the functions of the cash image on the Cupcake Transaction screen.
	 * The method sets the cash image & label to visible.
	 * 
	 */
	@FXML
	public void cashClicked() {
		isCredit = true;
		isCash = false;
		
		insertCashLabel.setVisible(true);
		insertCardLabel.setVisible(false);
		insertCardImage.setVisible(false);
	}
	
	/**
	 * Method calculate()
	 * 
	 * This method calculates the subtotal, tax, total for each icing and cupcake.
	 * 
	 */
	public void calculate() {
		DecimalFormat formatter = new DecimalFormat("0.00");
		String formatCurrency;
		double subTotal = 0;
		double tax = 0;
		double total = 0;
				
		for(int i = 0; i < MainController.getInstance().getCart().size(); i++) {
			subTotal = subTotal + MainController.getInstance().getCart().get(i).getPrice() * MainController.getInstance().getCart().get(i).getQuantity();
		}
		
		formatCurrency = formatter.format(subTotal);
		subTotalLabel.setText("SubTotal:     $ " + formatCurrency);
		
		tax = 0.07 * subTotal;
		formatCurrency = formatter.format(tax);
		this.taxLabel.setText("Sales tax:      $ " + formatCurrency);
		
		total = tax + subTotal;
		formatCurrency = formatter.format(total);
		this.totalLabel.setText("Total:             $ " + formatCurrency);
	}
	
	/**
	 * Method submitButtonClicked()
	 * 
	 * This method submits the payment and loads the FXML to transition to the Cupcake Processing screen.
	 * 
	 */
	@FXML
	public void submitButtonClicked() {
		if(isCash || isCredit) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CupcakeProcessing.fxml"));
				Parent root = (Parent)loader.load();
				cupcakeUI.getScene().setRoot(root);
				cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/cupcakeProcessing.css");

			} catch (IOException e) {
				e.printStackTrace();
			}	
		
		processing();
		}
	}

	/**
	 * Method backButtonClicked()
	 * 
	 * This method loads the FXML and returns to the Cupcake Selection screen.
	 * 
	 */
	@FXML
	public void backButtonClicked() {
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CupcakeSelection.fxml"));
			loader.setController(MainController.getInstance());
			Parent root = (Parent)loader.load();
			cupcakeUI.getScene().setRoot(root);
			
			MainController.setIcingFlavor(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MainController.getInstance().removeSelection();
		MainController.getInstance().addSelection();
	}
	
	/**
	 * Method processing()
	 * 
	 * This method represents the processing of the credit card and cash by running a thread.
	 * 
	 */
	public void processing() {	
		
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(4000);
					}catch(Exception e) {
					e.printStackTrace();
					}
				
				Platform.runLater( new Runnable() {
					@Override
					public void run() {
						//Sets the Scene to the Receipt Screen
						try {
							Parent root = (Parent) FXMLLoader.load(getClass().getResource("/fxml/CupcakeReceipt.fxml"));
							cupcakeUI.getScene().setRoot(root);
							cupcakeUI.getScene().getStylesheets().add("/fxml/styleSheet/cupcakeReceipt.css");
						} catch (IOException e) {
							e.printStackTrace();
						}
					  }
					});				
				}
		});
		//Starts the Thread
		thread.start();	
	}	
}
