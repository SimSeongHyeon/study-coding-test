import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int X = Integer.parseInt(N);

        int cnt = 0;

        if (X < 100) {
            for (int i = 0; i < X; i++) cnt++;
        }

        else if (X < 1000) {
            cnt = 99;

            for (int i = 100; i <= X; i++) {
                String iStr = String.valueOf(i);

                int gap = (int) iStr.charAt(1) - (int) iStr.charAt(0);

                if (iStr.charAt(1) + gap == iStr.charAt(2)) cnt++;
            }
        }

        else cnt = 144;

        System.out.println(cnt);
    }
}