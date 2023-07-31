import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 4;

        int[] match = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < match.length; i++) {
            for (int j = 0; j < match.length; j++) {
                for (int k = 0; k < match.length; k++) {
                    for (int l = 0; l < match.length; l++) {
                        for (int m = 0; m < match.length; m++) {
                            for (int n = 0; n < match.length; n++) {
                                if (N == match[i] + match[j] + match[k] + match[l] + match[m] + match[n]) {
                                    if (10 * i + j + 10 * k + l == 10 * m + n) {
                                        sb.append(i).append(j).append("+").append(k).append(l).append("=").append(m).append(n);
                                        System.out.println(sb);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("impossible");
    }
}