import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] sortedNums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = sortedNums[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sortedNums);

        HashMap<Integer, Integer> rankingMap = new HashMap<>();

        int rank = 0;

        for (int i : sortedNums) {
            if (!rankingMap.containsKey(i)) {
                rankingMap.put(i, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : nums) {
            sb.append(rankingMap.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}