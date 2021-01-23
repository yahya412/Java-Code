package datastructure.Tree;
import datastructure.Node;

public class BinarySearchTree {
Node root;


/*

    Step 1: IF TREE = NULL
        Allocate memory for TREE
       SET TREE -> DATA = ITEM
      SET TREE -> LEFT = TREE -> RIGHT = NULL
      ELSE
       IF ITEM < TREE -> DATA
        Insert(TREE -> LEFT, ITEM)
      ELSE
       Insert(TREE -> RIGHT, ITEM)
      [END OF IF]
      [END OF IF]
    Step 2: END
*/
private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.data) {
	        current.prev = addRecursive(current.prev, value);
	    } else if (value > current.data) {
	        current.next = addRecursive(current.next, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}

public void add(int value) {
	    root = addRecursive(root, value);
	}


/*
    Step 1: IF ROOT -> DATA = ITEM OR ROOT = NULL
        Return ROOT
       ELSE
       IF ROOT < ROOT -> DATA
       Return search(ROOT -> LEFT, ITEM)
      ELSE
       Return search(ROOT -> RIGHT,ITEM)
      [END OF IF]
      [END OF IF]
    Step 2: END
*/
private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.data) {
	        return true;
	    } 
	    return value < current.data
	      ? containsNodeRecursive(current.prev, value)
	      : containsNodeRecursive(current.next, value);
	}
public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}


/*Delete (TREE, ITEM)

    Step 1: IF TREE = NULL
       Write "item not found in the tree" ELSE IF ITEM < TREE -> DATA
      Delete(TREE->LEFT, ITEM)
      ELSE IF ITEM > TREE -> DATA
       Delete(TREE -> RIGHT, ITEM)
      ELSE IF TREE -> LEFT AND TREE -> RIGHT
      SET TEMP = findLargestNode(TREE -> LEFT)
      SET TREE -> DATA = TEMP -> DATA
       Delete(TREE -> LEFT, TEMP -> DATA)
      ELSE
       SET TEMP = TREE
       IF TREE -> LEFT = NULL AND TREE -> RIGHT = NULL
       SET TREE = NULL
      ELSE IF TREE -> LEFT != NULL
      SET TREE = TREE -> LEFT
      ELSE
        SET TREE = TREE -> RIGHT
      [END OF IF]
      FREE TEMP
    [END OF IF]
    Step 2: END
*/
private Node deleteRecursive(Node current, int value) {
	    if (current == null) {
	        return null;
	    }
	 
	    if (value == current.data) {
	        // Node to delete found
	        // ... code to delete the node will go here
	    } 
	    if (value < current.data) {
	        current.prev = deleteRecursive(current.prev, value);
	        return current;
	    }
	    current.next = deleteRecursive(current.next, value);
	    return current;
	}
public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
}
