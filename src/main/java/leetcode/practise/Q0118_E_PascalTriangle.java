package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-03-14
 */
public class Q0118_E_PascalTriangle {

    public static void main(String[] args) {
        Q0118_E_PascalTriangle q0118EPascalTriangle = new Q0118_E_PascalTriangle();
        System.out.println(q0118EPascalTriangle.generate(1));
        System.out.println(q0118EPascalTriangle.generate(2));
        System.out.println(q0118EPascalTriangle.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>(numRows);
        List<Integer> internal = new ArrayList<>();
        internal.add(1);
        data.add(internal);
        if (numRows == 1) {
            return data;
        }
        internal = new ArrayList<>();
        internal.add(1);
        internal.add(1);
        data.add(internal);
        if (numRows == 2) {
            return data;
        }

        for (int i = 2; i < numRows; i++) {
            internal = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) internal.add(1);
                else {
                    internal.add(data.get(i - 1).get(j - 1) + data.get(i - 1).get(j));
                }
            }
            data.add(internal);
        }
        return data;
    }
}
