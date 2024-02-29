import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            long N = Long.parseLong(br.readLine());

            String[] mbti = new String[(int) N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            int min = 12;

            if (N > 32) {
                min = 0;

                sb.append(min).append("\n");

                continue;
            }

            getMin : for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    for (int k = j + 1; k < N; k++) {
                        min = Math.min(min, getDistance(mbti[i], mbti[j], mbti[k]));

                        if (min == 0) {
                            break getMin;
                        }
                    }
                }
            }
            sb.append(min).append("\n");
        }

        System.out.print(sb);

    }

    static int getDistance(String str1, String str2, String str3) {
        int distance = 0;

        for (int i = 0; i < 4; i++) {

            if (str1.charAt(i) != str2.charAt(i)) {
                distance++;
            }

            if (str2.charAt(i) != str3.charAt(i)) {
                distance++;
            }

            if (str3.charAt(i) != str1.charAt(i)) {
                distance++;
            }

        }
        return distance;
    }

}