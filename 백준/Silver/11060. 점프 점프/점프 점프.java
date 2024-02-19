import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] maze;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        maze = new int[N];

        for (int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N];

        System.out.println(bfs(0));
    }

    static int bfs(int x) {
        Queue<Location> queue = new LinkedList<>();

        queue.add(new Location(x, 0));

        visited[x] = true;

        while (!queue.isEmpty()) {
            Location current = queue.poll();

            if (current.x == maze.length - 1) {
                return current.jump;
            }

            for (int i = 1; i <= maze[current.x]; i++) {
                int nx = current.x + i;

                if (nx >= maze.length) {
                    continue;
                }

                if (visited[nx]) {
                    continue;
                }

                queue.add(new Location(nx, current.jump + 1));

                visited[nx] = true;
            }
        }

        return -1;
    }

    static class Location {
        int x;
        int jump;

        public Location(int x, int jump) {
            this.x = x;
            this.jump = jump;
        }
    }
}