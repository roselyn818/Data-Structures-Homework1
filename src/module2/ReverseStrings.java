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

        //puts the first character of the string first to it'll be at the bottom of the stack
        GenericStack<Character> stack = new GenericStack<>(myString.charAt(0));

        for(int i = 1; i < myString.length(); i++ ) { //loops through from the second character to the last & adds to stack
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
