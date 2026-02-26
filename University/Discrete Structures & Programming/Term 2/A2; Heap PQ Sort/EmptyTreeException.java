public class EmptyTreeException extends RuntimeException {

    public EmptyTreeException() {
        super("Tree is empty!");
    }

    public EmptyTreeException(String str) {
        super(str);
    }
}
