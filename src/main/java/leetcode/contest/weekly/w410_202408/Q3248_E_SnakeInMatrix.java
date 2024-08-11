package leetcode.contest.weekly.w410_202408;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author Vivek
 * @since 2024-08-11
 */
public class Q3248_E_SnakeInMatrix {

    public static void main(String[] args) {
        Q3248_E_SnakeInMatrix q3248ESnakeInMatrix = new Q3248_E_SnakeInMatrix();
        System.out.println(q3248ESnakeInMatrix.finalPositionOfSnake(2, Lists.newArrayList("RIGHT", "DOWN")));
        System.out.println(q3248ESnakeInMatrix.finalPositionOfSnake(3, Lists.newArrayList("DOWN", "RIGHT", "UP")));
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0, y = 0;
        for (String cmd : commands)
            switch (cmd) {
                case "UP" -> x--;
                case "DOWN" -> x++;
                case "LEFT" -> y--;
                default -> y++;
            }
        return (x * n) + y;
    }
}
