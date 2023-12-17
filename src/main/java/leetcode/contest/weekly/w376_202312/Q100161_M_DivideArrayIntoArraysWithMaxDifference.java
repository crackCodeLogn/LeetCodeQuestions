package leetcode.contest.weekly.w376_202312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2023-12-17
 */
public class Q100161_M_DivideArrayIntoArraysWithMaxDifference {

    List<Node> nodes = new ArrayList<>();
    private int k;

    public static void main(String[] args) {
        Q100161_M_DivideArrayIntoArraysWithMaxDifference q100161MDivideArrayIntoArraysWithMaxDifference = new Q100161_M_DivideArrayIntoArraysWithMaxDifference();
        int[][] data = q100161MDivideArrayIntoArraysWithMaxDifference.divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2);
        int[][] data2 = q100161MDivideArrayIntoArraysWithMaxDifference.divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3);
        int[][] data3 = q100161MDivideArrayIntoArraysWithMaxDifference.divideArray(new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11}, 14);
        int[][] data4 = q100161MDivideArrayIntoArraysWithMaxDifference.divideArray(new int[]{33, 26, 4, 18, 16, 24, 24, 15, 8, 18, 34, 20, 24, 16, 3}, 16);
        System.out.println();
    }

    public int[][] divideArray2(int[] nums, int k) {
        nodes.clear();
        this.k = k;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            placeInNode(n);
        }
        int[][] data = new int[nodes.size()][];
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getSize() < 3) {
                return new int[][]{};
            }
            data[i] = nodes.get(i).toArray();
        }
        return data;
    }

    private void placeInNode(int n) {
        int expected = -1, num = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).checkAdd(n) && nodes.get(i).getSize() < num) {
                expected = i;
                num = nodes.get(i).getSize();
            }
        }
        if (expected == -1)
            nodes.add(generateNewNode(n));
        else nodes.get(expected).add(n);
    }

    private Node generateNewNode(int v) {
        Node node = new Node();
        node.add(v);
        return node;
    }

    private void addEntry(List<List<Integer>> result, List<Integer> buffer) {
        result.add(buffer);
    }

    private int[] toArray(List<Integer> list) {
        int[] data = new int[list.size()];
        for (int i = 0; i < list.size(); i++) data[i] = list.get(i);
        return data;
    }

    public int[][] divideArray(int[] nums, int k) {
        this.k = k;

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        Arrays.sort(nums);
        int trail = nums[0];
        buffer.add(trail);
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] - trail > k || buffer.size() >= 3) {
                result.add(buffer);
                buffer = new ArrayList<>();
                trail = nums[i];
            }
            buffer.add(nums[i]);
        }
        result.add(buffer);


        int[][] data = new int[result.size()][];
        for (i = 0; i < result.size(); i++) {
            if (result.get(i).size() < 3) {
                return new int[][]{};
            }
            data[i] = toArray(result.get(i));
        }
        return data;
    }

    class Node {
        TreeSet<Integer> elements = new TreeSet<>();
        List<Integer> actual = new ArrayList<>();

        @Override
        public String toString() {
            return actual.toString();
        }

        public boolean add(int element) {
            if (checkAdd(element)) {
                elements.add(element);
                actual.add(element);
                return true;
            }
            return false;
        }

        public boolean checkAdd(int element) {
            return elements.isEmpty() || (getSize() <= 2 && compare(elements.first(), element) && compare(elements.last(), element));
        }

        public int getSize() {
            return actual.size();
        }

        private boolean compare(int v1, int v2) {
            return Math.abs(v1 - v2) <= k;
        }

        public boolean contains(int element) {
            return elements.contains(element);
        }

        private int[] toArray() {
            int[] data = new int[actual.size()];
            int i = 0;
            for (Integer v : actual) data[i++] = v;
            return data;
        }
    }
}
