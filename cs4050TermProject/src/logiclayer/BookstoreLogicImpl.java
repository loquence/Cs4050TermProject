package logiclayer;

import persistlayer.BookstorePersistImpl;
import objectlayer.*;
public class BookstoreLogicImpl {
	BookstorePersistImpl bookstorePersist;
	
	public BookstoreLogicImpl() {
		bookstorePersist = new BookstorePersistImpl();
	}
	
	public int createUser(User u) {		
		return bookstorePersist.addUser(u);
	}
	
	public int login(String email, String pwd) {
		return bookstorePersist.login(email,pwd);
	}
}
