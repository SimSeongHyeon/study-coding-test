import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int computer, edge, count;
    static int[][] network;
    static boolean[] visited;

    static void dfs (int x) {
        visited[x] = true;

        count++;

        for (int i = 1; i <= computer; i++) {
            if (!visited[i] && network[x][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());

        edge = Integer.parseInt(br.readLine());

        StringTokenizer st;

        network = new int[computer + 1][computer + 1];
        visited = new boolean[computer + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            network[x][y] = network[y][x] = 1;
        }

        count = 0;

        dfs(1);

        System.out.println(count - 1);
    }
}