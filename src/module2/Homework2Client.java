package module2;

import module2.QueuesUsingStacks;

public class Homework2Client {

    public static void main(String[] args) {

        //CONTAINS METHOD testing (Queue)
        GenericQueue<Integer> queue = new GenericQueue<>(1); //creating an instance of a queue
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.contains(queue,2)); //calls method (should be true)
        System.out.println(queue.contains(queue,5)); //calls method (should be false)

        //CONTAINS METHOD testing (Stack)
        GenericStack<String> stack = new GenericStack<>(); //creating an empty instance of a stack
        stack.push("hiii");
        stack.push("how");
        stack.push("you");
        stack.push("doing :) ");
        System.out.println(stack.contains(stack,"you")); //calls method (should be true)
        System.out.println(stack.contains(stack,"hey")); //calls method (should be false)

        //QUEUES USING STACKS testing
        QueuesUsingStacks queueUsingStacks = new QueuesUsingStacks();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(5);
        queueUsingStacks.enqueue(94);
        queueUsingStacks.enqueue(65);
        queueUsingStacks.enqueue(54);
        queueUsingStacks.enqueue(42);

        queueUsingStacks.dequeue();
        queueUsingStacks.dequeue();
        queueUsingStacks.dequeue();

        System.out.println("The Front of the Queue is " + queueUsingStacks.peek()); //should be 65



        System.out.println("Is the Queue Empty?: " + queueUsingStacks.isEmpty()); //should be false
    }
}
