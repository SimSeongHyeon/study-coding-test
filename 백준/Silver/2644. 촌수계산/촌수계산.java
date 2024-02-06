import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, startPerson, endPerson;
    static int[][] family;
    static int[] distance;

    static void dfs(int start, int end) {
        if (start == end) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (family[start][i] == 1 && distance[i] == 0) {
                distance[i] = distance[start] + 1;

                dfs(i, end);
            }
        }
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == end) {
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (family[current][i] == 1 && distance[i] == 0) {
                    queue.add(i);

                    distance[i] = distance[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        startPerson = Integer.parseInt(st.nextToken());
        endPerson = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        family = new int[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            family[x][y] = family[y][x] = 1;
        }

        distance = new int[n + 1];

        dfs(startPerson, endPerson);

        System.out.println(distance[endPerson] == 0 ? -1 : distance[endPerson]);
    }
}