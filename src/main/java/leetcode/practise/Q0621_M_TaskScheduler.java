package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-03-19
 */
public class Q0621_M_TaskScheduler {

    private static int n;
    private static int time;

    /*public int leastInterval(char[] tasks, int n) {
        char[] data = new char[1_0000_000 + 1];
        Node[] queue = new Node[26];
        for (int i = 0; i < 26; i++) queue[i] = new Node((char) (i + 'A'));
        for (char ch : tasks) queue[ch - 'A'].augmentCount();
        Arrays.sort(queue, Comparator.comparingInt(Node::getCount).reversed());

        for (int i = 0; i < 26 && queue[i].getCount() > 0; i++) {
            int cnt = queue[i].getCount();
            while (cnt-- > 0) {

            }
        }

        return -1;
    }*/

    public static void main(String[] args) {
        Q0621_M_TaskScheduler q0621MTaskScheduler = new Q0621_M_TaskScheduler();
        System.out.println(q0621MTaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
        System.out.println(q0621MTaskScheduler.leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1)); // 6
        System.out.println(q0621MTaskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3)); // 10
        System.out.println(q0621MTaskScheduler.leastInterval(new char[]{'A', 'B', 'A'}, 2)); // 4
    }

    public int leastInterval(char[] tasks, int n) {
        Q0621_M_TaskScheduler.n = n;
        time = 0;
        Node[] queue = new Node[26];
        for (int i = 0; i < 26; i++) queue[i] = new Node((char) (i + 'A'));

        for (char ch : tasks) queue[ch - 'A'].augmentCount();

        while (true) {
            int index = compute(queue);
            if (index == -1) {
                time++;
                continue;
            }
            if (index == -99) break;

            Node node = queue[index];
            if (node.getLastIndex() == -1 || time - node.getLastIndex() > n) {
                node.reduceCount();
                node.setLastIndex(time);
            }
            time++;
        }
        return time;
    }

    private int compute(Node[] queue) {
        int target = -1;
        boolean found = false;

        for (int i = 0; i < queue.length; i++) {
            Node node = queue[i];
            if (node.getCount() > 0) {
                found = true;
                if (time - node.getLastIndex() > n) {
                    node.resetLastIndex();
                }
                if (node.getLastIndex() == -1) {
                    if (target == -1) {
                        target = i;
                    } else {
                        if (node.getCount() > queue[target].getCount()) {
                            target = i;
                        }
                    }
                }
            }
        }
        return found ? target : -99;
    }

    private static class Node implements Comparable<Node> {
        private final char ch;
        private int count;
        private int lastIndex;

        public Node(char ch) {
            this.ch = ch;
            this.count = 0;
            this.lastIndex = -1;
        }

        @Override
        public int compareTo(Node o) {
            int change = 0;
            if (time - lastIndex > n) {
                this.resetLastIndex();
                change = -1;
            }
            if (time - o.lastIndex > n) {
                o.resetLastIndex();
                change = 1;
            }
            if (this.lastIndex == -1 && o.lastIndex == -1) {
                return o.count - this.count;
            }
            if (this.lastIndex == -1) return -1;
            if (o.lastIndex == -1) return 1;
            return change;
        }

        public void reduceCount() {
            count--;
        }

        public void resetLastIndex() {
            lastIndex = -1;
        }

        public void augmentCount() {
            this.count++;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "ch=" + ch +
                    ", count=" + count +
                    ", lastIndex=" + lastIndex +
                    '}';
            return sb;
        }

        public int getCount() {
            return count;
        }

        public int getLastIndex() {
            return lastIndex;
        }

        public void setLastIndex(int lastIndex) {
            this.lastIndex = lastIndex;
        }
    }
}
