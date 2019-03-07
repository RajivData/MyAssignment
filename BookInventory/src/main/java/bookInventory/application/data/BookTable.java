package bookInventory.application.data;

import java.util.HashSet;
import java.util.Set;

import bookInventory.application.model.Book;
/**
 * 
 * @author RAJIV
 *
 */
public class BookTable {
	private static Set<Book> bookstable=new HashSet<>();

	static {
		Book book = new Book();
		book.setBookId(100);
		book.setBookName("Core Java");
		book.setBookCategory("Computer Science");
		
		Book book2 = new Book();
		book2.setBookId(200);
		book2.setBookName("C++");
		book2.setBookCategory("Computer Science");
		
		bookstable.add(book);
		bookstable.add(book2);
	}
	/**
	 * 
	 * @return Books
	 */
	public static Set<Book> books() {
		return bookstable;
	}
}
