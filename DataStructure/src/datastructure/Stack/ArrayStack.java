package datastructure.Stack;

public class ArrayStack {
/*
        begin   
        if top = 0 then stack empty;   
        item := stack(top);  
        top = top - 1;  
    end;    
    */
    int top;
    int maxsize = 10;
    int[] arr = new int[maxsize];

    boolean isEmpty() {
        return (top < 0);
    }

    ArrayStack() {//set intial values for new stack.
        top = -1;
    }

    boolean push(int val) {//make sure you are not reaching the max stack size.
        if (top == maxsize - 1) {
            System.out.println("Overflow !!");
            return false;
        } else {

            top++; //new array index
            arr[top] = val; //assign stack value in the new index
            System.out.println("Item pushed");
            return true;
        }
    }

    boolean pop() {
        if (top == -1) {//make sure you are not poping a null value
            System.out.println("Underflow !!");
            return false;
        } else {
            top--;//asign new index after removing the stack peek value.
            System.out.println("Item popped");
            return true;
        }
    }

    void display() {
        System.out.println("Printing stack elements .....");
        for (int i = top; i >= 0; i--) {//normal for loop to print the array values.
            System.out.println(arr[i]);
        }
    }
}


