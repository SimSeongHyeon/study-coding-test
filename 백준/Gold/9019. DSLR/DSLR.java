import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];

            bfs(A, B);
        }

        System.out.println(sb);

    }

    static void bfs(int calculateNumber, int targetNumber) {
        Queue<Calculator> queue = new LinkedList<>();

        queue.add(new Calculator(calculateNumber, ""));

        while (!queue.isEmpty()) {
            Calculator calculator = queue.poll();

            if (calculator.num == targetNumber) {
                sb.append(calculator.operand).append("\n");

                return;
            }

            if (visited[calculator.num]) {
                continue;
            }

            queue.add(new Calculator(D(calculator.num), calculator.operand + "D"));

            queue.add(new Calculator(S(calculator.num), calculator.operand + "S"));

            queue.add(new Calculator(L(calculator.num), calculator.operand + "L"));

            queue.add(new Calculator(R(calculator.num), calculator.operand + "R"));

            visited[calculator.num] = true;
        }
    }

    static int D(int n) {
        return n * 2 > 9999 ? n * 2 % 10000 : n * 2;
    }

    static int S(int n) {
        return  n == 0 ? 9999 : n - 1;
    }

    static int L(int n) {
        return n % 1000 * 10 + n / 1000;
    }

    static int R(int n) {
        return n % 10 * 1000 + n / 10;
    }

    static class Calculator {
        int num;
        String operand;

        public Calculator(int num, String operand) {
            this.num = num;
            this.operand = operand;
        }
    }

}