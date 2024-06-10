package leetcode.contest.weekly.w401_202406;

/**
 * @author Vivek
 * @since 2024-06-09
 */
public class Q3178_E_FindTheChildWhoHasTheBallAfterKSeconds {

    public static void main(String[] args) {
        Q3178_E_FindTheChildWhoHasTheBallAfterKSeconds q3178EFindTheChildWhoHasTheBallAfterKSeconds = new Q3178_E_FindTheChildWhoHasTheBallAfterKSeconds();
        System.out.println(q3178EFindTheChildWhoHasTheBallAfterKSeconds.numberOfChild(3, 5));
        System.out.println(q3178EFindTheChildWhoHasTheBallAfterKSeconds.numberOfChild(5, 6));
        System.out.println(q3178EFindTheChildWhoHasTheBallAfterKSeconds.numberOfChild(4, 2));
    }

    public int numberOfChild(int n, int k) {
        boolean flag = true;
        int i = 0;
        while (k-- > 0) {
            if (i == n - 1 || (!flag && i == 0)) flag = !flag;
            i += flag ? 1 : -1;
        }
        return i;
    }
}
