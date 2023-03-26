package leetcode.contest.weekly.w338_202303;

import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2023-03-26
 */
public class Q6355_M_PrimeSubtractionOperation {

    private static final TreeSet<Integer> primes = new TreeSet<>();

    public static void main(String[] args) {
        Q6355_M_PrimeSubtractionOperation q6355MPrimeSubtractionOperation = new Q6355_M_PrimeSubtractionOperation();
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                2, 2
        }));
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                3, 4, 10, 15, 6
        }));
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                2, 318, 42
        }));
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                5, 8, 3
        }));
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                6, 8, 11, 12
        }));
        System.out.println(q6355MPrimeSubtractionOperation.primeSubOperation(new int[]{
                4, 9, 6, 10
        }));
    }

    private boolean isPrime(int num) {
        if (num <= 2) return true;
        if ((num & 1) == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2)
            if (num % i == 0) return false;
        return true;
    }

    private void populatePrimes() {
        primes.add(2);
        for (int i = 3; i <= 1000; i++) if (isPrime(i)) primes.add(i);
    }

    public boolean primeSubOperation(int[] nums) {
        if (nums.length == 1) return true;
        boolean flag = true;
        populatePrimes();

        for (int i = 1; i < nums.length; i++)
            if (nums[i] <= nums[i - 1]) {
                flag = false;
                break;
            }
        if (flag) return true;
        int ref = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int target = nums[i];
            if (ref == 1 || (target == 2 && i > 0)) return false;
            if (target < ref) {
                ref = nums[i];
                continue;
            }
            if (primes.contains(target)) {
                if (primes.contains(target - 1)) { //indicates target was 3
                    nums[i] = 1;
                    ref = 1;
                    continue;
                }
                target--;
            }
            Integer floor = primes.floor(target);
            if (floor == null) return false;
            if (nums[i] - floor >= ref) return false;
            Integer ceil = primes.ceiling(nums[i] - ref);
            if (primes.contains(nums[i] - ref)) ceil = primes.ceiling(nums[i] - ref + 1);
            if (ceil == null) return false;
            if (nums[i] - ceil < 0) return false;

            nums[i] -= ceil;
            ref = nums[i];
        }
        return true;
    }
}
