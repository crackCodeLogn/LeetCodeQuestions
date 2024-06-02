package leetcode.contest.weekly.w400_202406;

/**
 * @author Vivek
 * @since 2024-06-02
 */
public class Q3168_E_MinimumNumberOfChairsInAWaitingRoom {

    public static void main(String[] args) {
        Q3168_E_MinimumNumberOfChairsInAWaitingRoom q3168EMinimumNumberOfChairsInAWaitingRoom = new Q3168_E_MinimumNumberOfChairsInAWaitingRoom();
        System.out.println(q3168EMinimumNumberOfChairsInAWaitingRoom.minimumChairs("EEEEEEE")); // 7
        System.out.println(q3168EMinimumNumberOfChairsInAWaitingRoom.minimumChairs("ELELEEL")); // 2
        System.out.println(q3168EMinimumNumberOfChairsInAWaitingRoom.minimumChairs("ELEELEELLL")); // 3
        System.out.println(q3168EMinimumNumberOfChairsInAWaitingRoom.minimumChairs("EEEEEELELLLE")); // 6
    }

    public int minimumChairs(String s) {
        int chairs = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'E') {
                chairs++;
                max = Math.max(max, chairs);
            } else chairs--;
        }
        return max;
    }
}
