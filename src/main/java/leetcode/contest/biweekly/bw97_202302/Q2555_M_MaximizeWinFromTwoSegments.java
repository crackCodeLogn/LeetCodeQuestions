package leetcode.contest.biweekly.bw97_202302;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-02-04
 */
public class Q2555_M_MaximizeWinFromTwoSegments {
    public static void main(String[] args) {
        Q2555_M_MaximizeWinFromTwoSegments q2555MMaximizeWinFromTwoSegments = new Q2555_M_MaximizeWinFromTwoSegments();
        /*System.out.println(q3.maximizeWin(new int[]{
                1, 1, 2, 2, 3, 3, 5
        }, 2));*/

        System.out.println(q2555MMaximizeWinFromTwoSegments.maximizeWin(new int[]{
                3937, 3938, 3939, 3951, 3951, 3959, 3975, 3988, 3993, 4010, 4031, 4033, 4036, 4038, 4039, 4041, 4047, 4058, 4059, 4064, 4072, 4081, 4084, 4084, 4089, 4094, 4098, 4112, 4114, 4116, 4123, 4123, 4127, 4130, 4135, 4143, 4149, 4152, 4163, 4164, 4176, 4178, 4180, 4198, 4216, 4224, 4233, 4240, 4253, 4259, 4273, 4286, 4305, 4322, 4335, 4350, 4364, 4378, 4396, 4397, 4398, 4404, 4415, 4421, 4430, 4469, 4476, 4490, 4492, 4497, 4504, 4519, 4519, 4525, 4526, 4530, 4530, 4540, 4550, 4554, 4563, 4571, 4571, 4595, 4595, 4606, 4639, 4639, 4660, 4663, 4676, 4678, 4680, 4695, 4697, 4709, 4709, 4711, 4724, 4751, 4781, 4786, 4786, 4794, 4797, 4801, 4807, 4808, 4817, 4822, 4824, 4825, 4840, 4851, 4887, 4889, 4891, 4910, 4917, 4927, 4931, 4932, 4951, 4959, 4964, 4993, 4997, 5003, 5003, 5006, 5006, 5022, 5029, 5035, 5043, 5045, 5045, 5046, 5059, 5060, 5079, 5084, 5105, 5109, 5109, 5112, 5120, 5126, 5130, 5142, 5143, 5151, 5152, 5154, 5156, 5168, 5189, 5213, 5214, 5223, 5226, 5235, 5247, 5259, 5272, 5289, 5303, 5309, 5317, 5322, 5344, 5347, 5352, 5374, 5379, 5380, 5383, 5385, 5391, 5418, 5425, 5429, 5432, 5479, 5486, 5490, 5502, 5502, 5505, 5506, 5509, 5515, 5518, 5519, 5521, 5526, 5528, 5533, 5536, 5536, 5538, 5555, 5556, 5557, 5557, 5566, 5571, 5580, 5585, 5596, 5604, 5619, 5634, 5649, 5668, 5694, 5696, 5699, 5701, 5704, 5709, 5732, 5745, 5745, 5746, 5749, 5762, 5766, 5766, 5770, 5773, 5796, 5810, 5817, 5823, 5838, 5843, 5846, 5860, 5869, 5872, 5877, 5880, 5896, 5899, 5902, 5905, 5910, 5913, 5913, 5915, 5923
        }, 220));
    }

    public int maximizeWin(int[] prizePositions, int k) {
        if (prizePositions.length == 1) return prizePositions[0];

        int[] src = new int[prizePositions[prizePositions.length - 1] + 1];
        int cnt = 0, starting = prizePositions[0], ending = prizePositions[prizePositions.length - 1];
        for (int i = 0; i < prizePositions.length; i++) {
            src[prizePositions[i]]++;
        }
        long w = 0, wc = 0;
        int i;
        for (i = starting; i <= ending; i++) { //fill up the window
            if (wc <= k) {
                w += src[i];
                wc++;
            } else break;
        }
        if (wc <= k) return (int) w; //in case the window size is larger than the elements present
        List<Node> nodes = new ArrayList<>();
        nodes.add(generateNode(starting, i - 1, w));

        for (i = starting + 1; i <= ending - k; i++) { //window has been filled
            w += src[i + k];
            w -= src[i - 1];
            nodes.add(generateNode(i, i + k, w));
        }

        nodes.sort(Comparator.comparingLong(Node::getCount).reversed());
        cnt += nodes.get(0).getCount();

        if (nodes.size() > 1) {
            Node root = nodes.get(0);
            for (i = 1; i < nodes.size(); i++) {
                Node node = nodes.get(i);
                if (node.getI() < root.getI() && node.getJ() >= root.getI()) {
                    long sum = 0;
                    for (int j = root.getI(); j <= node.getJ(); j++) sum += src[j];
                    sum = Math.max(0, node.getCount() - sum);
                    node.setCount(sum);
                } else if (node.getI() <= root.getJ() && node.getJ() > root.getJ()) {
                    long sum = 0;
                    for (int j = node.getI(); j <= root.getJ(); j++) sum += src[j];
                    sum = Math.max(0, node.getCount() - sum);
                    node.setCount(sum);
                }
            }
            nodes.remove(0);
            nodes.sort(Comparator.comparingLong(Node::getCount).reversed());
            cnt += nodes.get(0).getCount();
        }
        return cnt;
    }

    private Node generateNode(int starting, int end, long count) {
        return new Node(starting, end, count);
    }

    private class Node {
        private final int i;
        private final int j;
        private long count;

        public Node(int i, int j, long count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }

        @Override
        public String toString() {
            String sb = "Node{" + "i=" + i +
                    ", j=" + j +
                    ", count=" + count +
                    '}';
            return sb;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }
}
