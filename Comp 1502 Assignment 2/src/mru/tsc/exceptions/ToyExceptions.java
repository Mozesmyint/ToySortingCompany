package mru.tsc.exceptions;

public class ToyExceptions extends Exception{

	public ToyExceptions(String error) {
		super("Invalid response, "+ error );
	}
}
