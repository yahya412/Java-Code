package datastructure.Tree;

import datastructure.Node;

public class BinaryTree {

   public Node root;

public BinaryTree(){
    root=null;
}

/*Step 1: Repeat Steps 2 to 4 while TREE != NULL
Step 2: POSTORDER(TREE -> LEFT)
Step 3: POSTORDER(TREE -> RIGHT)
Step 4: Write TREE -> DATA
[END OF LOOP]
Step 5: END*/
	/* Given a binary tree, print its nodes according to the 
	"bottom-up" postorder traversal. */
	public void printPostorder(Node node) 
	{ 
		if (node == null) 
			return; 

		// first recur on left subtree 
		printPostorder(node.prev); 

		// then recur on right subtree 
		printPostorder(node.next); 

		// now deal with the node 
		System.out.print(node.data + " "); 
	} 
/*
    Step 1: Repeat Steps 2 to 4 while TREE != NULL
    Step 2: INORDER(TREE -> LEFT)
    Step 3: Write TREE -> DATA
    Step 4: INORDER(TREE -> RIGHT)
    [END OF LOOP]
    Step 5: END
*/
	/* Given a binary tree, print its nodes in inorder*/
	public void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first recur on left child */
		printInorder(node.prev); 

		/* then print the data of node */
		System.out.print(node.data + " "); 

		/* now recur on right child */
		printInorder(node.next); 
	} 

        
        /*
        
    Step 1: Repeat Steps 2 to 4 while TREE != NULL
    Step 2: Write TREE -> DATA
    Step 3: PREORDER(TREE -> LEFT)
    Step 4: PREORDER(TREE -> RIGHT)
    [END OF LOOP]
    Step 5: END
*/
	/* Given a binary tree, print its nodes in preorder*/
	public void printPreorder(Node node) 
	{ 
		if (node == null) 
			return; 

		/* first print data of node */
		System.out.print(node.data + " "); 

		/* then recur on left sutree */
		printPreorder(node.prev); 

		/* now recur on right subtree */
		printPreorder(node.next); 
	} 

	// Wrappers over above recursive functions 
	public void printPostorder() {	 printPostorder(root); } 
	public void printInorder() {	 printInorder(root); } 
	public void printPreorder() {	 printPreorder(root); } 

	
} 
