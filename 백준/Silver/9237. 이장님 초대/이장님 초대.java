import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] grow = new Integer[N];

        int day = 1;
        int visit = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            grow[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(grow, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            visit = Math.max(visit, grow[i] + i);
        }
        System.out.println(visit + 2);
    }
}