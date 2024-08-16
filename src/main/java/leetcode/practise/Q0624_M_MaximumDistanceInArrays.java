package leetcode.practise;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Vivek
 * @since 2024-08-16
 */
public class Q0624_M_MaximumDistanceInArrays {

    public static void main(String[] args) {
        Q0624_M_MaximumDistanceInArrays q0624MMaximumDistanceInArrays = new Q0624_M_MaximumDistanceInArrays();
        System.out.println(q0624MMaximumDistanceInArrays.maxDistance(Lists.newArrayList(
                Lists.newArrayList(1, 2, 3),
                Lists.newArrayList(4, 5),
                Lists.newArrayList(1, 2, 3)
        ))); // 4
        System.out.println(q0624MMaximumDistanceInArrays.maxDistance(Lists.newArrayList(
                Lists.newArrayList(1),
                Lists.newArrayList(1)
        ))); // 0
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int mn = 10000;
        int mx = -10000;

        for (List<Integer> A : arrays) {
            ans = Math.max(ans, Math.max(A.get(A.size() - 1) - mn, mx - A.get(0)));
            mn = Math.min(mn, A.get(0));
            mx = Math.max(mx, A.get(A.size() - 1));
        }

        return ans;
    }

    public int maxDistance2(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE;
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();

        for (int i = 0; i < arrays.size(); i++)
            for (int j = 0; j < arrays.get(i).size(); j++) {
                if (!treeMap.containsKey(arrays.get(i).get(j))) treeMap.put(arrays.get(i).get(j), new ArrayList<>());
                treeMap.get(arrays.get(i).get(j)).add(i);
            }
        int p1 = treeMap.firstKey(), p2 = treeMap.lastKey();
//        while (true) {
//            // if ()
//        }

        return max;
    }
}
