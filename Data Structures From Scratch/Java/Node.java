//Basic one way node class
public class Node<E> 
{
	//Stores the element of the node
	private E element;
	//Stores the following node
	private Node next;
	
	//Creation methods
	//Creates a node with a given element and next node
	public Node(E elm, Node nxt) 
	{
		element = elm;
		next = nxt;
	}
	//Creates a node with a blank element and next node
	public Node() 
	{
		this(null, null);
	}
	
	//Next node
	//returns the following node
	public Node getNext()
	{
		return next;
	}
	//sets the following node
	public void setNext(Node nxt) 
	{
		next = nxt;
	}
	
	//Elements methods
	//returns the node's element
	public E getElement() 
	{
		return element;
	}
	//sets the node's element
	public void setElement(E elm) 
	{
		element = elm;
	}
}