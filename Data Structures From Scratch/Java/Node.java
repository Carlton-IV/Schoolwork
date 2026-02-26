//Node Interface
public interface Node<E> {
    /** Next node **/
    //returns the following node
    public Node<E> getNext();

    //sets the following node
    public void setNext(Node<E> nxt);

    /** Elements methods **/
    //returns the node's element
    public E getElement();

    //sets the node's element
    public void setElement(E elm);
}
