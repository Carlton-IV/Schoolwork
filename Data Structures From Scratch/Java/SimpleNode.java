//Simple one way node
public class SimpleNode<E> implements Node<E> {

    /** Fields **/
    //Holds the next node
    private Node<E> next;
    //Holds the element
    private E element;

    /** Constructors **/
    //Default constructor, sets element and following node to null
    public SimpleNode() {
        element = null;
        next = null;
    }

    //Constructor to set an element
    public SimpleNode(E elm) {
        element = elm;
        next = null;
    }

    //Constructor to set a following node
    public SimpleNode(Node<E> nxt) {
        element = null;
        next = nxt;
    }

    //Constructor to set an element and a following node
    public SimpleNode(E elm, Node<E> nxt) {
        element = elm;
        next = nxt;
    }

    /** Next Node Methods **/
    //Returns the node following the current node
    public Node<E> getNext() {
        return next;
    }

    //Sets the node following the current node
    public void setNext(Node<E> nxt) {
        next = nxt;
    }

    /** Element Methods **/
    //Returns the element stored in the node
    public E getElement() {
        return element;
    }

    //Sets the element stored in the node
    public void setElement(E elm) {
        element = elm;
    }
}
