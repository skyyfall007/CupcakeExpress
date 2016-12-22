import javafx.scene.image.ImageView;

/*
 * Class: Icing
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class represents the Icing entity object with it's attributes.
 * 
 * 			Purpose: This class is the representation that creates an Icing upon being instantiated with 
 * 						the 'new' keyword.
 * 
 */
public class Icing {
	private int id;
	private int quantity;
	private double price;
	private String icingName;
	private ImageView image;

	/**
	 * 
	 * @param id
	 * @param quantity
	 * @param price
	 * @param cupcakeName
	 */
	public Icing(int id, int quantity, double price, String icingName, ImageView image) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.icingName = icingName;
		this.image = image;
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 */
	public String getIcingName() {
		return icingName;
	}

	/**
	 * 
	 * @param cupcakeName
	 */
	public void setIcingName(String icingName) {
		this.icingName = icingName;
	}

	/**
	 * 
	 * @return image
	 */
	public ImageView getImage() {
		return image;
	}

	/**
	 * 
	 * @param image
	 */
	public void setImage(ImageView image) {
		this.image = image;
	}
}
