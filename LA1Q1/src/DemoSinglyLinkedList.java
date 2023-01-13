import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DemoSinglyLinkedList {

    public static void main(String[] args) {

//Calling the header
        header(1);
        //Creating two numberLists
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(56,-22,34,57,98));
        ArrayList<String> nameList = new ArrayList<>(Arrays.asList("Griffin","Will","Isra","Delaney","Madison"));
        //Creating printing out the two arraylists
        System.out.println("The given Integer Array: " + numberList);
        System.out.println("The given String Array: " + nameList);

        //Creating the two new linked lists.
        SinglyLinkedList<Integer> numberLinkedList = new SinglyLinkedList<Integer>();
        SinglyLinkedList<String> nameLinkedList = new SinglyLinkedList<String>();

        //Populating the arraylists with a for loop.
        for(int i = 0; i<5; i++)
        if (i<3) {
            numberLinkedList.addFirst(numberList.get(i));
            nameLinkedList.addFirst(nameList.get(i));
        }else {
            numberLinkedList.addLast(numberList.get(i));
            nameLinkedList.addLast(nameList.get(i));
        }
        //Printing out the arraylist using a toString method.
        System.out.println(numberLinkedList.toString());
        System.out.println(nameLinkedList.toString());

        System.out.println("Stack demo with the Integer linked list ...");

        //Calling the stackDemo method.
        stackDemo(numberLinkedList);
        //Calling the queueDemo method.
        queueDemo(nameLinkedList);

        //Creating a programKill boolean to kill the program if the user doesn't want to move forward.
        boolean programKill = false;
        Scanner userInput = new Scanner(System.in);    //Ask the user for an integer input using the Scanner class's methods.
        while (programKill==false){

            int numberRequested;
            //Receiving a value from the user and then searching for it using the searchStack method.
            System.out.println("Enter the value you are searching for:");
            numberRequested = userInput.nextInt();
            System.out.println("You are searching for: " + numberRequested);

            int foundAt;
            foundAt = numberLinkedList.searchStack(numberRequested);
            if (foundAt==0){ //if the value was not found the method returns a zero.
                System.out.println("The value is not found!");
            }else{
                System.out.println("The value "+ numberRequested + " is found in location " + (foundAt - 1) + " from the top of the stack."); //printing out where the index was found
            }

            String userChoice;
            System.out.println("Do you wish to continue? (Press y to continue or any other key to terminate):");
            Scanner userIn = new Scanner(System.in);    //Ask the user for an integer input using the Scanner class's methods.
            userChoice = userIn.nextLine();
            //Asking the user to continue or not. Make sure to use the proper logic.
            if (userChoice.equals("y")){
                programKill=false;
            }else {
                programKill=true;
                footer(1);
            }
        }

        }

//This method will use the linkedlist as a queue
    public static void queueDemo(SinglyLinkedList SLL){
        System.out.println("Note: Head is the Q-front, and Tail is the Q-rear");
        System.out.println("Let's enqueue Joelle and Lukas in the queue sequence....");//adding the two names using the enqueue at tail method.
        System.out.println("The current queue: "+SLL.toString());
        SLL.enqueueAtTail("Joelle");
        System.out.println("After Joelle is enqueued, the revised Queue:" +SLL.toString());
        SLL.enqueueAtTail("Lukas");
        System.out.println("After Lukas is enqueued, the revised Queue:" +SLL.toString());  //prinitng out the new queue
        System.out.println("Let's dequeue first three elements from the queue in sequence...");
        //dequeing the first three elements using a for loop and the dequeueAtHead method.
        System.out.println("The current queue: "+SLL.toString());
        for (int i = 0; i < 3; i++){
            System.out.println(SLL.dequeueAtHead() + " Has been dequeued! The revised queue: " + SLL.toString()); //Removing the first three names using the dequeue at head method.
        }
    }

    //This method will use the linked list as a stack.
    public static void stackDemo(SinglyLinkedList numberLinkedList){
        Scanner userInput = new Scanner(System.in); //Ask the user for an integer input using the Scanner class's methods.
        System.out.println("Which end of the Linked List you would like to use as the stack top?");
//Validating the input using a try catch method and a while loop that keeps asking untill the input is correct.
        boolean numberIsCorrect = false;
        int numberRequested = 0;

        while (numberIsCorrect == false) {
            try {
                System.out.println("Enter 1 for head or 2 for tail:");
                numberRequested = userInput.nextInt();
                if ((numberRequested < 1) || (numberRequested > 2)){
                    System.out.println("Invalid Entry! Enter 1 for head or 2 for tail:");
                    throw new Exception();
                }
                break;
            }catch (Exception e){
                userInput.nextLine();
            }
        }

        //Using the head-side of the linked list as the top of a stack
        if (numberRequested==1){
            System.out.println("Stack Top: Head of the linked list. \nLet's pop all the elements from the stack in sequence: \n ");
            System.out.println("The current stack: " + numberLinkedList.toString());
//popping a few numbers from the head of the stack.
            while ((numberLinkedList.getSize()) > 0) {
                System.out.println(numberLinkedList.popFromHead() +" has been popped! The Revised Stack: "+numberLinkedList.toString());
            }
            //pushing a few numbers to the head of the stack.
            System.out.println("Let's push 39 and -58 into the stack!");
            System.out.println("The current stack: " + numberLinkedList.toString());
            numberLinkedList.pushAtHead(39);
            System.out.println("After 39 is pushed, the revised stack: " + numberLinkedList.toString());
            numberLinkedList.pushAtHead(-58);
            System.out.println("After -58 is pushed, the revised stack: " + numberLinkedList.toString());
        }

        if (numberRequested==2){
            //Treating the tail of the stack as the top.
            System.out.println("Stack Top: Tail of the linked list");
            System.out.println("Let's pop first three elements from the stack in sequence:");
            System.out.println("The current stack: " + numberLinkedList.toString());
//Popping two numbers from the stack using a loop.
            while ((numberLinkedList.getSize()) > 2) {
                System.out.println(numberLinkedList.popFromTail() +" has been popped! The Revised Stack: "+numberLinkedList.toString());
            }
            //Adding two numbers to the stack.
            System.out.println("Let's push 39 and -58 into the stack!");
            System.out.println("The current stack: " + numberLinkedList.toString());
            numberLinkedList.pushAtTail(39);
            System.out.println("After 39 is pushed, the revised stack: " + numberLinkedList.toString());
            numberLinkedList.pushAtTail(-58);
            System.out.println("After -58 is pushed, the revised stack: " + numberLinkedList.toString());
        }


    }


    // Creating a footer method that taKes in the exercise number and prints out the relevant information to indicating the end of this exercise.
    public static void footer(int exerciseNumber) {
        System.out.println("_____________________________________________________________________");
        System.out.println("Completion of Assignment " + exerciseNumber + " is successful!");
        System.out.println("Signing off - Bashshar Atif.");
    }


    // Creating a header method that takes in the lab number and outputs relevant information about this project.
    public static void header(int assignmentNumber) {
        System.out.println("______________________________________________________________________________________________________________________________________");
        System.out.println("Assignment " + assignmentNumber);
        System.out.println("Prepared By: Bashshar Atif");
        System.out.println("Student Number: 251219057");
        System.out.println("The goal of this exercise to is to create a Singly link-list data structure and use that to realize a stack and a queue.");
        System.out.println("______________________________________________________________________________________________________________________________________");

    }
}