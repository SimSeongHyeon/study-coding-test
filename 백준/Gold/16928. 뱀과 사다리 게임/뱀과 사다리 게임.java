import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] board, count;
    static boolean[] visited;

    static void bfs() {
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == 100) {
                System.out.println(count[current]);

                return;
            }

            for (int i = 1; i < 7; i++) {
                int next = current + i;

                if (next <= 100 && !visited[next]) {
                    if (board[next] != 0 && !visited[board[next]]) {
                        count[board[next]] = count[current] + 1;

                        queue.add(board[next]);

                        visited[board[next]] = true;

                    } else if (!visited[board[next]]){
                        count[next] = count[current] + 1;

                        queue.add(next);

                    }

                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        count = new int[101];
        visited = new boolean[101];

        bfs();

    }
}