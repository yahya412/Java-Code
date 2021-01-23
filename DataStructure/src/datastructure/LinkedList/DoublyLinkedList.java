package datastructure.LinkedList;
import datastructure.Node;
public class DoublyLinkedList {

    Node head;
    Node tail;
//this function the defualt case and it addes the elemet in the last of the 
//linkedlist.
/*

    Step 1: IF PTR = NULL

     Write OVERFLOW
      Go to Step 11
     [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR -> NEXT
    Step 4: SET NEW_NODE -> DATA = VAL
    Step 5: SET NEW_NODE -> NEXT = NULL
    Step 6: SET TEMP = START
    Step 7: Repeat Step 8 while TEMP -> NEXT != NULL
    Step 8: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 9: SET TEMP -> NEXT = NEW_NODE
    Step 10C: SET NEW_NODE -> PREV = TEMP
    Step 11: EXIT
    
*/

    public void insert(int val) {
        Node node = head;
        Node n = new Node(val);
        if (head == null) {
            n.next = null;
            n.prev = null;
            head = n;
            tail = n;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = n;
            n.prev = node;
            tail = n;
        }

    }
//this function addes the value in specific location in the pre-defined linkedlist;
    //if you chose the wrong postion its by defualt added the value in the last element of the list.
/*

    Step 1: IF PTR = NULL

       Write OVERFLOW
       Go to Step 15
     [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR -> NEXT
    Step 4: SET NEW_NODE -> DATA = VAL
    Step 5: SET TEMP = START
    Step 6: SET I = 0
    Step 7: REPEAT 8 to 10 until I
    Step 8: SET TEMP = TEMP -> NEXT
    STEP 9: IF TEMP = NULL
    STEP 10: WRITE "LESS THAN DESIRED NO. OF ELEMENTS"

       GOTO STEP 15
       [END OF IF]
     [END OF LOOP]
    Step 11: SET NEW_NODE -> NEXT = TEMP -> NEXT
    Step 12: SET NEW_NODE -> PREV = TEMP
    Step 13 : SET TEMP -> NEXT = NEW_NODE
    Step 14: SET TEMP -> NEXT -> PREV = NEW_NODE
    Step 15: EXIT
    
*/
    public void insert(int val, int index) {
        Node node = head;
        Node n = new Node(val);
        Node temp = null;
        int pos = 0;
        if (head == null) {
            n.next = null;
            n.prev = null;
            head = n;
            tail = n;
        } else {
            while (node.next != null && pos != index) {
                temp = node;
                node = node.next;
                pos++;
            }
            temp.next = n;
            n.prev = node.prev;
            n.next = node;
            node.prev = n;

        }

    }
//function that remove the last elemet.
/*

    Step 1: IF HEAD = NULL

    Write UNDERFLOW
    Go to Step 7
    [END OF IF]
    Step 2: SET TEMP = HEAD
    Step 3: REPEAT STEP 4 WHILE TEMP->NEXT != NULL
    Step 4: SET TEMP = TEMP->NEXT

    [END OF LOOP]
    Step 5: SET TEMP ->PREV-> NEXT = NULL
    Step 6: FREE TEMP
    Step 7: EXIT
    
*/
    public void removeLast() {
        Node node = head;
        Node temp = null;
        if (head == null) {
            System.out.println("empty list");
        } else {
            while (node.next != null) {
                temp = node;
                node = node.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    //function that removes the fist elemet 
    /*
    
    STEP 1: IF HEAD = NULL

    WRITE UNDERFLOW
    GOTO STEP 6
    STEP 2: SET PTR = HEAD
    STEP 3: SET HEAD = HEAD → NEXT
    STEP 4: SET HEAD → PREV = NULL
    STEP 5: FREE PTR
    STEP 6: EXIT

    */
    
    public void removeFirst() {
        Node node = tail;
        Node temp = null;
        if (head == null) {
            System.out.println("Empty List");
        } else {
            while (node.prev != null) {
                temp = node;
                node = node.prev;
            }
            temp.prev = null;
            head = temp;
        }
    }

    //function that removes at specific index
    /*
    
    Step 1: IF HEAD = NULL

        Write empty list
       Go to Step 9
      [END OF IF]
    Step 2: SET TEMP = HEAD
    Step 3: Repeat Step 4 while pos  != index
    Step 4: SET TEMP = TEMP -> NEXT

       [END OF LOOP]
    Step 5: SET PTR = TEMP -> NEXT
    Step 6: SET TEMP -> NEXT = PTR -> NEXT
    Step 7: SET PTR -> NEXT -> PREV = TEMP
    Step 8: FREE PTR
    Step 9: EXIT

    
    */
    public void remove(int index) {
        Node node = head;
        Node temp = null;
        int pos = 0;
        if (head == null) {
            System.out.println("empty list");
        } else if (node.next == null) {
            head = null;
        } else {
            if (index == 0) {
                head = node.next;
                head.prev = null;
            } else {
                while (node.next != null && pos != index) {
                    temp = node;
                    node = node.next;
                    pos++;

                }

                temp.next = node.next;

                node.next.prev = temp;
            }

        }
    }

//    printing the values from the beging of DLL.
/*
Step 1: IF HEAD == NULL

  WRITE "empty list"
 GOTO STEP 6
 [END OF IF]
Step 2: Set PTR = HEAD
Step 3: Repeat step 4 and 5 while PTR != NULL
Step 4: Write PTR → data
Step 5: PTR = PTR → next
Step 6: Exi    
    
*/
    public void displyFront() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Itme value " + temp.data);
            temp = temp.next;
        }
    }

//	printing the values from last elemet of the DLL.
/*
Step 1: IF tail == NULL

  WRITE "empty list"
 GOTO STEP 6
 [END OF IF]
Step 2: Set PTR = HEAD
Step 3: Repeat step 4 and 5 while PTR != NULL
Step 4: Write PTR → data
Step 5: PTR = PTR → next
Step 6: Exi    
    
*/
    public void displyBack() {
        Node temp = tail;
        while (temp != null) {
            System.out.println("Itme value " + temp.data);
            temp = temp.prev;
        }
    }

}
