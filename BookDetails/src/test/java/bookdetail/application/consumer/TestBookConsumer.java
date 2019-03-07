package bookdetail.application.consumer;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bookdetail.application.model.Book;

@RunWith(MockitoJUnitRunner.class)
public class TestBookConsumer {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private HttpEntity<String> httpEntity;
	@Mock
	private ResponseEntity<Book> responseEntity;
	
	@InjectMocks
	private BookConsumer bookConsumer;

	
	@Test
	public void testGetBookById() throws URISyntaxException
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://localhost:8181/book-inventory/book/100";
	    URI uri = new URI(baseUrl);
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Accept", "application/json");
	 
	    HttpEntity<Book> requestEntity = new HttpEntity<>(null, headers);
	 
	    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	     
	    //Verify request succeed
	    Assert.assertEquals(200, result.getStatusCodeValue());
	    Assert.assertEquals(true, result.getBody().contains("Core Java"));
	}

}
