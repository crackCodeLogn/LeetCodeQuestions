package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

public class Q0078_M_Subsets {

    public static void main(String[] args) {
        Q0078_M_Subsets q0078MSubsets = new Q0078_M_Subsets();
        System.out.println(q0078MSubsets.subsets(new int[]{1, 2, 3}));
        System.out.println(q0078MSubsets.subsets(new int[]{0}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int s, List<Integer> path, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(path));

        for (int i = s; i < nums.length; ++i) {
            path.add(nums[i]);
            dfs(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
