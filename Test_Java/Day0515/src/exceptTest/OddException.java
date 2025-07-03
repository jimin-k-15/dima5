package exceptTest;

public class OddException extends Exception {
	public OddException() {
		super("Odd Exception");
	}
	
	public OddException(String message) {
		super(message);
	}	
}
