import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        if (num.length() > 1) {
            for (int i = num.length() - 1; i >= 0; i--) {
                String a = num.substring(i);
                String b = num.substring(0, i);

                int n = 1;

                for (int j = 0; j < a.length(); j++) {
                    n *= a.charAt(j) - '0';
                }

                int m = 1;

                for (int k = 0; k < b.length(); k++) {
                    m *= b.charAt(k) - '0';
                }

                if (n == m) {
                    System.out.println("YES");
                    return;
                }
            }
            System.out.println("NO");
        }

        else System.out.println("NO");
    }
}