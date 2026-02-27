//An expanded node that can hold two pointers
public class DoubleNode<E> extends SingleNode<E> {

    /** Fields **/
    //Stores the following node
    private DoubleNode<E> next;
    //Stores the preceding node
    private DoubleNode<E> previous;

    /** Constructors **/
    //Creates a double node with a
    public DoubleNode(DoubleNode<E> prev, E elm, DoubleNode<E> nxt) {
        super(elm);
        previous = prev;
        next = nxt;
    }

    public DoubleNode() {
        this(null, null, null);
    }

    public DoubleNode(E elm) {
        this(null, elm, null);
    }

    public DoubleNode(SingleNode<E> node) {
        DoubleNode<E> nxt;
        if (node.getNext() == null) nxt = null;
        else nxt = new DoubleNode<E>(node.getNext());
        this(null, node.getElement(), nxt);
    }

    public DoubleNode(DoubleNode<E> prev, SingleNode<E> node) {
        DoubleNode<E> nxt;
        if (node.getNext() == null) nxt = null;
        else nxt = new DoubleNode<E>(node.getNext());
        this(prev, node.getElement(), nxt);
    }

    /** Next Node Methods **/
    public DoubleNode<E> getNext() {
        return next;
    }

    public void setNext(DoubleNode<E> nxt) {
        next = nxt;
    }

    /** Previous Node Methods **/
    public DoubleNode<E> getPrev() {
        return previous;
    }

    public void setPrev(DoubleNode<E> prev) {
        previous = prev;
    }
}
