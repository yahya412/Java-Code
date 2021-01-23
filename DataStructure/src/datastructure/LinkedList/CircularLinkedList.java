
package datastructure.LinkedList;
import datastructure.Node;

public class CircularLinkedList {

    Node head;

    //this function adds makes the node constructor and adds the value in the last of linkedlist;
    /*
    
    Step 1: IF PTR = NULL

      Write OVERFLOW
     Go to Step 11
     [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR -> NEXT
    Step 4: SET NEW_NODE -> DATA = VAL
    Step 5: SET TEMP = HEAD
    Step 6: Repeat Step 8 while TEMP -> NEXT != HEAD
    Step 7: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 8: SET NEW_NODE -> NEXT = HEAD
    Step 9: SET TEMP → NEXT = NEW_NODE
    Step 10: SET HEAD = NEW_NODE
    Step 11: EXIT

    
    */
    public void insert(int val) {
        Node node = head;
        Node n = new Node(val);
        if (node == null) {
            
            head = n;
            head.next=head;
            
        } else {
            while (node.next != head) {
                node = node.next;
            }
            node.next = n;
            n.next=head;
        }

    }

    //this function addes the value in specific location in the pre-defined linkedlist;
    //if you chose the wrong postion its by defualt added the value in the last element of the list.
    /*
    
    Step 1: IF PTR = NULL

      Write OVERFLOW
       Go to Step 1
      [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR -> NEXT
    Step 4: SET NEW_NODE -> DATA = VAL
    Step 5: SET NEW_NODE -> NEXT = HEAD
    Step 6: SET TEMP = HEAD
    Step 7: Repeat Step 8 while TEMP -> NEXT != HEAD
    Step 8: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 9: SET TEMP -> NEXT = NEW_NODE
    Step 10: EXIT

    
    */
    
    public void insert(int val, int index) {
        Node node = head;
        Node n = new Node(val);
        Node temp = null;
        int pos = 0;
        if (node == null) {
            head = n;
            head.next=head;
        } else {
            while (node.next != head && pos != index - 1) {
                node = node.next;
                pos++;
            }
            temp = node.next;
            node.next = n;
            n.next = temp;
        }

    }
//delete the last elemet of the linked list.
/*

    Step 1: IF HEAD = NULL

      Write UNDERFLOW
       Go to Step 8
      [END OF IF]
    Step 2: SET PTR = HEAD
    Step 3: Repeat Steps 4 and 5 while PTR -> NEXT != HEAD
    Step 4: SET PREPTR = PTR
    Step 5: SET PTR = PTR -> NEXT

    [END OF LOOP]
    Step 6: SET PREPTR -> NEXT = HEAD
    Step 7: FREE PTR
    Step 8: EXIT
    
*/
    public void remove() {
        Node node = head;
        Node current = null;
        if (node == null) {
            System.out.println(" Empty LinkedList");
        } else if (node.next == head) {
            head = null;
        } else {
            while (node.next != head) {
                current = node;
                node = node.next;

            }

            current.next = null;
        }

    }

    //this function remove the elemet in specific postions .
    //if the index entered by the users is more than the linkedlist size it 
    //removes the last elemet by defual.
    /*
    Step 1: IF HEAD = NULL

    Write UNDERFLOW
      Go to Step 8
     [END OF IF]
    Step 2: SET PTR = HEAD
    Step 3: Repeat Step 4 while PTR → NEXT != HEAD
    Step 4: SET PTR = PTR → next

    [END OF LOOP]
    Step 5: SET PTR → NEXT = HEAD → NEXT
    Step 6: FREE HEAD
    Step 7: SET HEAD = PTR → NEXT
    Step 8: EXIT
*/
    public void remove(int index) {
        Node node = head;
        Node current = head;
       
        int pos = -1;
        if (node == null) {
            System.out.println(" Empty LinkedList");
        } else if (node.next == null) {
            head = null;
        } else {
            if (index == 0) {
                head = node.next;
            } else {
                while (node.next != head && pos != index - 1) {

                    current = node;
                    node = node.next;

                    pos++;
                   

                }
                if (node.next == null) {
                    current.next = null;
                } else {
                    current.next = current.next.next;
                }
            }
        }

    }

//displys the whole elemet of the linkedlist.
    
/*
    STEP 1: SET PTR = HEAD
    STEP 2: IF PTR = NULL

    WRITE "EMPTY LIST"
    GOTO STEP 8
    END OF IF
    STEP 4: REPEAT STEP 5 AND 6 UNTIL PTR → NEXT != HEAD
    STEP 5: PRINT PTR → DATA
    STEP 6: PTR = PTR → NEXT

    [END OF LOOP]
    STEP 7: PRINT PTR→ DATA
    STEP 8: EXIT
*/
    public void print() {
        Node p = head;

        while (p.next != head) {
            System.out.println("value is " + p.data);
            p = p.next;
        }
        System.out.println("last value is " + p.data);
    }

}
