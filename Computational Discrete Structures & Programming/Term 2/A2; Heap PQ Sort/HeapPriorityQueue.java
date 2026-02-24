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
        heap.add(entry);
        upHeap();
        return entry;
    }

    public Entry<K, V> min() throws EmptyPriorityQueueException {
        //Returns the minimum entry
        return heap.root().element();
    }

    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        //Removes and returns the minimum entry
        Entry<K, V> min = heap.replace(heap.root(), heap.remove());
        downHeap();
        return min;
    }

    // Heap Methods //
    protected void swap(Position<Entry<K, V>> a, Position<Entry<K, V>> b) {}

    protected void upHeap() {}

    protected void downHeap() {
        Position<Entry<K, V>> root = heap.root();
        K rootKey = root.element().getKey();
        int comparison = 1;
        Position<Entry<K, V>> smaller = root;
        while (heap.hasRight(smaller) && comparison > 0) {
            K leftKey = heap.left(smaller).element().getKey();
            K rightKey = heap.right(smaller).element().getKey();
            if (comp.compare(leftKey, rightKey) >= 0) {
                comparison = comp.compare(leftKey, rootKey);
                if (comparison > 0) smaller = heap.left(smaller);
            } else {
                comparison = comp.compare(rightKey, rootKey);
                if (comparison > 0) smaller = heap.left(smaller);
            }
        }
    }
}
