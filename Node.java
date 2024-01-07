
package csc212_project;

// Node class represents a node in a linked list.
public class Node<T> {

    public T data; // Data stored in the node.
    public Node<T> next; // Reference to the next node in the linked list.

    // Default constructor: Initializes data and next to null.
    public Node() {
        data = null;
        next = null;
    }

    // Constructor with data parameter: Initializes data with the provided value,
    // and sets next to null (indicating that this node is initially not connected
    // to any other node.
    public Node(T val) {
        data = val;
        next = null;
    }

    // Setters/Getters...
    
    // Getter for retrieving the data stored in the node.
    public T getData() {
        return data;
    }

    // Setter for updating the data stored in the node.
    public void setData(T data) {
        this.data = data;
    }

    // Getter for retrieving the reference to the next node.
    public Node<T> getNext() {
        return next;
    }
    
    // Setter for updating the reference to the next node.
    public void setNext(Node<T> next) {
        this.next = next;
    }
}// End class Node.