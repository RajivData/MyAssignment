package bookdetail.application.consumer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import bookdetail.application.exception.BookDetailsException;
import bookdetail.application.exception.NotFoundException;
import bookdetail.application.model.Book;

/**
 * 
 * @author RAJIV
 *
 */
@Component
public class BookConsumer {

	Logger logger = LoggerFactory.getLogger(BookConsumer.class);

	@Value("${book.consumer.endpoint}")
	private String bookConsumerEndpoint;

	public Book getBookById(int bookId) {
		final String url = bookConsumerEndpoint;
		Book book = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> httpEntity = new HttpEntity<String>("parameter", httpHeaders);
			ResponseEntity<Book> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Book.class,
					bookId);
			book = responseEntity.getBody();
		} catch (NotFoundException exp) {
			return null;
		} catch (BookDetailsException exp) {
			logger.info(exp.getMessage());
		} catch (Exception exp) {
			return null;
		}
		return book;
	}
}
