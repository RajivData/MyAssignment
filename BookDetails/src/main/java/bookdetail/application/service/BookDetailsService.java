package bookdetail.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookdetail.application.consumer.BookConsumer;
import bookdetail.application.model.Book;
/**
 * 
 * @author RAJIV
 *
 */

@Service
public class BookDetailsService {
	@Autowired
	private BookConsumer bookConsumer;

	public Book fetchBookById(int bookId) {
		return bookConsumer.getBookById(bookId);
	}
}
