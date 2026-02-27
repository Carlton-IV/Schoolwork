//A node that only stores an element
public class SimpleNode<E> implements Node<E> {

    /** Fields **/
    //Stores the element of the node
    private E element;

    /** Constructor **/
    public SimpleNode(E elm) {
        element = elm;
    }

    /** Element Accessor and Mutator **/
    public E getElement() {
        return element;
    }

    public void setElement(E elm) {
        element = elm;
    }
}
