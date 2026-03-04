public class EmptyPriorityQueueException extends RuntimeException {

    public EmptyPriorityQueueException() {
        super("The priority queue is empty!");
    }

    public EmptyPriorityQueueException(String str) {
        super(str);
    }
}
