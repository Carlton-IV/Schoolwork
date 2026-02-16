public class indexList<E> implements Vector<E>{
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

