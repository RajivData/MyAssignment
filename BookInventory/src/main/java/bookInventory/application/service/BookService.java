package bookInventory.application.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import bookInventory.application.data.BookTable;
import bookInventory.application.model.Book;

/**
 * 
 * @author RAJIV
 *
 */
@Service
public class BookService {
    /**
     * Get Book Details by Book Id
     * @param bookId
     * @return Book
     */
	public Book getBookById(int bookId) {
		Set<Book> bookList = BookTable.books();
		Book book = bookList.stream().filter(b -> b.getBookId() == bookId).findAny().orElse(null);
		return book;
	}

	/**
	 * Create new book entry
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		Set<Book> bookList = BookTable.books();
		bookList.add(book);
	}

	/**
	 * Update existing book
	 * 
	 * @param book
	 */
	public void updateBookDetails(Book book) {
		Set<Book> bookList = BookTable.books();
		Iterator<Book> bookItr = bookList.iterator();
		while (bookItr.hasNext()) {
			Book existingBook = bookItr.next();
			if (book.getBookId() == existingBook.getBookId()) {
				bookItr.remove();// removing existing element from Set
			}
		}
		bookList.add(book);// add updated element in Set
	}

	/**
	 * Verify whether requested book is available or not
	 * 
	 * @param book
	 * @return boolean
	 */
	public boolean isBookExists(Book book) {
		Set<Book> bookList = BookTable.books();
		Book existingBook = bookList.stream()// convert stream
				.filter(b -> b.getBookId() == book.getBookId()).findAny().orElse(null);
		if (existingBook == null) {
			return false;
		}
		return true;
	}
}
