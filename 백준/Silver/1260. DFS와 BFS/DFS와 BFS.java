import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static int[][] edge;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    static void dfs (int startVertex) {
        visited[startVertex] = true;

        sb.append(startVertex).append(" ");

        for (int i = 1; i <= N; i++) {
            if (edge[startVertex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs (int startVertex) {
        visited[startVertex] = true;

        queue.add(startVertex);

        while(!queue.isEmpty()) {
            startVertex = queue.poll();

            sb.append(startVertex).append(" ");

            for (int i = 1; i <= N; i++) {
                if (edge[startVertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        edge = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            edge[x][y] = edge[y][x] = 1;
        }

        visited = new boolean[N + 1];

        dfs(V);

        visited = new boolean[N + 1];

        sb.append("\n");

        bfs(V);

        System.out.println(sb);
    }
}