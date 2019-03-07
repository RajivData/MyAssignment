package bookdetail.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookdetail.application.model.Book;
import bookdetail.application.service.BookDetailsService;

@RestController
@RequestMapping(value = "/book-details")
public class BookDetailsController {

	@Autowired
	private BookDetailsService bookService;

	@GetMapping(value = "/book/{bookId}",produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Book> getBook(@PathVariable int bookId) {
		Book book = bookService.fetchBookById(bookId);
		if(book==null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(book);
	}
}
