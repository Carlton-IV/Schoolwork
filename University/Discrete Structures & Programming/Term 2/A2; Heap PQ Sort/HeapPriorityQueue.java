import java.util.Comparator;
import java.util.Random;

public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {

    protected CompleteBinaryTree<Entry<K, V>> heap; // underlying heap
    protected Comparator<K> comp; // comparator for the keys
    protected int size = 0; // number of elements in the heap

    // Inner class for heap entries. Provided by Dr. Chenkuan Li
    protected static class MyEntry<K, V> implements Entry<K, V> {

        protected K key;
        protected V value;

        public MyEntry(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }

    // Creates an empty heap with the default comparator. Provided by Dr. Chenkuan Li
    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>(); // use an array list
        comp = new DefaultComparator<K>(); // use the default comparator
    }

    // General Methods //
    public int size() {
        // Returns the size of the heap
        return size;
    }

    public boolean isEmpty() {
        // Returns if the heap is empty
        return size == 0;
    }

    // PQ Methods //
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        //Adds a new entry to the bottom of the heap
        MyEntry<K, V> entry = new MyEntry<K, V>(key, value);
        upHeap(heap.add(entry));
        size++;
        return entry;
    }

    public Entry<K, V> min() throws EmptyPriorityQueueException {
        //Returns the minimum entry
        return heap.root().element();
    }

    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        //Removes and returns the minimum entry
        Entry<K, V> min = heap.replace(heap.root(), heap.remove());
        if(size > 1) downHeap(heap.root());
        size--;
        return min;
    }

    // Heap Methods //
    protected void swap(Position<Entry<K, V>> a, Position<Entry<K, V>> b) {
        Entry<K, V> temp = a.element();
        heap.replace(a, b.element());
        heap.replace(b, temp);
    }

    protected void upHeap(Position<Entry<K,V>> v) {
        Position<Entry<K, V>> u;
        while(!heap.isRoot(v)){
          u=heap.parent(v);
          if(comp.compare(u.element().getKey(), v.element().getKey()) <=0) break;
          swap(u,v);
          v=u;
        }
    }

    protected void downHeap(Position<Entry<K,V>> r) {
        while(heap.isInternal(r)){
          Position<Entry<K, V>> s;
          if(!heap.hasRight(r)) s = heap.left(r);
          else if(comp.compare(heap.left(r).element().getKey(), heap.right(r).element().getKey()) <=0) s = heap.left(r);
          else s = heap.right(r);
          if(comp.compare(s.element().getKey(), r.element().getKey()) <=0) {
            swap(r,s);
            r=s;
          }
          else break;
        }
    }
    
    public static void main(String[] args) {
      HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>();
      Random rand = new Random();
      
      System.out.println("Putting numbers into heap\n");
      for (int i = 0; i < 15; i++) {
        System.out.println();
        for(int j = 0; j < 15; j++) System.out.print(pq.insert(rand.nextInt(999), 1).getKey() + ", ");
      }
      System.out.println("\n\nSorting Entries\n");
      for (int i = 0; i < 15; i++) {
        System.out.println();
        for (int j = 0; j < 15; j++) 
          if(!pq.isEmpty())
            System.out.print(pq.removeMin().getKey() + ", ");
      }
      
      System.out.println("\n");
    }
    
}
