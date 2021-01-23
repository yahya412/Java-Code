
package datastructure.Queue;
import datastructure.Node;


public class LinkedListQueue {

    private Node head = null;
    private Node tail = null;

    
    /*
    
    Step 1: Allocate the space for the new node PTR
    Step 2: SET PTR -> DATA = VAL
    Step 3: IF FRONT = NULL
    SET FRONT = REAR = PTR
    SET FRONT -> NEXT = REAR -> NEXT = NULL
    ELSE
    SET REAR -> NEXT = PTR
    SET REAR = PTR
    SET REAR -> NEXT = NULL
    [END OF IF]
    Step 4: END

    */
    
    public void add(int x) {
        Node temp = new Node(x);
        Node t=new Node(x);
        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
//            System.out.println(tail +""+ tail.next);
        }
        tail = temp;

    }

  
/*
    
    Step 1: IF FRONT = NULL
    Write " Underflow "
    Go to Step 5
    [END OF IF]
    Step 2: SET PTR = FRONT
    Step 3: SET FRONT = FRONT -> NEXT
    Step 4: FREE PTR
    Step 5: END

    */
   
public int remove() {
        int x;
        if (head == null) {
            System.out.println("empty queue");
            return 0;
        } else {
            x = head.data;
            if (tail == head) {
                tail = null;
            }
            head = head.next;
            return x;
        }

    }

    
    
   

public int peek() {
        if (head == null) {
            return 0;
        }
        return head.data;
    }

    
   

public void disply() {
        Node temp = head;

       while(temp!=null) {

            System.out.println("elemet is " + temp.data);
            temp=temp.next;
        }

    }

}
