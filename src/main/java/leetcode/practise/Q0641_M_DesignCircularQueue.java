package leetcode.practise;

import java.util.LinkedList;

/**
 * @author Vivek
 * @since 2024-09-27
 */
public class Q0641_M_DesignCircularQueue {

  class MyCircularDeque { // 4ms

    private final int LIMIT;
    private Node front;
    private Node rear;
    private int count;
    public MyCircularDeque(int k) {
      count = 0;
      front = null;
      rear = null;
      LIMIT = k;
    }

    public boolean insertFront(int value) {
      if (count < LIMIT) {
        Node newNode = new Node(value);
        newNode.next = front;
        if (front != null) front.prev = newNode;
        front = newNode;
        if (count == 0) rear = newNode;
        count++;
        return true;
      }
      return false;
    }

    public boolean insertLast(int value) {
      if (count < LIMIT) {
        Node newNode = new Node(value);
        newNode.prev = rear;
        if (rear != null) rear.next = newNode;
        rear = newNode;
        if (count == 0) front = newNode;
        count++;
        return true;
      }
      return false;
    }

    public boolean deleteFront() {
      if (isEmpty()) return false;
      count--;
      front = front.next;
      if (count == 0) front = rear = null;
      return true;
    }

    public boolean deleteLast() {
      if (isEmpty()) return false;
      count--;
      rear = rear.prev;
      if (count == 0) front = rear = null;
      return true;
    }

    public int getFront() {
      if (isEmpty()) return -1;
      return front.val;
    }

    public int getRear() {
      if (isEmpty()) return -1;
      return rear.val;
    }

    public boolean isEmpty() {
      return count == 0;
    }

    public boolean isFull() {
      return count == LIMIT;
    }

    private final class Node {
      int val;
      Node prev;
      Node next;

      public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
      }
    }
  }

  class MyCircularDeque2 { // 5 ms

    private final LinkedList<Integer> queue;
    private final int LIMIT;

    public MyCircularDeque2(int k) {
      queue = new LinkedList<>();
      LIMIT = k;
    }

    public boolean insertFront(int value) {
      if (queue.size() < LIMIT) {
        queue.addFirst(value);
        return true;
      }
      return false;
    }

    public boolean insertLast(int value) {
      if (queue.size() < LIMIT) {
        queue.addLast(value);
        return true;
      }
      return false;
    }

    public boolean deleteFront() {
      if (isEmpty()) return false;
      queue.removeFirst();
      return true;
    }

    public boolean deleteLast() {
      if (isEmpty()) return false;
      queue.removeLast();
      return true;
    }

    public int getFront() {
      if (isEmpty()) return -1;
      return queue.getFirst();
    }

    public int getRear() {
      if (isEmpty()) return -1;
      return queue.getLast();
    }

    public boolean isEmpty() {
      return queue.isEmpty();
    }

    public boolean isFull() {
      return queue.size() == LIMIT;
    }
  }
}
