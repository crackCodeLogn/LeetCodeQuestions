package leetcode.contest.weekly.w341_202304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-04-16
 */
public class Q6378_H_MinimizeTheTotalPriceOfTrips {

    private int vali = 0;

    public static void main(String[] args) {
        Q6378_H_MinimizeTheTotalPriceOfTrips q6378HMinimizeTheTotalPriceOfTrips = new Q6378_H_MinimizeTheTotalPriceOfTrips();
        System.out.println(q6378HMinimizeTheTotalPriceOfTrips.minimumTotalPrice(4,
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {1, 3}
                }, new int[]{
                        2, 2, 10, 6
                }, new int[][]{
                        {0, 3},
                        {2, 1},
                        {2, 3},
                }));

        System.out.println(q6378HMinimizeTheTotalPriceOfTrips.minimumTotalPrice(2,
                new int[][]{
                        {0, 1}
                }, new int[]{
                        2, 2
                }, new int[][]{
                        {0, 0}
                }));
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        Node[] tree = new Node[n];
        for (int i = 0; i < n; i++) tree[i] = new Node(i, price[i]);

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            tree[src].addChild(tree[dest]);
            tree[dest].addChild(tree[src]);
        }


        Node targetNode = null;
        /*
        int maxInNodes = 0;
        for (int i = 0; i < n; i++)
            if (tree[i].children.size() > maxInNodes) {
                maxInNodes = tree[i].children.size();
                targetNode = tree[i];
            }*/
        int[] occurrences = computeHighTrafficRoutes(trips, tree);
        int cnt = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] > cnt) {
                targetNode = tree[i];
                cnt = occurrences[i];
            } else if (occurrences[i] == cnt) {
                if (tree[i].getPrice() >= targetNode.getPrice()) {
                    targetNode = tree[i];
                }
            }
        }

        boolean[] visited = new boolean[n];
        markNodes(targetNode, visited, true);

        int sum = 0;
        for (int[] trip : trips) {
            sum += computeTripCost(trip[0], trip[1], tree);
        }

        for (int i = 0; i < n; i++) System.out.println(tree[i]);
        return sum;
    }

    private int computeTripCost(int start, int end, Node[] tree) {
        Node src = tree[start], dest = tree[end];
        if (src == dest) return src.getPrice();

        boolean[] visited = new boolean[tree.length];
        vali = 0;
        travel(src, dest, visited, 0);
        return vali;
    }

    private void travel(Node src, Node dest, boolean[] visited, int sum) {
        sum += src.getPrice();
        if (src == dest) {
            vali = sum;
            return;
        }

        visited[src.getIndex()] = true;
        for (int i = 0; i < src.getChildren().size(); i++) {
            if (!visited[src.children.get(i).getIndex()])
                travel(src.children.get(i), dest, visited, sum);
        }
    }

    private void markNodes(Node targetNode, boolean[] visited, boolean isHalfPrice) {
        targetNode.setHalfPrice(isHalfPrice);
        visited[targetNode.getIndex()] = true;
        for (int i = 0; i < targetNode.getChildren().size(); i++) {
            if (!visited[targetNode.children.get(i).getIndex()])
                markNodes(targetNode.children.get(i), visited, !isHalfPrice);
        }
    }

    private int[] computeHighTrafficRoutes(int[][] trips, Node[] tree) {
        int[] occurrences = new int[tree.length];
        for (int[] trip : trips) {
            computeHighTrafficRoutes(trip[0], trip[1], tree)
                    .forEach(node -> occurrences[node.getIndex()]++);
        }
        return occurrences;
    }

    private List<Node> computeHighTrafficRoutes(int start, int end, Node[] tree) {
        Node src = tree[start], dest = tree[end];
        List<Node> route = new ArrayList<>();
        boolean[] visited = new boolean[tree.length];
        explore(src, dest, visited);
        for (int i = 0; i < visited.length; i++) if (visited[i]) route.add(tree[i]);
        return route;
    }

    private boolean explore(Node src, Node dest, boolean[] visited) {
        visited[src.getIndex()] = true;
        if (src == dest) return true;

        for (int i = 0; i < src.getChildren().size(); i++) {
            if (!visited[src.children.get(i).getIndex()])
                if (explore(src.children.get(i), dest, visited)) return true;
        }
        return false;
    }

    static class Node {
        private final int index;
        private final List<Node> children = new ArrayList<>();
        private int price;
        private boolean isHalfPrice = false;

        public Node(int index, int price) {
            this.index = index;
            this.price = price;
        }

        public int getIndex() {
            return index;
        }

        public int getPrice() {
            return isHalfPrice ? price / 2 : price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public List<Node> getChildren() {
            return children;
        }

        public boolean isHalfPrice() {
            return isHalfPrice;
        }

        public void setHalfPrice(boolean halfPrice) {
            isHalfPrice = halfPrice;
        }

        public void addChild(Node node) {
            children.add(node);
        }

        @Override
        public String toString() {
            String sb = "Node{" + "index=" + index +
                    ", price=" + price +
                    ", isHalfPrice=" + isHalfPrice +
                    ", children=" + children.size() +
                    '}';
            return sb;
        }
    }
}