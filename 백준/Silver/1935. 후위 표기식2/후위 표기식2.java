import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Double> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                stack.push((double) num[(str.charAt(i) - 'A')]);
            }

            else {
                double temp1 = stack.pop();
                double temp2 = stack.pop();

                switch (str.charAt(i)) {
                    case '+' :
                        stack.push(temp2 + temp1);
                        break;

                    case '-' :
                        stack.push(temp2 - temp1);
                        break;

                    case '*' :
                        stack.push(temp2 * temp1);
                        break;

                    case '/' :
                        stack.push(temp2 / temp1);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.peek());
    }
}