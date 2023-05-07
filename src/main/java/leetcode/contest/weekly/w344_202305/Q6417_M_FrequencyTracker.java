package leetcode.contest.weekly.w344_202305;

/**
 * @author Vivek
 * @since 2023-05-07
 */
public class Q6417_M_FrequencyTracker {

    int[] data = new int[100001];
    int[] lookup = new int[100001];

    public void add(int number) {
        if (lookup[data[number]] >= 1) lookup[data[number]]--;
        data[number]++;
        lookup[data[number]]++;
    }

    public void deleteOne(int number) {
        if (data[number] >= 1) {
            lookup[data[number]]--;
            data[number]--;
            lookup[data[number]]++;
        }
    }

    public boolean hasFrequency(int frequency) {
        return lookup[frequency] > 0;
    }
}
