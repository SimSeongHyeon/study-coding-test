import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] board;
    static boolean[] visited;

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

        visited = new boolean[101];

        bfs();
    }

    static void bfs() {
        visited[1] = true;

        Queue<Status> queue = new LinkedList<>();

        queue.add(new Status(1, 0));

        while (!queue.isEmpty()) {
            Status current = queue.poll();

            if (current.currentNum == 100) {
                System.out.println(current.count);

                return;
            }

            for (int i = 0; i < 7; i++) {
                int next = current.currentNum + i;

                if (next > 100) {
                    break;
                }

                if (visited[next]) {
                    continue;
                }

                if (board[next] == 0) {
                    queue.add(new Status(next, current.count + 1));

                    visited[next] = true;
                } else {
                    if (!visited[board[next]]) {
                        queue.add(new Status(board[next], current.count + 1));

                        visited[board[next]] = true;
                    }
                }
            }
        }

    }

    static class Status {
        int currentNum;
        int count;

        public Status(int currentNum, int count) {
            this.currentNum = currentNum;
            this.count = count;
        }
    }
}