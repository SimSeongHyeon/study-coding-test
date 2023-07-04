import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;

        int cnt = 0;

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < left) {
                cnt += left - apple;
                right = right - left + apple;
                left = apple;
            }

            else if (apple > right) {
                cnt += apple - right;
                left = left + apple - right;
                right = apple;
            }
        }

        System.out.println(cnt);

    }
}