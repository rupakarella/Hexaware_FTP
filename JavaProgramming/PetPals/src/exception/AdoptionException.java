package exception;

public class AdoptionException extends Exception {
    public AdoptionException(String Name) {
    	super("Pet with name '" + Name + "' is not available for adoption.");
    }
}
