import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while (true) {
            str = br.readLine();

            Stack<Character> stack = new Stack<>();

            if (str.equals(".")) break;

            else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                        stack.push(str.charAt(i));
                    }

                    else if (str.charAt(i) == ')') {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            System.out.println("no");
                            break;
                        }
                        else stack.pop();
                    }

                    else if (str.charAt(i) == ']') {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            System.out.println("no");
                            break;
                        }
                        else stack.pop();
                    }

                    if (str.charAt(i) == '.') {
                        if (stack.isEmpty()) System.out.println("yes");
                        else System.out.println("no");
                    }
                }
            }
        }
    }
}
