package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-04-09
 */
public class Q2073_E_TimeNeededToBuyTickets {

    public static void main(String[] args) {
        Q2073_E_TimeNeededToBuyTickets q2073ETimeNeededToBuyTickets = new Q2073_E_TimeNeededToBuyTickets();
        System.out.println(q2073ETimeNeededToBuyTickets.timeRequiredToBuy(new int[]{2, 3, 2}, 2)); // 6
        System.out.println(q2073ETimeNeededToBuyTickets.timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0)); // 8
    }

    public int timeRequiredToBuy(int[] tickets, int k) { // 3ms
        int i = 0, n = tickets.length, time = 0;

        while (true) {
            time++;
            if (tickets[i] == 0) {
                i = (i + 1) % n;
                time--;
                continue;
            } else if (tickets[i] == 1) {
                if (i == k) return time;
            }
            tickets[i]--;
            i = (i + 1) % n;
        }
    }

    public int timeRequiredToBuy2(int[] tickets, int k) { // 10ms
        Queue<Node> queue = new LinkedList<>();
        Node target = null;
        for (int ticket : tickets) {
            Node node = new Node(ticket);
            if (k-- == 0) target = node;
            queue.offer(node);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            Node node = queue.poll();

            if (node.getTickets() == 1) {
                if (node == target) return time;
            } else {
                node.reduce();
                queue.offer(node);
            }
        }
        return 0;
    }

    private static final class Node {
        private int tickets;

        public Node(int tickets) {
            this.tickets = tickets;
        }

        public void reduce() {
            tickets--;
        }

        public int getTickets() {
            return tickets;
        }
    }

}
