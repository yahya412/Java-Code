package datastructure.LinkedList;
import datastructure.Node;

public class CircularDoublyLinkedList {

    Node head;
    Node tail;
//this function the defualt case and it addes the elemet in the last of the 
//linkedlist.
/*
    Step 1: IF PTR = NULL

    Write OVERFLOW
    Go to Step 12
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
    Step 10: SET NEW_NODE -> PREV = TEMP
    Step 11: SET HEAD -> PREV = NEW_NODE
    Step 12: EXIT
     */
 /*  public void insert(int val) {
    Node n = new Node(val);
    Node node = null;
    if (head == null) {
    n.next = head;
    n.prev = head;
    head = n;
    tail = n;
    System.out.println("intered new value: " + n.data);
    
    } else
    node=head.prev;
    
    n.next=head;
    head.prev=n;
    n.prev=node;
    node.next=n;
    
    
    //            System.out.println("intered new value: " + n.data);
    //            System.out.println(n.next +" "+n.prev+" "+n.data);
    
    
    }*/
    public void insert(int value) {
        // List is empty so create a single node furst 
        if (head == null) {
            Node n = new Node(value);

            n.next = n.prev = n;
            head = n;
            return;
        }

        // find last node in the list if list is not empty
        Node last = (head).prev;    //previous of head is the last node

        // create a new node  
        Node n = new Node(value);

        // next of new_node will point to head since list is circular  
        n.next = head;

        // similarly previous of head will be new_node
        (head).prev = n;

        // change new_node=>prev to last  
        n.prev = last;

        // Make new node next of old last  
        last.next = n;
    }

//this function addes the value in specific location in the pre-defined linkedlist;
    //if you chose the wrong postion its by defualt added the value in the last element of the list.
/*
    Step 1: IF PTR = NULL

    Write OVERFLOW
    Go to Step 13
    [END OF IF]
    Step 2: SET NEW_NODE = PTR
    Step 3: SET PTR = PTR -> NEXT
    Step 4: SET NEW_NODE -> DATA = VAL
    Step 5: SET TEMP = HEAD
    Step 6: Repeat Step 7 while TEMP -> NEXT != HEAD
    Step 7: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 8: SET TEMP -> NEXT = NEW_NODE
    Step 9: SET NEW_NODE -> PREV = TEMP
    Step 1 : SET NEW_NODE -> NEXT = HEAD
    Step 11: SET HEAD -> PREV = NEW_NODE
    Step 12: SET HEAD = NEW_NODE
    Step 13: EXIT
     */
    public void insert(int val, int index) {
        Node node = head;
        Node n = new Node(val);
        Node temp = null;
        int pos = 0;
        if (head == null) {
            n.next = head;
            n.prev = head;
            head = n;
            tail = n;
        } else {
            while (node.next != head && pos != index) {
                temp = node;
                node = node.next;
                pos++;
            }
            temp.next = n;
            n.prev = node.prev;
            n.next = node;
            node.prev = n;
            tail = n;

        }

    }
//function that remove the last elemet.
/*
    Step 1: IF HEAD = NULL

    Write UNDERFLOW
    Go to Step 8
    [END OF IF]
    Step 2: SET TEMP = HEAD
    Step 3: Repeat Step 4 while TEMP -> NEXT != HEAD
    Step 4: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 5: SET TEMP -> PREV -> NEXT = HEAD
    Step 6: SET HEAD -> PREV = TEMP -> PREV
    Step 7: FREE TEMP
    Step 8: EXIT
     */
    public void removeLast() {
        Node node = head;
        Node temp = null;
        if (head == null) {
            System.out.println("empty list");
        } else {
            while (node.next != head) {
                temp = node;
                node = node.next;
            }
            temp.next = head;
            tail = temp;
        }
    }

    //function that removes the fist elemet 
    /*
    Step 1: IF HEAD = NULL

    Write UNDERFLOW
    Go to Step 8
    [END OF IF]
    Step 2: SET TEMP = HEAD
    Step 3: Repeat Step 4 while TEMP -> NEXT != HEAD
    Step 4: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 5: SET TEMP -> NEXT = HEAD -> NEXT
    Step 6: SET HEAD -> NEXT -> PREV = TEMP
    Step 7: FREE HEAD
    Step 8: SET HEAD = TEMP -> NEXT
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
            head = temp;
            temp.prev = head;

        }
    }

    //function that removes at specific index
    /*
    Step 1: IF HEAD = NULL

    Write UNDERFLOW
    Go to Step 8
    [END OF IF]
    Step 2: SET TEMP = HEAD
    Step 3: Repeat Step 4 while TEMP -> NEXT != HEAD
    Step 4: SET TEMP = TEMP -> NEXT

    [END OF LOOP]
    Step 5: SET TEMP -> NEXT = HEAD -> NEXT
    Step 6: SET HEAD -> NEXT -> PREV = TEMP
    Step 7: FREE HEAD
    Step 8: SET HEAD = TEMP -> NEXT
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
                while (node.next != head && pos != index) {
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
    public void displyFront() {
        Node temp = head;
        System.out.println("printed value " + temp.data);

        do {
            temp = temp.next;
            System.out.println("printed1 value " + temp.data);

        } while (temp.next != head);
    }

//	printing the values from last elemet of the DLL.
    public void displyBack() {
        Node temp = head.prev;
        System.out.println("printed value " + temp.data);

        do {
            temp = temp.prev;
            System.out.println("printed1 value " + temp.data);

        } while (temp.prev != head);

    }
}
