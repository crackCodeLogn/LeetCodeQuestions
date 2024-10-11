package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2024-10-10
 */
public class Q1942_M_TheNumberOfTheSmallestUnoccupiedChair {

  public static void main(String[] args) {
    Q1942_M_TheNumberOfTheSmallestUnoccupiedChair q1942MTheNumberOfTheSmallestUnoccupiedChair =
        new Q1942_M_TheNumberOfTheSmallestUnoccupiedChair();
    System.out.println(
        q1942MTheNumberOfTheSmallestUnoccupiedChair.smallestChair(
            new int[][] {
              {1, 4},
              {2, 3},
              {4, 6},
            },
            1)); // 1
    System.out.println(
        q1942MTheNumberOfTheSmallestUnoccupiedChair.smallestChair(
            new int[][] {
              {3, 10},
              {1, 5},
              {2, 6},
            },
            0)); // 2
  }

  public int smallestChair(int[][] times, int targetFriend) {
    List<Node> nodes = new ArrayList<>(times.length);
    int maxSeats = times.length;
    for (int i = 0; i < times.length; i++) nodes.add(new Node(times[i][0], times[i][1], i));
    nodes.sort(Comparator.comparingInt(Node::getArrival));

    PriorityQueue<Integer> seats = new PriorityQueue<>(maxSeats);
    for (int i = 0; i <= maxSeats; i++) seats.offer(i);

    PriorityQueue<Node> leaveQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getLeave));

    for (int i = 0; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      while (!leaveQueue.isEmpty() && leaveQueue.peek().getLeave() <= node.getArrival()) {
        Node pollNode = leaveQueue.poll();
        // empty seat at that chair
        seats.offer(pollNode.getSeat());
        pollNode.setSeat(-1);
      }
      Integer availSeat = seats.poll();
      if (node.getFriendIndex() == targetFriend) return availSeat;

      node.setSeat(availSeat);
      leaveQueue.offer(node);
    }

    return -1;
  }

  private static final class Node {
    private final int arrival;
    private final int leave;
    private final int friendIndex;
    private int seat = -1;

    public Node(int arrival, int leave, int friendIndex) {
      this.arrival = arrival;
      this.leave = leave;
      this.friendIndex = friendIndex;
    }

    public int getArrival() {
      return arrival;
    }

    public int getLeave() {
      return leave;
    }

    public int getFriendIndex() {
      return friendIndex;
    }

    public int getSeat() {
      return seat;
    }

    public void setSeat(int seat) {
      this.seat = seat;
    }
  }
}
