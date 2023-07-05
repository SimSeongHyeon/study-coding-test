import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] grow = new int[N];

        int day = 1;
        int visit = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grow);

        for (int i = N - 1; i >= 0; i--) {
            grow[i] = grow[i] + day + 1;
            visit = Math.max(visit, grow[i]);
            day++;
        }
        System.out.println(visit);
    }
}