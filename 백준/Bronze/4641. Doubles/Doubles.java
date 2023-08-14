import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            boolean[] exist = new boolean[100];

            String[] str = br.readLine().split(" ");
            if (str.length < 2) break;

            for (String s : str) {
                exist[Integer.parseInt(s)] = true;
            }

            int cnt = 0;

            for (int i = 1; i < 50; i++) {
                if (exist[i] && exist[i * 2]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}