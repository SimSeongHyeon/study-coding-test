import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        int N = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] tShirts = new int[6];

        for (int i = 0; i < 6; i++) {
            tShirts[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int T = Integer.parseInt(stringTokenizer.nextToken());
        int P = Integer.parseInt(stringTokenizer.nextToken());

        int tCount = 0;
        
        tCount = distribute(tShirts, T, tCount);
        
        System.out.println(tCount);
        System.out.println(N / P + " " + N % P);
    }

    static int distribute(int[] tShirts, int T, int tCount) {
        for(int t : tShirts) {
            if (t <= 0) {
                continue;
            }

            if (t % T == 0) {
                tCount += t / T;
            } else {
                tCount += t / T + 1;
            }
        }

        return tCount;
    }
}