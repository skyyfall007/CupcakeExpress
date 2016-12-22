import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

/*
 * Class: ReceiptController
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class is the controller of the receipt screen.
 * 
 * 			Purpose: This class controls the actions or behaviors of every Node present on the receipt screen,
 * 					 which prints the information about the purchase.
 * 
 */
public class ReceiptController implements Initializable{

	@FXML
	private Label receiptSubTotalLabel, receiptTaxLabel, receiptTotalLabel, receiptChangeLabel, dateLabel;
	@FXML
	private ListView<String> receiptListView;
	
	private CupcakeUI cupcakeUI = new CupcakeUI();
	private ObservableList<String> recieptObservableList = FXCollections.observableArrayList();	
	
	/**
	 * Method initialize()
	 * 
	 * This method is called upon when the FXML loader loads this controller.
	 * The method calls the list of cupcakes, receipt totals and the date.
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cupcakeList();
		receipt();
		date();
	}
	
	/**
	 * Method cupcakeList()
	 * 
	 * This method prints the list of cupcakes to the receipt.
	 * 
	 */
	public void cupcakeList() {
		int itemQuantity = 0;	
		double itemPrice = 0;
		double itemTotal = 0;
		
		for(Cupcake item : MainController.getInstance().getCart()) {
			
			itemQuantity = item.getQuantity();
			itemPrice = item.getPrice();
			itemTotal =  itemPrice * itemQuantity;
			
			if(item.getCupcakeName().length() >= 33) {
				recieptObservableList.add(item.getCupcakeName() + "    " + itemQuantity 
					+ "      " +  itemPrice + "      " + itemTotal);
			}
			
			else if(item.getCupcakeName().length() > 25 && item.getCupcakeName().length() <= 32) {
					recieptObservableList.add(item.getCupcakeName() + "               " + itemQuantity 
							+ "      " +  itemPrice + "     " + itemTotal);
				}
			
			else if(item.getCupcakeName().length() >= 20 && item.getCupcakeName().length() <= 25) {
				recieptObservableList.add(item.getCupcakeName() + "                           " + itemQuantity 
						+ "      " +  itemPrice + "       " + itemTotal);
			}
			
			else {
				recieptObservableList.add(item.getCupcakeName() + "                               " + itemQuantity 
						+ "      " +  itemPrice + "       " + itemTotal);
			}
		}	
	
			receiptListView.getItems().setAll(recieptObservableList);
	}
	
	/**
	 * Method receipt()
	 * 
	 * This method sets the subtotal,tax and total.
	 * 
	 */
	public void receipt() {
		DecimalFormat formatter = new DecimalFormat("0.00");
		String formatCurrency;
		double subTotal = 0;
		double tax = 0;
		double total = 0;
				
		for(int i = 0; i < MainController.getInstance().getCart().size(); i++) {
			subTotal = subTotal + MainController.getInstance().getCart().get(i).getPrice() * MainController.getInstance().getCart().get(i).getQuantity();
		}
		
		formatCurrency = formatter.format(subTotal);
		receiptSubTotalLabel.setText("SubTotal:     $ " + formatCurrency);
		
		tax = 0.07 * subTotal;
		formatCurrency = formatter.format(tax);
		receiptTaxLabel.setText("Sales tax:      $ " + formatCurrency);
		
		total = tax + subTotal;
		formatCurrency = formatter.format(total);
		receiptTotalLabel.setText("Total:             $ " + formatCurrency);
		
		receiptChangeLabel.setText("Change:        $0.00");
	}
	
	/**
	 * Method date()
	 * 
	 * This method sets the date on the receipt.
	 * 
	 */
	public void date() {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Date date = new Date();

		dateLabel.setText("" + dateFormat.format(date));
	}
	
	/**
	 * Method homeButtonClicked()
	 * 
	 * This method load the FXML and transitions to the Home screen
	 * 
	 * @param event
	 */
	@FXML
	public void homeButtonClicked(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			cupcakeUI.getScene().setRoot(root);
			
			MainController.setIcingFlavor(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		MainController.getInstance().getCart().clear();
	}
	
	/**
	 * Method date()
	 * 
	 * This method prints the receipt.
	 * 
	 */
	@FXML
	public void print() {
				   
    	//Displays an Alert Message Dialog Box
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("PRINTER");
    	alert.setHeaderText(null);
    	alert.setContentText("          PRINTING.........");
    	alert.show();
	}
}
