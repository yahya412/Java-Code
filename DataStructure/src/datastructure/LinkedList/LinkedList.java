package datastructure.LinkedList;
import datastructure.Node;
public class LinkedList {

    Node head;

    //this function adds makes the node constructor and adds the value in the last of linkedlist;
    /*
    
    Step 1: IF PTR = NULL

    Write OVERFLOW
         Go to Step 7
        [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR → NEXT
    Step 4: SET NEW_NODE → DATA = VAL
    Step 5: SET NEW_NODE → NEXT = HEAD
    Step 6: SET HEAD = NEW_NODE
    Step 7: EXIT

    */
    public void insert(int val) {
        Node node = head;
        Node n = new Node(val);
        if (node == null) {
            head = n;
        } else {
            while (node.next != null) {
                node = node.next;
            }
            node.next = n;
        }

    }

    //this function addes the value in specific location in the pre-defined linkedlist;
    //if you chose the wrong postion its by defualt added the value in the last element of the list.
    /*
    
    STEP 1: IF PTR = NULL

    WRITE OVERFLOW
        GOTO STEP 12
       END OF IF
    STEP 2: SET NEW_NODE = PTR
    STEP 3: NEW_NODE → DATA = VAL
    STEP 4: SET TEMP = HEAD
    STEP 5: SET I = 0
    STEP 6: REPEAT STEP 5 AND 6 UNTIL I
    STEP 7: TEMP = TEMP → NEXT
    STEP 8: IF TEMP = NULL

    WRITE "DESIRED NODE NOT PRESENT"
         GOTO STEP 12
        END OF IF
     END OF LOOP
    STEP 9: PTR → NEXT = TEMP → NEXT
    STEP 10: TEMP → NEXT = PTR
    STEP 11: SET PTR = NEW_NODE
    STEP 12: EXIT


    */
    public void insert(int val, int index) {
        Node node = head;
        Node n = new Node(val);
        Node temp = null;
        int pos = 0;
        if (node == null) {
            head = n;
        } else {
           //if the loops of the whole element finished before it reaches the index then add it in the last of linked list
            while (node.next != null && pos != index - 1) {
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
    Step 3: Repeat Steps 4 and 5 while PTR -> NEXT!= NULL
    Step 4: SET PREPTR = PTR
    Step 5: SET PTR = PTR -> NEXT

    [END OF LOOP]
    Step 6: SET PREPTR -> NEXT = NULL
    Step 7: FREE PTR
    Step 8: EXIT
    
*/
    public void remove() {
        Node node = head;
        Node current = null;
        if (node == null) {
            System.out.println(" Empty LinkedList");
        } else if (node.next == null) {
            head = null;
        } else {
            while (node.next != null) {
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
    
    STEP 1: IF HEAD = NULL

    WRITE UNDERFLOW
        GOTO STEP 10
       END OF IF
    STEP 2: SET TEMP = HEAD
    STEP 3: SET I = 0
    STEP 4: REPEAT STEP 5 TO 8 UNTIL I
    STEP 5: TEMP1 = TEMP
    STEP 6: TEMP = TEMP → NEXT
    STEP 7: IF TEMP = NULL

    WRITE "DESIRED NODE NOT PRESENT"
        GOTO STEP 12
        END OF IF
    STEP 8: I = I+1

    END OF LOOP
    STEP 9: TEMP1 → NEXT = TEMP → NEXT
    STEP 10: FREE TEMP
    STEP 11: EXIT

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
                while (node.next != null && pos != index - 1) {

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
      GOTO STEP 7
      END OF IF
    STEP 4: REPEAT STEP 5 AND 6 UNTIL PTR != NULL
    STEP 5: PRINT PTR→ DATA
    STEP 6: PTR = PTR → NEXT

    [END OF LOOP]
    STEP 7: EXIT

    */
    public void print() {
        Node p = head;

        while (p.next != null) {
            System.out.println("value is " + p.data);
            p = p.next;
        }
        System.out.println("last value is " + p.data);
    }

}
