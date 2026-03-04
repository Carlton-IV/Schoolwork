public class NonEmptyTreeException extends RuntimeException {

    public NonEmptyTreeException() {
        super("Tree isn't empty!");
    }

    public NonEmptyTreeException(String str) {
        super(str);
    }
}
