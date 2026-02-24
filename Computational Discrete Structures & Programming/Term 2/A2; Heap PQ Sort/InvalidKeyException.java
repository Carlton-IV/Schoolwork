public class InvalidKeyException extends RuntimeException {

    public InvalidKeyException() {
        super("Invalid key!");
    }

    public InvalidKeyException(String str) {
        super(str);
    }
}
