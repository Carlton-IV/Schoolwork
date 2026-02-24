/**
 * Runtime exception thrown when one tries to perform operations 
 * on an empty Queue.
 */


public class EmptyQueueException extends RuntimeException {
  public EmptyQueueException(String err) {
    super(err);
  }
}
