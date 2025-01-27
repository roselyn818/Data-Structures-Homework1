package module2;

import java.util.Iterator;

public class GenericStack<E> implements Iterable<E>{
    private Node top;

    //LIFO (last in, first out)
    public GenericStack(){
        top = null; //changed so that stack it is empty by default
    }

    public Iterator<E> iterator() {
        return new StackIterator();
    }

    private class Node{
        E value;    // a linked list contains two parts the
                     //value and pointer
        Node next;
        Node(E value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return top == null;
    }

    public E peek(){
        if (top == null)
            return null; //added in case stack is empty
        return top.value;
    }

    public void push(E item){

        Node newNode = new Node(item);//creates a new Node object that will eventually be placed on top of the stack

        if(isEmpty()){
            top = newNode;
        } else{
            newNode.next = top; //sets the pointer from the newly created node to point to the previous top node
            top = newNode; //sets the top of the stack to the newly created node
        }
    }


    public E pop(){
        if(top == null) return null;

        Node temp = top; //sets a temp. var. to equal the top Node, so it can exist in memory

        top = top.next; //sets the top node pointer to the node underneath it (the one it points to)
                    //(This will remove the previous top node upon garbage collection)
        temp.next = null; //removes the reference(pointer) of the old top node.

        return temp.value; //returns the value of the recently removed top node

    }

    /*TODO WRITE THIS METHOD
    this method will check to see if a stack contains a specified Item using a LinkedList, not an ArrayList
    you'll need to uncomment the code around the method to begin
     */

    public boolean contains(GenericStack<E> stack, E item){
        Node currentNode = top; //makes a node that points to the top node in the stack given

        while(currentNode.next != null){  //while we are not at the bottom of the stack continue searching
            if(currentNode.value.equals(item)){  //if the value of the current node equals item given
                return true;  //return true boolean (and exits out the method)
            }
            currentNode = currentNode.next; //traverse through the stack :)
        }
        return false; //if it completes while loop item is not found(false)
    }


    public void printStack(){
        Node temp = top;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private class StackIterator implements Iterator<E>{

        private Node current = top;
        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            E item = current.value;
            current = current.next;
            return item;
        }
    }
}

