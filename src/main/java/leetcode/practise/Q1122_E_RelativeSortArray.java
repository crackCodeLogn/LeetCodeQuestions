package leetcode.practise;

import java.util.*;

public class Q1122_E_RelativeSortArray {

    private Map<Integer, Integer> order;

    public static void main(String[] args) {
        Q1122_E_RelativeSortArray q1122ERelativeSortArray = new Q1122_E_RelativeSortArray();
        System.out.println(Arrays.toString(q1122ERelativeSortArray.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
        System.out.println(Arrays.toString(q1122ERelativeSortArray.relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        order = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) order.put(arr2[i], i);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(arr1).forEach(e -> {
            if (order.containsKey(e)) list1.add(e);
            else list2.add(e);
        });

        list1.sort(Comparator.comparingInt(this::getOrder));
        Collections.sort(list2);
        list1.addAll(list2);
        for (int i = 0; i < arr1.length; i++) arr1[i] = list1.get(i);
        return arr1;
    }

    private int getOrder(int key) {
        return order.getOrDefault(key, -1);
    }
}
