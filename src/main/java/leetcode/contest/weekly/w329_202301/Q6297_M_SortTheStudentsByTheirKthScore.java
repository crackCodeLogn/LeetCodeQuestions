package leetcode.contest.weekly.w329_202301;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2023-01-21
 */
public class Q6297_M_SortTheStudentsByTheirKthScore {
    private static int K;

    public static void main(String[] args) {
        Q6297_M_SortTheStudentsByTheirKthScore q6297MSortTheStudentsByTheirKthScore = new Q6297_M_SortTheStudentsByTheirKthScore();
        System.out.println(q6297MSortTheStudentsByTheirKthScore.sortTheStudents(new int[][]{
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}
        }, 2));
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        K = k;
        int m = score.length, n = score[0].length;
        List<Student> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            Student student = new Student();
            for (int j = 0; j < n; j++) student.addScore(score[i][j]);
            list.add(student);
        }
        Collections.sort(list);
        for (int i = 0; i < m; i++) {
            Student student = list.get(i);
            for (int j = 0; j < n; j++) score[i][j] = student.getExamScores().get(j);
        }
        return score;
    }

    private class Student implements Comparable<Student> {

        private final List<Integer> examScores = new ArrayList<>();

        public void addScore(int score) {
            examScores.add(score);
        }

        /*@Override
        public String toString() {
            return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                    .add("examScores=" + examScores)
                    .toString();
        }*/

        public List<Integer> getExamScores() {
            return examScores;
        }

        @Override
        public int compareTo(Student o) {
            return -examScores.get(K) + o.getExamScores().get(K);
        }
    }
}
