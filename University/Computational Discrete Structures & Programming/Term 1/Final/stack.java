public class stack<E> {
  
  private indexList<E> list = new indexList<>();
  
  public int size() { return list.size(); }
  
  public boolean isEmpty() { return list.isEmpty(); }
  
  public void push(E elm) { list.add(size(), elm); }
  
  public E pop() { 
    E elm;
    try {
      elm = list.remove(size()-1);
    } 
    catch (IndexOutOfBoundsException e) {
      throw new EmptyStackException("Stack is empty!");
    }
    return elm;
  }
  
  public E top() { return list.get(size()-1); }
}

