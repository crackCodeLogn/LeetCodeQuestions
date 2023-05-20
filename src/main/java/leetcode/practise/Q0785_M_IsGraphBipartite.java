package leetcode.practise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2023-05-20
 */
public class Q0785_M_IsGraphBipartite {

    public static void main(String[] args) {
        Q0785_M_IsGraphBipartite q0785MIsGraphBipartite = new Q0785_M_IsGraphBipartite();
        System.out.println(q0785MIsGraphBipartite.isBipartite(new int[][]{
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        })); //true
        System.out.println(q0785MIsGraphBipartite.isBipartite(new int[][]{
                {1, 3, 2},
                {0, 2},
                {1, 3, 0},
                {0, 2}
        })); //false
        System.out.println(q0785MIsGraphBipartite.isBipartite(new int[][]{
                {4},
                {},
                {4},
                {4},
                {0, 2, 3}
        })); //true
        System.out.println(q0785MIsGraphBipartite.isBipartite(new int[][]{
                {},
                {2, 4, 6},
                {1, 4, 8, 9},
                {7, 8},
                {1, 2, 8, 9},
                {6, 9},
                {1, 5, 7, 8, 9},
                {3, 6, 9},
                {2, 3, 4, 6, 9},
                {2, 4, 5, 6, 7, 8}
        })); //false
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        char[] status = new char[n];
        Arrays.fill(status, '\0');
        Queue<Integer> nodes = new LinkedList<>();

        while (true) {
            int src = -1;
            for (int i = 0; i < n; i++)
                if (status[i] == '\0') {
                    src = i;
                    break;
                }
            if (src == -1) break;
            status[src] = 'A';
            nodes.add(src);
            while (!nodes.isEmpty()) {
                int i = nodes.poll();
                char ch = status[i];
                char ch1 = getFlip(ch);

                for (int j = 0; j < graph[i].length; j++) {
                    int connectedIndex = graph[i][j];
                    char stat = status[connectedIndex];
                    if (stat == ch) return false;
                    if (stat == '\0') {
                        status[connectedIndex] = ch1;
                        nodes.offer(connectedIndex);
                    }
                }
            }
        }
        return true;
    }

    private char getFlip(char ch) {
        return ch == 'A' ? 'B' : 'A';
    }
}
