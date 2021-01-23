package datastructure.Tree;

import datastructure.Node;

public class AVLTree {

    public Node root;

    // A utility function to get the height of the tree 
    public int height(Node N) {
        if (N == null) {
            return 0;
        }

        return N.height;
    }

    // A utility function to get maximum of two integers 
    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to next rotate subtree rooted with y 
    // See the diagram given above. 
    public Node rightRotate(Node y) {
        Node x = y.prev;
        Node T2 = x.next;

        // Perform rotation 
        x.next = y;
        y.prev = T2;

        // Update heights 
        y.height = max(height(y.prev), height(y.next)) + 1;
        x.height = max(height(x.prev), height(x.next)) + 1;

        // Return new root 
        return x;
    }

    // A utility function to prev rotate subtree rooted with x 
    // See the diagram given above. 
    public Node leftRotate(Node x) {
        Node y = x.next;
        Node T2 = y.prev;

        // Perform rotation 
        y.prev = x;
        x.next = T2;

        // Update heights 
        x.height = max(height(x.prev), height(x.next)) + 1;
        y.height = max(height(y.prev), height(y.next)) + 1;

        // Return new root 
        return y;
    }

    // Get Balance factor of node N 
    public int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

        return height(N.prev) - height(N.next);
    }

    public Node insert(Node node, int data) {

        /* 1. Perform the normal BST insertion */
        if (node == null) {
            return (new Node(data));
        }

        if (data < node.data) {
            node.prev = insert(node.prev, data);
        } else if (data > node.data) {
            node.next = insert(node.next, data);
        } else // Duplicate datas not allowed 
        {
            return node;
        }

        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.prev),
                height(node.next));

        /* 3. Get the balance factor of this ancestor 
			node to check whether this node became 
			unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there 
        // are 4 cases Left Left Case 
        if (balance > 1 && data < node.prev.data) {
            return rightRotate(node);
        }

        // Right Right Case 
        if (balance < -1 && data > node.next.data) {
            return leftRotate(node);
        }

        // Left Right Case 
        if (balance > 1 && data > node.prev.data) {
            node.prev = leftRotate(node.prev);
            return rightRotate(node);
        }

        // Right Left Case 
        if (balance < -1 && data < node.next.data) {
            node.next = rightRotate(node.next);
            return leftRotate(node);
        }

        /* return the (unchanged) node pointer */
        return node;
    }
    
    
    
	/* Given a non-empty binary search tree, return the 
	node with minimum key value found in that tree. 
	Note that the entire tree does not need to be 
	searched. */
	Node minValueNode(Node node) 
	{ 
		Node current = node; 

		/* loop down to find the leftmost leaf */
		while (current.prev != null) 
		current = current.prev; 

		return current; 
	} 

   public Node deleteNode(Node root, int data) 
	{ 
		// STEP 1: PERFORM STANDARD BST DELETE 
		if (root == null) 
			return root; 

		// If the data to be deleted is smaller than 
		// the root's data, then it lies in prev subtree 
		if (data < root.data) 
			root.prev = deleteNode(root.prev, data); 

		// If the data to be deleted is greater than the 
		// root's data, then it lies in next subtree 
		else if (data > root.data) 
			root.next = deleteNode(root.next, data); 

		// if data is same as root's data, then this is the node 
		// to be deleted 
		else
		{ 

			// node with only one child or no child 
			if ((root.prev == null) || (root.next == null)) 
			{ 
				Node temp = null; 
				if (temp == root.prev) 
					temp = root.next; 
				else
					temp = root.prev; 

				// No child case 
				if (temp == null) 
				{ 
					temp = root; 
					root = null; 
				} 
				else // One child case 
					root = temp; // Copy the contents of 
								// the non-empty child 
			} 
			else
			{ 

				// node with two children: Get the inorder 
				// successor (smallest in the next subtree) 
				Node temp = minValueNode(root.next); 

				// Copy the inorder successor's data to this node 
				root.data = temp.data; 

				// Delete the inorder successor 
				root.next = deleteNode(root.next, temp.data); 
			} 
		} 

		// If the tree had only one node then return 
		if (root == null) 
			return root; 

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
		root.height = max(height(root.prev), height(root.next)) + 1; 

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
		// this node became unbalanced) 
		int balance = getBalance(root); 

		// If this node becomes unbalanced, then there are 4 cases 
		// Left Left Case 
		if (balance > 1 && getBalance(root.prev) >= 0) 
			return rightRotate(root); 

		// Left Right Case 
		if (balance > 1 && getBalance(root.prev) < 0) 
		{ 
			root.prev = leftRotate(root.prev); 
			return rightRotate(root); 
		} 

		// Right Right Case 
		if (balance < -1 && getBalance(root.next) <= 0) 
			return leftRotate(root); 

		// Right Left Case 
		if (balance < -1 && getBalance(root.next) > 0) 
		{ 
			root.next = rightRotate(root.next); 
			return leftRotate(root); 
		} 

		return root; 
	} 


    // A utility function to print preorder traversal 
    // of the tree. 
    // The function also prints height of every node 
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.prev);
            preOrder(node.next);
        }
    }

}
