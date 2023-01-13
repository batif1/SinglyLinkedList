// Node class that creates nodes and returns its elements and next

public class Node <T>{
    //Setting the private elements that belong in the Node class.
    private T element;
    private Node<T> next;

    //Creating a constructor for the Node class.
    public Node(T t, Node<T> n){
        element = t;
        next = n;
    }

    public void Node(){}

//Getter Method for the next node
    public Node<T> getNext() {
        return next;
    }
    //Getter Method for the element in the node.
    public T getElement() {
        return element;
    }

    //A setter method to set where the next node should be.
    public void setNext(Node<T> next) {
        this.next = next;
    }

}

