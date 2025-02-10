/**
 * A generic node class for doubly linked list implementation.
 * Used as the storage unit in the LRU Cache implementation.
 *
 * @param <K> the type of key stored in the node
 * @param <V> the type of value stored in the node
 */
public class Node<K,V> {
    K key;
    V value;
    Node<K,V> prev, next;

    /**
     * Constructs a new node with the specified key and value.
     *
     * @param key the key to be stored in this node
     * @param value the value to be stored in this node
     */
    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
