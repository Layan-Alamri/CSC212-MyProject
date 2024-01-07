
package csc212_project;

public class LinkedList<T extends Comparable<T>> {

    // Private fields to store the head, current node, and size of the linked list.
    private Node<T> head;
    private Node<T> current;
    public int size;

    // Constructor to initialize the linked list with an empty state.
    public LinkedList() {
        size = 0;
        head = current = null;
    }

    // Method to check if the linked list is empty.
    public boolean empty() {
        return head == null;
    }

    // Method to check if the current node is the last node in the linked list.
    public boolean last() {
        return current.next == null;
    }

    // Method to check if the linked list is full (always returns false in this implementation).
    public boolean full() {
        return false;
    }

    // Method to set the current node to the first node in the linked list.
    public void findFirst() {
        current = head;
    }
 
    // Method to set the current node to the next node in the linked list.
    public void findNext() {
        current = current.next;
    }

    // Method to retrieve the data stored in the current node.
    public T retrieve() {
        return current.data;
    }

    // Method to update the data stored in the current node.
    public void update(T val) {
        current.data = val;
    }

    
    // Method to insert a new node with data in sorted order in the linked list.
    public boolean Add(T val) {
        Node<T> tmp = new Node(val);
        if (empty()) {
            current = head = tmp;
        }
        else {
            if (head.getData().compareTo(val) > 0) {
                tmp.setNext(head);
                head = tmp;
            } 
            else {
                Node<T> prev = null;
                current = head;

                while ((current != null) && (current.getData().compareTo(val) <= 0)) {
                    prev = current;
                    current = current.getNext();
                }
                if (current != null) {
                    tmp.next = current;
                    prev.next = tmp;
                    current = tmp;
                } else
                    current = prev.next = tmp;
            }
        }
        size++;
        return true;
    }

    
    // Method to search for a node with a specific value in the linked list.
    public boolean search(T val) {
        if (head == null)
            return false;

        Node<T> nodeSearch = head;
        while ((nodeSearch != null) && (nodeSearch.getData().compareTo(val) != 0))// It's means we didn't find it
                nodeSearch = nodeSearch.getNext();
        
        if ((nodeSearch != null) && (nodeSearch.getData().compareTo(val) == 0)) {
             current = nodeSearch;
            return true;
        }
        return false;
    }

    // Method to remove a node with a specific value from the linked list.
    public T remove(T val) {

        if (search(val) == false)
            return null;

        T data = current.getData();

        if (current == head) {
            head = head.next;
        } 
        else {
            Node tmp = head;

            while (tmp.next != current)
            tmp = tmp.next;
            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
        size--;
        return data;
    }

    @Override
    // Override of the toString method to provide a string representation of the
    public String toString(){
        Node<T> p = head;
        String str = "";

        while (p != null){
            str += p.data.toString() + "\n";
            p = p.getNext();
        }
        return str;
    }
    
}// End class LinkedList