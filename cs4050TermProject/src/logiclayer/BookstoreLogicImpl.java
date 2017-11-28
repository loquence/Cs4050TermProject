package logiclayer;

import persistlayer.BookstorePersistImpl;
import objectlayer.*;
public class BookstoreLogicImpl {
	private BookstorePersistImpl bookstorePersist;
	
	public BookstoreLogicImpl() {
		bookstorePersist = new BookstorePersistImpl();
	}
	/*
	public int createCustomer(Customer u) {		
		return bookstorePersist.addCustomer(u);
	}
	*/
	public User checkEmail(String email){
		return bookstorePersist.checkEmail(email);
	}
	
	public int checkCode(String code) {
		return bookstorePersist.checkCode(code);
	}
	
	public int verifyCode(String email, String code) {
		return bookstorePersist.verifyCode(email, code);
	}
	
	
	
}
