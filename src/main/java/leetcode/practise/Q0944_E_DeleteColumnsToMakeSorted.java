package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-01-03
 */
public class Q0944_E_DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        Q0944_E_DeleteColumnsToMakeSorted q0944EDeleteColumnsToMakeSorted = new Q0944_E_DeleteColumnsToMakeSorted();
        System.out.println(q0944EDeleteColumnsToMakeSorted.minDeletionSize(new String[]{
                "cba", "daf", "ghi"
        }));
        System.out.println(q0944EDeleteColumnsToMakeSorted.minDeletionSize(new String[]{
                "zyx", "wvu", "tsr"
        }));
    }

    public int minDeletionSize(String[] strs) {
        int cols = 0;
        for (int j = 0; j < strs[0].length(); j++) {
            char ch1 = strs[0].charAt(j);
            for (int i = 1; i < strs.length; i++) {
                char ch = strs[i].charAt(j);
                if (ch < ch1) {
                    cols++;
                    break;
                }
                ch1 = ch;
            }
        }
        return cols;
    }
}
