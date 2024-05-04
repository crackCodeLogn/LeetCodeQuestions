package leetcode.practise;

import java.util.Arrays;

public class Q0881_M_BoatsToSavePeople {

    public static void main(String[] args) {
        Q0881_M_BoatsToSavePeople q0881MBoatsToSavePeople = new Q0881_M_BoatsToSavePeople();
        System.out.println(q0881MBoatsToSavePeople.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(q0881MBoatsToSavePeople.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(q0881MBoatsToSavePeople.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
    }

    public int numRescueBoats(int[] people, int limit) { // 17ms
        Arrays.sort(people);

        int p1 = 0, p2 = people.length - 1, boats = 0;
        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) {
                p1++;
                p2--;
            } else if (people[p2] <= limit) p2--;
            else p1++;
            boats++;
        }
        return boats;
    }
}
