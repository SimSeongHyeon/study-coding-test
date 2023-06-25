import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (w1, w2) -> {
            if (w1.length() == w2.length()) {
                return w1.compareTo(w2);
            }
            else return w1.length() - w2.length();
        });


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N - 1; i++) {
            if (!words[i].equals(words[i + 1])) {
                sb.append(words[i]).append("\n");
            }
        }

        sb.append(words[N - 1]);

        System.out.println(sb);
    }
}