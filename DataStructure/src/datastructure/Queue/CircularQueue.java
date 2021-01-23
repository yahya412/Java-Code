package datastructure.Queue;

public class CircularQueue {

    public int maxSize = 10;
    private int queue[];
    int size = 0;
    int head = -1;
    int tail = -1;

    public CircularQueue(int maxSize) {
        queue = new int[maxSize];
    }

   
/*
    
    Step 1: IF (REAR+1)%MAX = FRONT
    Write " OVERFLOW "
    Goto step 4
    [End OF IF]
    Step 2: IF FRONT = -1 and REAR = -1
    SET FRONT = REAR = 0
    ELSE IF REAR = MAX - 1 and FRONT ! = 0
    SET REAR = 0
    ELSE
    SET REAR = (REAR + 1) % MAX
    [END OF IF]
    Step 3: SET QUEUE[REAR] = VAL
    Step 4: EXIT
*/
    public void add(int x) {
        if ((tail + 1) % maxSize == head) {
            System.out.println("OVERFLOW");
            return;
        } else if (head == -1 && tail == -1) {
            head = 0;
            tail = 0;
        } else if (tail == maxSize - 1 && head != 0) {
            tail = 0;
        } else {
            tail = (tail + 1) % maxSize;
        }
        queue[tail] = x;
    }

    /*
    
    Step 1: IF FRONT = -1
    Write " UNDERFLOW "
    Goto Step 4
    [END of IF]
    Step 2: SET VAL = QUEUE[FRONT]
    Step 3: IF FRONT = REAR
    SET FRONT = REAR = -1
    ELSE
    IF FRONT = MAX -1
    SET FRONT = 0
    ELSE
    SET FRONT = FRONT + 1
    [END of IF]
    [END OF IF]
    Step 4: EXIT
*/
    public void remove() {
      if(head == -1 & tail == -1)  
    {  
        System.out.println("UNDERFLOW");  
        return ;
    }  
    else if(head == tail)  
    {  
        head = -1;  
        tail = -1;  
    }  
    else if(head == maxSize -1)  
        {  
            head = 0;  
        }  
    else   
        head = head + 1;  
       
    }

    public int peek() {
        int x = 0;
        if (size == 0) {
            System.out.println("empty queue");

        } else {
            x = queue[head];
        }
        return x;

    }

    public void disply() {
        for (int i = head; i <= tail; i++) {
            System.out.println("element is " + queue[i]);
        }
    }

}
