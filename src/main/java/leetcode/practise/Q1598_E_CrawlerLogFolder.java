package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-10
 */
public class Q1598_E_CrawlerLogFolder {

    public static void main(String[] args) {
        Q1598_E_CrawlerLogFolder q1598ECrawlerLogFolder = new Q1598_E_CrawlerLogFolder();
        System.out.println(q1598ECrawlerLogFolder.minOperations(new String[]{
                "./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"
        }));
    }

    public int minOperations(String[] logs) {
        int steps = 0;
        for (String log : logs) {
            if (log.charAt(0) == '.') {
                if (log.charAt(1) == '.') steps = Math.max(steps - 1, 0);
            } else steps++;
        }
        return Math.max(0, steps);
    }
}
