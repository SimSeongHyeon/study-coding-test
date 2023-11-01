import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] scr = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] nums = new int[5];

            for (int j = 0; j < 5; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            max = 0;

            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        int sum = nums[j] + nums[k] + nums[l];
                        max = Math.max(max, sum % 10);
                    }
                }
            }

            scr[i] = max;
        }

        int answer = 0;

        for (int i : scr) max = Math.max(max, i);

        for (int i = scr.length - 1; i >= 0; i--) {
            if (max == scr[i]) {
                answer = i + 1;
                break;
            }
        }
        System.out.println(answer);
    }
}