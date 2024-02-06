import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F, S, G, U, D;
    static boolean[] visited;
    static int[] count;

    static void bfs(int S) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(S);

        visited[S] = true;

        count[S] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == G) {
                System.out.println(count[current]);

                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = 0;

                if (i == 0) {
                    next = current + U;
                } else {
                    next = current - D;
                }

                if (next >= 1 && next <= F && !visited[next]) {
                    visited[next] = true;

                    queue.add(next);

                    count[next] = count[current] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        count = new int[F + 1];

        bfs(S);
    }
}