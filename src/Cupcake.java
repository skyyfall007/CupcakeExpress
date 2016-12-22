import javafx.scene.image.ImageView;

/*
 * Class: Cupcake
 * 
 * @author Jawan Higgins, Adele Francois, & Lance Toornman
 * @version 1.0 Course : ITEC 3860, Summer, 2016 Written: July 1, 2016
 * 
 * 			This class represents the Cupcake entity object with it's attributes.
 * 
 * 			Purpose: This class is the representation that creates an Cupcake upon being instantiated with 
 * 						the 'new' keyword.
 * 
 */
public class Cupcake {
	private int id;
	private int quantity;
	private double price;
	private String cupcakeName;
	private Icing icing;
	private Cupcake cupcake;
	private ImageView image;

	/**
	 * 
	 * @param id
	 * @param quantity
	 * @param price
	 * @param cupcakeName
	 */
	public Cupcake(int id, int quantity, double price, String cupcakeName, ImageView image) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.cupcakeName = cupcakeName;
		this.image = image;
	}
	
	/**
	 * 
	 * @param id
	 * @param quantity
	 * @param price
	 * @param cupcakeName
	 * @param icing
	 * @param cupcake
	 */
	public Cupcake(int id, int quantity, double price, String cupcakeName, Icing icing, Cupcake cupcake) {
		this.id = id;
		this.price = price;
		this.cupcakeName = cupcakeName;
		this.cupcake = cupcake;
		this.icing = icing;
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
	public String getCupcakeName() {
		return cupcakeName;
	}

	/**
	 * 
	 * @param cupcakeName
	 */
	public void setCupcakeName(String cupcakeName) {
		this.cupcakeName = cupcakeName;
	}
	
	/**
	 * 
	 * @return
	 */
	public Icing getIcing() {
		return icing;
	}

	/**
	 * 
	 * @return
	 */
	public Cupcake getCupcake() {
		return cupcake;
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
	 * @param cupcake
	 */
	public void setCupcake(Cupcake cupcake) {
		this.cupcake = cupcake;
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
