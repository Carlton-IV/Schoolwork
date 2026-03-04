public class BoundaryViolationException extends RuntimeException {

    public BoundaryViolationException() {
        super("Position out of bounds!");
    }

    public BoundaryViolationException(String str) {
        super(str);
    }
}
