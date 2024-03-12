import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int A, B, N, M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Status> queue = new LinkedList<>();

        queue.add(new Status(N, 0));

        while (!queue.isEmpty()) {
            Status current = queue.poll();

            if (current.x == M) {
                return current.count;
            }

            int moveLeft = current.x - 1;
            int moveRight = current.x + 1;
            int jumpALeft = current.x - A;
            int jumpARight = current.x + A;
            int jumpBLeft = current.x - B;
            int jumpBRight = current.x + B;
            int mulA = current.x * A;
            int mulB = current.x * B;

            if (isValidRange(moveLeft)) {
                queue.add(new Status(moveLeft, current.count + 1));

                visited[moveLeft] = true;
            }

            if (isValidRange(moveRight)) {
                queue.add(new Status(moveRight, current.count + 1));

                visited[moveRight] = true;
            }

            if (isValidRange(jumpALeft)) {
                queue.add(new Status(jumpALeft, current.count + 1));

                visited[jumpALeft] = true;
            }

            if (isValidRange(jumpARight)) {
                queue.add(new Status(jumpARight, current.count + 1));

                visited[jumpARight] = true;
            }

            if (isValidRange(jumpBLeft)) {
                queue.add(new Status(jumpBLeft, current.count + 1));

                visited[jumpBLeft] = true;
            }

            if (isValidRange(jumpBRight)) {
                queue.add(new Status(jumpBRight, current.count + 1));

                visited[jumpBRight] = true;
            }

            if (isValidRange(mulA)) {
                queue.add(new Status(mulA, current.count + 1));

                visited[mulA] = true;
            }

            if (isValidRange(mulB)) {
                queue.add(new Status(mulB, current.count + 1));

                visited[mulB] = true;
            }

        }

        return -1;
    }

    static boolean isValidRange (int n) {
        return n >= 0 && n <= 100000 && !visited[n];
    }

    static class Status {
        int x;
        int count;

        public Status(int x, int count) {
            this.x = x;
            this.count = count;
        }
    }
}