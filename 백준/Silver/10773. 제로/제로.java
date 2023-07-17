import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 스택 클래스 사용

        Stack<Integer> stack = new Stack<>();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                stack.pop();
            }
            else stack.push(n);
        }

        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        System.out.println(sum);

        br.close();

        */

        int K = Integer.parseInt(br.readLine());

        int index = 0;

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                index--;
            }

            else {
                arr[index] = n;
                index++;
            }
        }

        int sum = 0;

        for (int i = 0; i < index; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}