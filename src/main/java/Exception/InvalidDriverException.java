package Exception;

public class InvalidDriverException extends RuntimeException{
	String BrowserName;
	public InvalidDriverException(String browserName) {
		this.BrowserName=browserName; 
	}
	@Override
	public String getMessage() {
		
		return "Invalid Browser"+ BrowserName;
		
	}

}
