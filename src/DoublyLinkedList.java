/**
 * A generic doubly linked list implementation specifically designed for LRU Cache.
 * Maintains head and tail sentinel nodes for simplified operations.
 *
 * @param <K> the type of keys stored in the nodes
 * @param <V> the type of values stored in the nodes
 */
public class DoublyLinkedList<K,V> {
    private Node<K,V> head, tail;

    /**
     * Constructs an empty doubly linked list with sentinel nodes.
     */
    public DoublyLinkedList() {
        head= new Node<>(null,null);
        tail= new Node<>(null,null);
        head.next=tail;
        tail.prev=head;
    }

    /**
     * Adds a node to the front of the list (after the head sentinel).
     *
     * @param node the node to be added to the front
     */
    public void AddToFront(Node<K,V> node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }

    /**
     * Removes a specified node from the list.
     *
     * @param node the node to be removed
     */
    public void Remove(Node<K,V> node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    /**
     * Removes and returns the last node before the tail sentinel.
     *
     * @return the last node in the list
     */
    public Node<K, V> removeTail() {
        Node<K, V> node = tail.prev;
        Remove(node);
        return node;
    }
    public Node<K, V> MovetoFront(Node<K,V> node) {
        Remove(node);
        AddToFront(node);
        return node;
    }
}
