import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int year = 1;

        int e = 1;
        int s = 1;
        int m = 1;

        while (e != E || s != S || m != M) {
            e++;
            s++;
            m++;
            year++;
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
        }

        System.out.println(year);
    }
}