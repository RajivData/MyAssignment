package bookInventory.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookInventory.application.model.Book;
import bookInventory.application.service.BookService;

@RestController
@RequestMapping(value = "/book-inventory")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
		Book book = bookService.getBookById(bookId);
		if(book==null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(book);
	}

	@PostMapping(value = "/book", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookService.addBook(book);
		return ResponseEntity.ok("Added");
	}

	@PutMapping(value = "/book", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateBookRecord(@RequestBody Book book) {
		if (!bookService.isBookExists(book)) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		bookService.updateBookDetails(book);
		return ResponseEntity.ok("Record Updated");
	}
}
