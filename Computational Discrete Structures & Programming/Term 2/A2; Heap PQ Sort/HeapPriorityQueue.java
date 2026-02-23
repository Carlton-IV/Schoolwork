import java.util.Comparator;
import java.util.Random;

public class HeapPriorityQueue<K,V> implements PriorityQueue<K,V> 
{
	protected CompleteBinaryTree<Entry<K,V>> heap; // underlying heap
	protected Comparator<K> comp; // comparator for the keys

	// Inner class for heap entries. 
	protected static class MyEntry<K,V> implements Entry<K,V> 
	{
		protected K key;
		protected V value;
		public MyEntry(K k, V v) { key = k; value = v; }
		public K getKey() { return key; }
		public V getValue() { return value; }
		public String toString() { return "(" + key + "," + value + ")"; }
	}
	
	// Creates an empty heap with the default comparator
	public HeapPriorityQueue() 
	{
		heap = new ArrayListCompleteBinaryTree<Entry<K,V>>(); // use an array list
		comp = new DefaultComparator<K>(); // use the default comparator
	}
}