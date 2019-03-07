package bookInventory.application.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import bookInventory.application.model.Book;

@RunWith(MockitoJUnitRunner.class)
public class TestBookService {

	@InjectMocks
	BookService bookService;

	@Test
	public void getBookByID() {

		Book bookDetails = bookService.getBookById(100);

		assertEquals(100, bookDetails.getBookId());
		assertEquals("Core Java", bookDetails.getBookName());
		assertEquals("Computer Science", bookDetails.getBookCategory());

	}

	@Test
	public void testAddBook() {
		Book book = new Book();
		book.setBookId(200);
		book.setBookName("ABC");
		book.setBookCategory("Science");
		BookService bookServicem = mock(BookService.class);
		doNothing().when(bookServicem).addBook(book);
		bookServicem.addBook(book);
		verify(bookServicem, times(1)).addBook(book);
	}

	@Test
	public void testUpdateBookDetails() {
		Book book = new Book();
		book.setBookId(200);
		book.setBookName("C++");
		book.setBookCategory("Computer Application");
		BookService bookSer = mock(BookService.class);
		doNothing().when(bookSer).updateBookDetails(book);
		bookSer.updateBookDetails(book);
		verify(bookSer, times(1)).updateBookDetails(book);
	}

}
