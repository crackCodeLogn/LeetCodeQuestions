package leetcode.practise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vivek
 * @since 2024-04-08
 */
public class Q1700_E_NumberOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sandwiches) {
        int top = 0, n = students.length, eat = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int pref : students) queue.offer(pref);

        int cycle = 0;
        while (top < n && !queue.isEmpty()) {
            int pref = queue.poll();
            if (pref == sandwiches[top]) {
                top++;
                cycle = 0;
            } else {
                cycle++;
                queue.offer(pref);
            }
            if (cycle == n) return queue.size();
        }
        return queue.size();
    }
}
