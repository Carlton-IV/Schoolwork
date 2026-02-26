public class InvalidPositionException extends RuntimeException {

    public InvalidPositionException() {
        super("Invalid position!");
    }

    public InvalidPositionException(String str) {
        super(str);
    }
}
