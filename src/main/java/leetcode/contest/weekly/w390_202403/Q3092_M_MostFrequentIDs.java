package leetcode.contest.weekly.w390_202403;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-03-24
 */
public class Q3092_M_MostFrequentIDs {

    public static void main(String[] args) {
        Q3092_M_MostFrequentIDs q3092MMostFrequentIDs = new Q3092_M_MostFrequentIDs();
        System.out.println(Arrays.toString(q3092MMostFrequentIDs.mostFrequentIDs(new int[]{2, 3, 2, 1}, new int[]{3, 2, -3, 1})));
        System.out.println(Arrays.toString(q3092MMostFrequentIDs.mostFrequentIDs(new int[]{5, 5, 3}, new int[]{2, -2, 1})));
    }

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, Long> counter = new HashMap<>();
        Map<Integer, Node> noder = new HashMap<>();
        PriorityQueue<Node> data = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int count = freq[i];
            //Node node = noder.computeIfAbsent(num, Node::new);
            Node node = new Node(num);
            node.update(count + counter.getOrDefault(num, 0L));
            //data.remove(node);
            Node exit = null;
//            node.update(count);
            counter.put(num, counter.containsKey(num) ? counter.get(num) + count : count);
            if (counter.get(num) > 0) {
                data.offer(node);
                exit = data.poll();
                while (exit != null && exit.getCount() != counter.getOrDefault(exit.getNum(), -1L)) {
                    exit = data.poll();
                }
                if (exit != null)
                    data.offer(exit);
            } else {
                exit = data.poll();
                while (exit != null && counter.getOrDefault(exit.getNum(), 0L) == 0) exit = data.poll();
                if (exit != null)
                    data.offer(exit);
                //noder.remove(num);
//                counter.remove(num);
            }

            res[i] = exit == null ? 0 : exit.getCount();
        }

        return res;
    }

    private static final class Node implements Comparable<Node> {
        private final int num;
        private long count = 0;

        public Node(int num) {
            this.num = num;
        }

        public void update(long cnt) {
            count += cnt;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public long getCount() {
            return count;
        }

        public int getNum() {
            return num;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "num=" + num +
                    ", count=" + count +
                    '}';
            return sb;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count <= 0 ? 1 : -1;
        }
    }
}
