import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int answer = 0;

        if (N == 1) {
            System.out.println(answer);
            return;
        }
        else if ((x == 1 && y == 1) || (x == 1 && y == N) || (x == N && y == 1) || (x == N && y == N)) answer = 2;
        else if (x == 1 || y == 1 || x == N || y == N) answer = 3;
        else answer = 4;

        System.out.println(answer);
    }
}