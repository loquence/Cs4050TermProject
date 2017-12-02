package objectlayer;

import javax.swing.text.html.ImageView;

public class Book {
	
	private String ISBN;
	private String title;
	private String genre;
	private String author;	//should split into f and l?
	private int edition;
	private String publisher;
	private int publicationYear;
	private int quantity;
	private int rating;
	private String cover;	//Should be path to where images are stored
	private double sellingPrice;
	private double buyingPrice;
	private int minThreshold;
	
	public Book(String iSBN, String title, String genre, String author, int edition, String publisher, int publicationYear,
			int quantity, /*int rating,*/ String cover, double sellingPrice, double buyingPrice, int minThreshold) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.quantity = quantity;
		//this.rating = rating;
		this.cover = cover;
		this.sellingPrice = sellingPrice;
		this.buyingPrice = buyingPrice;
		this.minThreshold = minThreshold;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	
	public int getMinThreshold() {
		return minThreshold;
	}
	public void setMinThreshold(int minThreshold) {
		this.minThreshold = minThreshold;
	}
	
}
