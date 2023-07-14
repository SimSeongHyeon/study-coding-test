import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int range = 0;
        int sum = 0;

        for (int i =  1; i <= B; i++) {
            for (int j = 1; j <= i; j++) {
                range++;
                if (range >= A && range <= B) {
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }
}