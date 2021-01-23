package datastructure.Queue;
import datastructure.Node;



public class ArrayQueue {

    public int maxSize = 0;
    private int queue[];
    int size = 0;
    int head = 0;
    int tail = 0;

    public ArrayQueue(int maxSize) {
        queue = new int[maxSize];
    }

    public void add(int x) {
        if (size == queue.length -1) {
            System.out.println("full queue");
            return;
        }
        queue[tail] = x;
         tail ++;
        size++;

    }

    public int remove() {
        int x = 0;
        if (size == 0) {
            System.out.println("empty queue");

        } else {
            x = queue[head];
        }
        head ++;
        size--;
        return x;
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
    public void disply(){
        for (int i = head; i < tail; i++) {
            System.out.println("element is "+queue[i]);
        }
    }

}
