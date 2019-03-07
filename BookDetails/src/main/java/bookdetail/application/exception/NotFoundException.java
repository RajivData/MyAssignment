package bookdetail.application.exception;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 10001234L;
		
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException() {
		super();
	}
}
