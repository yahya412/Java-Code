package datastructure.Stack;
import datastructure.Node;

public class Stack {
   Node top; 
   
   
   public void push(int x) // insert at the beginning 
	{ 
		// create new node temp and allocate memory 
		Node temp = new Node(x); 

		// check if stack (heap) is full. Then inserting an 
		// element would lead to stack overflow 
		if (temp == null) { 
			System.out.print("\nHeap Overflow"); 
			return; 
		} 

		// put top reference into temp link 
		temp.next = top; 

		// update top reference 
		top = temp; 
	} 
   
   public void peek() 
	{ 
		// check for empty stack 
		if (top!=null) { 
		 System.out.println("the top data is "+top.data);  
		} 
		else { 
			System.out.println("Stack is empty"); 
		} 
        }
   public void pop() // remove at the beginning 
	{ 
		// check for stack underflow 
		if (top == null) { 
			System.out.print("\nStack Underflow"); 
			return; 
		} 

		// update the top pointer to point to the next node 
		top = (top).next; 
	} 
   public void display() 
	{ 
		// check for stack underflow 
		if (top == null) { 
			System.out.println("Stack Underflow"); 
			
		} 
		else { 
			Node temp = top; 
			while (temp != null) { 

				// print node data 
				System.out.println( temp.data); 

				// assign temp link to temp 
				temp = temp.next; 
			} 
		} 
	} 
   
}
