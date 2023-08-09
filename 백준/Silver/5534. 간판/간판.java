import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String name = br.readLine().trim();
        int n = name.length();
        String[] kanbans = new String[N];
        for (int i = 0; i < N; i++) {
            kanbans[i] = br.readLine().trim();
        }

        int cnt = 0;
        for (String kanban : kanbans) {
            cnt += check(kanban, name, n);
        }
        System.out.println(cnt);
    }

    public static int check(String string, String name, int n) {
        int l = string.length();
        for (int startIdx = 0; startIdx < l; startIdx++) {
            if (string.charAt(startIdx) == name.charAt(0)) {
                for (int endIdx = startIdx; endIdx < l; endIdx++) {
                    if (string.charAt(endIdx) == name.charAt(n - 1)) {
                        int avgGap = (endIdx - startIdx) / (n - 1);
                        int cnt = 0;
                        int currentIdx = startIdx;
                        while (cnt < n) {
                            if (string.charAt(currentIdx) == name.charAt(cnt)) {
                                cnt++;
                                currentIdx += avgGap;
                                continue;
                            }
                            break;
                        }
                        if (cnt == n) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
