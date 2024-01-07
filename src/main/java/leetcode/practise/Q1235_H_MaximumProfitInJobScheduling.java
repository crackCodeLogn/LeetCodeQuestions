package leetcode.practise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-01-07
 */
public class Q1235_H_MaximumProfitInJobScheduling {

    private final static List<Job> jobList = new ArrayList<>();
    private int[] data;

    public static void main(String[] args) {
        Q1235_H_MaximumProfitInJobScheduling q1235HMaximumProfitInJobScheduling = new Q1235_H_MaximumProfitInJobScheduling();
        System.out.println(q1235HMaximumProfitInJobScheduling.jobScheduling(
                new int[]{1, 2, 3, 3},
                new int[]{3, 4, 5, 6},
                new int[]{50, 10, 40, 70}
        )); // 120

        System.out.println(q1235HMaximumProfitInJobScheduling.jobScheduling(
                new int[]{1, 2, 3, 4, 6},
                new int[]{3, 5, 10, 6, 9},
                new int[]{20, 20, 100, 70, 60}
        )); // 150

        System.out.println(q1235HMaximumProfitInJobScheduling.jobScheduling(
                new int[]{1, 1, 1},
                new int[]{2, 3, 4},
                new int[]{5, 6, 4}
        )); // 6
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        data = new int[n + 1];
        jobList.clear();

        for (int i = 0; i < n; i++) jobList.add(generateJob(startTime[i], endTime[i], profit[i]));
        jobList.sort(Comparator.comparingInt(Job::getStartTime));
        System.out.println(jobList);

        int[] startTimeTracer = new int[n];
        for (int i = 0; i < n; i++) startTimeTracer[i] = jobList.get(i).getStartTime();
        return compute(startTimeTracer, 0);
    }

    private int compute(int[] startTimeTracer, int head) {
        if (head == startTimeTracer.length) return 0;
        if (data[head] > 0) return data[head];

        int firstJobGreaterEqualIndex = getFirstJobGreaterEqual(startTimeTracer, head + 1, jobList.get(head).getEndTime());
        data[head] = Math.max(compute(startTimeTracer, head + 1),
                jobList.get(head).getGain() + compute(startTimeTracer, firstJobGreaterEqualIndex));
        return data[head];
    }

    private int getFirstJobGreaterEqual(int[] startTimeTracer, int headFrom, int target) {
        int lower = headFrom;
        int upper = data.length - 1;
        while (lower < upper) {
            int m = lower + (upper - lower) / 2;
            if (startTimeTracer[m] >= target) {
                upper = m;
            } else {
                lower = m + 1;
            }
        }
        return lower;
    }

    private Job generateJob(int startTime, int endTime, int gain) {
        return new Job(startTime, endTime, gain);
    }

    private static class Job {
        private final int startTime;
        private final int endTime;
        private final int gain;

        public Job(int startTime, int endTime, int gain) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.gain = gain;
        }

        @Override
        public String toString() {
            return String.format("%d:%d=%d", startTime, endTime, gain);
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public int getGain() {
            return gain;
        }
    }
}
