import java.util.*;

/**
 * A generic Least Recently Used (LRU) Cache implementation.
 * Provides O(1) time complexity for both get and put operations.
 *
 * @param <K> the type of keys maintained by this cache
 * @param <V> the type of mapped values
 */
public class LRU<K,V> {
    private int capacity;
    private Map<K,Node<K,V>> cache;
    private DoublyLinkedList<K,V> list;

    /**
     * Constructs an LRU cache with the specified capacity.
     *
     * @param capacity maximum number of entries the cache can hold
     */
    public LRU(int capacity) {
        this.capacity = capacity;
        this.cache=new HashMap<>();
        this.list= new DoublyLinkedList<>();
    }

    /**
     * Retrieves the value associated with the given key if present in the cache.
     * Moves the accessed item to the front of the cache (most recently used position).
     *
     * @param key the key whose associated value is to be returned
     * @return the value associated with the key, or null if the key is not present
     */
    public V get(K key){
        if(!cache.containsKey(key)){
            System.out.println("key not found");
            return null;
        }
            Node<K,V> node=cache.get(key);
            list.MovetoFront(node);

        return node.value;
 }
    /**
     * Inserts or updates a key-value pair in the cache.
     * If the key exists, updates its value and moves it to the front.
     * If the key doesn't exist, adds the pair and removes the least recently used
     * item if the cache is at capacity.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     */
    public void put(K key, V value){
        if(cache.containsKey(key)){
            Node<K,V> node=cache.get(key);
            node.value=value;
            list.AddToFront(node);
        }
        else{
            if(cache.size()>=capacity){
                Node<K,V>lastNode=list.removeTail();
                cache.remove(lastNode.key);
                System.out.println("removed "+lastNode.key);
            }
            Node<K,V> node=new Node<>(key,value);
            list.AddToFront(node);
            cache.put(key,node);
        }
 }
    /**
     * Displays the current contents of the cache.
     * Prints each key-value pair in the cache.
     */
    public void display() {
        System.out.println(" Current LRU Cache: ");
        for (K key : cache.keySet()) {
            System.out.println( key + " -> " + cache.get(key).value);
        }
    }


}
