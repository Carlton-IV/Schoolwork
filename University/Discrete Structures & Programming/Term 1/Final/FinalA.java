//Discrete final assignment
import java.util.*;
public class FinalA{
  public static void main(String[] args) {
    int[] x = {2,4,3,2,6,7,3,5,74,23,2,53,3,9,8,0};
    System.out.println(Arrays.toString(span2.run(x,x.length)));
  }
  
  public static void stackExample() {
    stack<Integer> stak = new stack<>();
    for(int j = 0; j < 27; j++) stak.push(j);
    System.out.println(stak.top());
    for(int j = 0; j < 28; j++) System.out.print(stak.pop()+" ");
  }
  
  public static void indexListExample() {
    indexList<Integer> list = new indexList<>();
    for(int j = 0; j < 27; j++) list.add(j, j);
    System.out.println("Initial list      : "+list.toString() +"\n");
    System.out.print("Removing indicies 12-22: ");
    for(int j = 0; j < 11; j++) System.out.print(list.remove(12) + " ");
    System.out.println("\n");
    System.out.println("List missing 12-22: "+list.toString() + "\n");
    for(int j = 12, k = 22; j<23; j++) {
        list.add(j, k);
        k--;
    }
    System.out.println("Reversed 12-22    : " + list.toString() +"\n");
    System.out.print("Fixing Indicies 12-22: ");
    for(int j = 12; j < 23; j++) System.out.print(list.set(j,j)+" ");
    System.out.println("\n");
    System.out.println("Fixed List        : " + list.toString());
  }
}

//SPAN2
class span2 {
  @SuppressWarnings("unchecked")
  public static int[] run(int[] X, int n) {
    stack<Integer> A = new stack<>();
    int[] S = new int[n];
    for(int i = 0; i < n; i++) {
      while (!A.isEmpty() && X[A.top()] <= X[i]) {
        A.pop();
      }
      if(A.isEmpty()) { S[i] = i+1; }
      else { S[i] = i-A.top(); }
      A.push(i);
    }
    return S;
  }
  
}

//STACK
class stack<E> {
  
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

//INDEX LIST
class indexList<E> implements Vector<E>{
  private int capacity;
  private int size;
  private E[] A;
  
  @SuppressWarnings("unchecked")
  public indexList(){
      capacity = 16;
      size = 0;
      A = (E[])(new Object[capacity]);
  }
  
  public int size() { return size; }
  
  public boolean isEmpty() { return size == 0; }
  
  public void checkIndex(int i) throws IndexOutOfBoundsException {
    if(i > size || i < 0) throw new IndexOutOfBoundsException("Index out of bounds!");
  }
  
  @SuppressWarnings("unchecked")
  public void add(int i, E e) throws IndexOutOfBoundsException {
      checkIndex(i);
      if(size==capacity-1) {
          capacity *= 2;
          E[] B = (E[])(new Object[capacity]);
          for(int j = 0; j < size; j++) B[j] = A[j];
          A = B;
          B = null;
      }
      for(int j = size-1; j >= i; j--) A[j+1] = A[j];
      A[i] = e;
      size++;
  }
  
  public E get(int i) throws IndexOutOfBoundsException {
      checkIndex(i);
      return A[i];
  }
  
  public E remove(int i) throws IndexOutOfBoundsException {
      checkIndex(i);
      E value = A[i];
      for(int j = i+1; j < size; j++) A[j-1] = A[j];
      size--;
      return value;
  }
  
  public E set(int i, E e) throws IndexOutOfBoundsException {
      checkIndex(i);
      E value = A[i];
      A[i] = e;
      return value;
  }
  
  public String toString() {
      String value = "[";
      for(int j = 0; j < size-1; j++) value += (A[j]+", ");
      if(!isEmpty()) value += A[size-1];
      value += "]";
      return value;
  }

}


interface Vector<E> {

  /** Returns the number of elements in this list. */
  public int size();
  
  /** Returns whether the list is empty. */
  public boolean isEmpty();

  /** Inserts an element e to be at index i, shifting all elements after this. */
  public void add(int i, E e)
  throws IndexOutOfBoundsException;

  /** Returns the element at index i, without removing it. */
  public E get(int i)
  throws IndexOutOfBoundsException;

  /** Removes and returns the element at index i, shifting the elements after this. */
  public E remove(int i)
  throws IndexOutOfBoundsException;

  /** Replaces the element at index i with e, returning the previous element at i. */
  public E set(int i, E e)
  throws IndexOutOfBoundsException;
}

public class EmptyStackException extends RuntimeException {
  public EmptyStackException(String message) {
    super(message);
  }
}
