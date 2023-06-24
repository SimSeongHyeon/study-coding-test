
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] coord = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            coord[i][0] = Integer.parseInt(st.nextToken());
            coord[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(coord, (e1, e2) -> {
            if (e1[0] == e2[0]) return e1[1] - e2[1];
            else return e1[0] - e2[0];
        });

        for (int i = 0; i < N; i++) {
            sb.append(coord[i][0]).append(" ").append(coord[i][1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}