import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> scoresMap = new HashMap();

        int[] scoresArray = new int[8];

        int sum = 0;

        for (int i = 0; i < 8; i++) {
            int score = Integer.parseInt(br.readLine());

            scoresMap.put(i, score);

            scoresArray[i] = score;
        }

        Arrays.sort(scoresArray);

        StringBuilder sb = new StringBuilder();

        for (int i = 7; i >= 3; i--) {
            int score = scoresArray[i];

            sum += score;
        }

        for (int num : scoresMap.keySet()) {
            for (int i = 7; i >= 3; i--) {
                if (scoresMap.get(num) == scoresArray[i]) {
                    sb.append(num + 1).append(" ");
                }
            }
        }

        System.out.println(sum);
        System.out.println(sb);
    }
}