package exception;

public class NullReferenceException extends Exception {
    public NullReferenceException(String Name) {
        super("Name Should not be null");
    }
}
