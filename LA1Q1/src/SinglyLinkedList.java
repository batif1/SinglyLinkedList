//SinglyLinkedList will have methods that will allow us to manage and create the nodes and use them as eiter a stack or queue data structures.
public class SinglyLinkedList <T> {
    //Setting up the private fields for the class.
    private Node<T> head;  //Head and tail are generic type Node<T>
    private Node<T> tail;
    private int size;

    //Constructor for the class
    public SinglyLinkedList(Node<T> head, Node<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size =size;
    }

    public SinglyLinkedList(){}

    //Getter that returns the size of the linkedlist
    public int getSize() {
        return size;
    }

    //If it's empty
    public boolean isEmpty(){
        return size ==0;
    }

    //This method is to print the linked list as a string.
    public String toString() {
       String addObject; //Have a string to add each element to the final printout.

        Node<T> current = new Node<>(null, head); //Create a new node that will cycle through the entire elements of the linked list and save the elements to a string.

        for (int i = 0; i <size; i++){  //This for loop will cycle through each of the nodes in the linked list.
            current = current.getNext(); //This will find switch to the next node.
            addObject = current.getElement().toString(); //Once it has been set to the next node, it will save the element (from "get.element") to the string "AddObject".
            if (i==(size-1)){
                printout += String.format("%s", addObject);  //This will format the last element without a ","
            }else{
                printout += String.format("%s,", addObject); //This will format the elements with an ","
            }

        }
        printout = String.format("[%s]", printout);  //This will print the entire list in square brackets.

        return printout;
    }

    //Creating a new node that will point to the head and will be the new head.
    public void addFirst(T t){
        head = new Node<>(t, head); //It's a new node with element t and will point to the head.
        //if the size is 0 then it will become the tail as well.
        if (size == 0){
            head = new Node<T>(t,head);
            tail = head;
        }
        size++;
    }

    //This will add a node to the end of the linked list and become the new tail (will point to null)
    public void addLast(T t){
        Node<T> newest = new Node<>(t, null);
        if (isEmpty())
            head = newest;
        tail.setNext(newest);
        tail = newest;
        size++;
    }

    //Will return the first element in the linkedlist and return the value that it deleted.
    public T removeFirst(){
        if (isEmpty()) return null;
        T answer = head.getElement();
        head = head.getNext();  //making the head the next list over
        size--;   //decrease the size as it is now smaller
        if (size==0)
            tail = null;
        return answer;
    }

    //removeLast will remove the last element in the string and return the value that got deleted.
    public T removeLast(){
        if (isEmpty()) return null;
        T answer = tail.getElement();
        Node<T>  current = new Node<>(null, head);
        while (current.getNext() != tail){ //finding the tail and then making it equal to a new node which is null
            current = current.getNext();
        }
        tail = current; //making the current tail equal to the the new node that equals null.
        size--;
        return answer;
    }

    //The next few methods are using the linked list like a stack or a queue. They essentially call the methods above and will be used to show how this linked list can be used as different data structures.

    public void pushAtHead(T element){
        addFirst(element);
    }

    public T popFromHead(){
        return removeFirst();
    }

    public void pushAtTail(T element){
        addLast(element);
    }

    public T popFromTail(){
        return removeLast();
    }

    public void enqueueAtTail(T element){
        addLast(element);
    }

    public T dequeueAtHead(){
        return removeFirst();
    }

    //This will search the stack for a specific element.

    public int searchStack(T element){
        int i=0;
        int found =0;
        while (current.getNext() != null){
            i++;
            if (current.getElement()==element){
                found = i;  //if it is found then it will return where it was found. If not, then it will return 0.
            }
            current = current.getNext(); //Accessing the next node.
        }
        return found;
    }






    Node<T>  current = new Node<>(null, head); //First it will create a node that will cycle through the elements of each node in the linked list and compare it to the element requested.

}
