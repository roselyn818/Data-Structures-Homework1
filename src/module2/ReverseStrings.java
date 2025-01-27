package module2;

public class ReverseStrings {
    public static void main(String[] args){
        String myString = "hello";
        String reversedString = reverseString(myString);

        System.out.println(reversedString);
        //Expected Output 'olleh'
    }

    /*TODO HOMEWORK CREATE THIS METHOD USING STACKS*/
    private static String reverseString(String myString) {
        String myReversedString = "";

       //creates a character stack instance
        GenericStack<Character> stack = new GenericStack<>();

        for(int i = 0; i < myString.length(); i++ ) { //loops through from the first character to the last & adds to stack
            stack.push(myString.charAt(i));
        }

        //now we can pop the contents which is perfect! since it
        // pops the characters from last to first (top of stack to bottom)
        while(!stack.isEmpty()){
            myReversedString += stack.pop(); //concatenate each character back into a single string
        }
        return myReversedString; //returns reversed string :)
    }

}
