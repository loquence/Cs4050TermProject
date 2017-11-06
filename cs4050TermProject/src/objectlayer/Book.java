package objectlayer;

import javax.swing.text.html.ImageView;

public class Book {
	
	private int ISBN;
	private String title;
	private String genre;
	private String author;	//should split into f and l?
	private int edition;
	private String publisher;
	private int publicationYear;
	private int threshold;
	private int quantity;
	private int rating;
	private String cover;	//Should be path to where images are stored
	private int sellingPrice;
	private int buyingPrice;
	private int minThreshold;
	
	public Book(int iSBN, String title, String genre, String author, int edition, String publisher, int publicationYear,
			int quantity, int rating, ImageView cover, int sellingPrice, int buyingPrice, int minThreshold) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.genre = genre;
		this.author = author;
		this.edition = edition;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.quantity = quantity;
		this.rating = rating;
		this.cover = cover;
		this.sellingPrice = sellingPrice;
		this.buyingPrice = buyingPrice;
		this.minThreshold = minThreshold;
	}
	
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
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
	
	public ImageView getCover() {
		return cover;
	}
	public void setCover(ImageView cover) {
		this.cover = cover;
	}
	
	public int getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	
	public int getBuyingPrice() {
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
