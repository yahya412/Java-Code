package datastructure.Queue;

public class Deque {

    static final int MAX = 100;
    public int arr[];
    public int front;
    public int rear;
    public int size;

    public Deque(int size) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }

    /*// Operations on Deque: 
	public void insertfront(int key); 
	public void insertrear(int key); 
	public void deletefront(); 
	public void deleterear(); 
	public bool isFull(); 
	public bool isEmpty(); 
	public int getFront(); 
	public int getRear();*/
    // Checks whether Deque is full or not. 
    public boolean isFull() {
        return ((front == 0 && rear == size - 1)
                || front == rear + 1);
    }

    // Checks whether Deque is empty or not. 
    public boolean isEmpty() {
        return (front == -1);
    }

    // Inserts an element at front 
    /*
    a). First we check deque if Full or Not
b). IF Front == 0 || initial position, move Front
                     to points last index of array
       front = size - 1
    Else decremented front by '1' and push 
         current key into Arr[ Front] = key 
Rear remain same.*/
    public void insertfront(int key) {
        // check whether Deque if full or not 
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        // If queue is initially empty 
        if (front == -1) {
            front = 0;
            rear = 0;
        } // front is at first position of queue 
        else if (front == 0) {
            front = size - 1;
        } else // decrement front end by '1' 
        {
            front = front - 1;
        }

        // insert current element into Deque 
        arr[front] = key;
    }

    // function to inset element at rear end 
    // of Deque. 
/*
    a). First we check deque if Full or Not 
    b). IF Rear == Size-1 
       then reinitialize Rear = 0 ;
    Else increment Rear by '1'
    and push current key into Arr[ rear ] = key 
    Front remain same.*/
    public void insertrear(int key) {
        if (isFull()) {
            System.out.println(" Overflow ");
            return;
        }

        // If queue is initially empty 
        if (front == -1) {
            front = 0;
            rear = 0;
        } // rear is at last position of queue 
        else if (rear == size - 1) {
            rear = 0;
        } // increment rear end by '1' 
        else {
            rear = rear + 1;
        }

        // insert current element into Deque 
        arr[rear] = key;
    }

    // Deletes element at front end of Deque 
    /*
    a). first Check deque is Empty or Not
    b).  If deque has only one element
            front = -1 ; rear =-1 ;
    Else IF front points to the last index of the array
         it's means we have no more elements in array so 
          we move front to points first index of array
            front = 0 ;
    Else || increment Front by '1'  
            front = front+1;
    
    */
    public void deletefront() {
        // check whether Deque is empty or not 
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }

        // Deque has only one element 
        if (front == rear) {
            front = -1;
            rear = -1;
        } else // back to initial position 
        if (front == size - 1) {
            front = 0;
        } else // increment front by '1' to remove current 
        // front value from Deque 
        {
            front = front + 1;
        }
    }

    // Delete element at rear end of Deque 
   
    /*a). first Check deque is Empty or Not
      b).  If deque has only one element
        front = -1 ; rear =-1 ;
        Else IF Rear points to the first index of array
         it's means we have to move rear to points 
         last index [ now first inserted element at 
         front end become rear end ]  
            rear = size-1 ;
        Else || decrease rear by '1'  
            rear = rear-1;*/
    public void deleterear() {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return;
        }

        // Deque has only one element 
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear = rear - 1;
        }
    }

    // Returns front element of Deque 
    public int getFront() {
        // check whether Deque is empty or not 
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }

    // function return rear element of Deque 
    public int getRear() {
        // check whether Deque is empty or not 
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

}
