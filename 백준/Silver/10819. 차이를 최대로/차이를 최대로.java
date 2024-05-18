import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int max = Integer.MIN_VALUE;
    static int[] array;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        visited = new boolean[N];
        selected = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int count) {
        if (count == N) {
            max = Math.max(getSum(selected), max);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected[count] = array[i];
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    static int getSum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length - 1; i++) {
            sum += Math.abs(array[i] - array[i + 1]);
        }

        return sum;
    }
}
