import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] seconds;

    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        seconds[N] = 1;

        while (!queue.isEmpty()) {
            int nowLocation = queue.poll();

            int forwardLocation = nowLocation + 1;
            int backwardLocation = nowLocation - 1;
            int jumpLocation = nowLocation * 2;

            if (nowLocation == K) {
                return;
            }

            if (forwardLocation <= 100000 && seconds[forwardLocation] == 0) {
                seconds[forwardLocation] = seconds[nowLocation] + 1;

                queue.add(forwardLocation);
            }

            if (backwardLocation >= 0 && seconds[backwardLocation] == 0) {
                seconds[backwardLocation] = seconds[nowLocation] + 1;

                queue.add(backwardLocation);
            }

            if (jumpLocation <= 100000 && seconds[jumpLocation] == 0) {
                seconds[jumpLocation] = seconds[nowLocation] + 1;

                queue.add(jumpLocation);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        seconds = new int[100001];

        bfs(N, K);

        System.out.println(seconds[K] - 1);
    }
}