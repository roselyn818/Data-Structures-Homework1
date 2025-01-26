package module2;

import module2.GenericStack;

import java.util.Iterator;

public class GenericQueue<E> implements Iterable<E> {

    private Node first, last ; //these are the two pointers
    private int length;

    @Override
    public Iterator<E> iterator() {
        return new QueueIterator();
    }


// so first points to the first node (first person in line) first.next points to the second person in line
// last points to the last node (last person in line) last.next points to null,
// meaning it doesn't point to any other node because it's the last node.
    private class Node{
        E value;    // a linked list contains two parts the
                    //value and pointer
        Node next;

        Node(E value){
            this.value = value;
        }
    }

    public GenericQueue(E item){
        Node newNode = new Node(item);
        first = newNode;
        last = newNode;
        length = 1;
    }

//this ADDS to the end of the queue (end of the line)
    public void enqueue(E value){
        Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else {          //remember last.next pointer is pointing to null since the last person in line points to nothing
                        //so imagine the current last person in line hands the "null" pointer to the 'new' last person
            last.next = newNode;
                        //and now the 'new' last person becomes the actual last person in line lol
            last = newNode;
        }
        length++;
    }

//REMOVES & returns node from the front of the line (first)
    public Node dequeue(){
        if(isEmpty()) return null;
                            //saves the current first node into a temporary variable temp
        Node temp = first; //which is soon-to-be removed
        if(length == 1){ //incase there is only one node in list
            first = null;
            last = null;
        } else {
            first = first.next; //updates the first pointer to reference the next node in the queue(next person in line)
            temp.next = null; // removes the reference(pointer) of the old first node.
        }

        length --;
        return temp;
    }

    public boolean isEmpty(){
        return first == null;
    }

    /*TODO WRITE THIS METHOD HOMEWORK
    this method will check to see if a queue contains a specified item using a LinkedList, not an ArrayList
    you'll need to uncomment the code around the method to begin
    */

   public boolean contains(GenericQueue<E> queue, E item){
       Node currentNode = queue.first; //makes a node that points to the first node in the queue given

       while(currentNode != null){ //while we are not at the end of the queue continue searching
           if(currentNode.value.equals(item)){ //so if the value of the current node equals item given
               return true;  //return true boolean (and exits out the method)
           }
           currentNode = currentNode.next; //traverse through the queue :)
       }
       return false; //if it completes while loop item is not found(false)

    }


    public void printQueue(){
        Node temp = first;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private class QueueIterator implements Iterator<E> {

        private Node current = first;
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

