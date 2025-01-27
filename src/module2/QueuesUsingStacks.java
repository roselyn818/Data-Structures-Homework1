package module2;

import module2.GenericStack;
import org.w3c.dom.Node;

public class QueuesUsingStacks {
    private GenericStack<Integer> stack1;
    private GenericStack<Integer> stack2;

    public QueuesUsingStacks(){
        stack1 = new GenericStack<Integer>(); //creates two instance stacks
        stack2 = new GenericStack<Integer>(); //changed to be empty at first
    }
    //The key idea here is to first enqueue (add) items to stack 1 so the first item will be at the bottom.
    //then when dequeuing and peeking pop items to stack 2, which reverses the order, and puts the first item at the top of stack 2
    //therefore achieves FIFO algorithm

    //TODO write this method using the 2 stacks provided above only
    //ADDS items so goal is to have first item at the bottom of stack
    public void enqueue(Integer value){
        //push item to stack1
        stack1.push(value);
    }

    //dequeue so (first in, first out)
    //TODO Write this method using the 2 stacks provided above only
    public Integer dequeue(){
        while(!stack1.isEmpty()){      //so while stack1 is not empty
            stack2.push(stack1.pop()); //reverses the order
        }

        return stack2.pop(); //pops the first item in the queue
                             //which is the top of stack2
    }

    public int peek(){
        while(!stack1.isEmpty()){  //so while stack1 is not empty
            stack2.push(stack1.pop()); //reverses the order
        }
        return stack2.peek(); //changed to peek stack2 since the top should be the first item enqueued
    }

    private boolean isEmpty1(){ //check if stack1 is empty changed to private only used here
        return stack1.isEmpty();
    }
    public boolean isEmpty(){ //check if queue is empty (changed to stack2)
        return stack2.isEmpty();
    }
}



