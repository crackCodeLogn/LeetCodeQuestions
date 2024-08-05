package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-05
 */
public class Q1395_M_CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int ans = 0;

        for (int i = 1; i < rating.length - 1; ++i) {
            // Calculate soldiers on the left with less/greater ratings.
            int leftLess = 0;
            int leftGreater = 0;
            for (int j = 0; j < i; ++j)
                if (rating[j] < rating[i])
                    ++leftLess;
                else if (rating[j] > rating[i])
                    ++leftGreater;
            // Calculate soldiers on the right with less/greater ratings.
            int rightLess = 0;
            int rightGreater = 0;
            for (int j = i + 1; j < rating.length; ++j)
                if (rating[j] < rating[i])
                    ++rightLess;
                else if (rating[j] > rating[i])
                    ++rightGreater;
            ans += leftLess * rightGreater + leftGreater * rightLess;
        }

        return ans;
    }
}