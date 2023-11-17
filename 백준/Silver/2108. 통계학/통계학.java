import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        int avg = 0;
        int mode = 0;
        int rage = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        avg = (int)calAvg(nums);

        System.out.println(avg);

        Arrays.sort(nums);

        System.out.println(nums[N / 2]);

        mode = calMode(nums);

        System.out.println(mode);

        rage = nums[N - 1] - nums[0];

        System.out.println(rage);
    }

    public static double calAvg (int[] nums) {
        double sum = 0;

        for (int i : nums) {
            sum += i;
        }

        return Math.round(sum / nums.length);
    }

    public static int calMode (int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxFrq = Integer.MIN_VALUE;

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for (int i : map.values()) {
            maxFrq = Math.max(maxFrq, i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFrq) {
                set.add(entry.getKey());
            }
        }

        if (set.size() > 1) {
            set.remove(Collections.min(set));
        }

        return Collections.min(set);
    }
}