//A node with a single pointer
public class SingleNode<E> extends SimpleNode<E> {

    /** Fields **/
    //Holds the next node
    private SingleNode<E> next;

    /** Constructors **/
    //Constructor to set an element and a following node
    public SingleNode(E elm, SingleNode<E> nxt) {
        super(elm);
        next = nxt;
    }

    //Default constructor, sets element and following node to null
    public SingleNode() {
        this(null, null);
    }

    //Constructor to set an element
    public SingleNode(E elm) {
        this(elm, null);
    }

    //Constructor to set a following node
    public SingleNode(SingleNode<E> nxt) {
        this(null, nxt);
    }

    /** Next Node Methods **/
    //Returns the node following the current node
    public SingleNode<E> getNext() {
        return next;
    }

    //Sets the node following the current node
    public void setNext(SingleNode<E> nxt) {
        next = nxt;
    }
}
