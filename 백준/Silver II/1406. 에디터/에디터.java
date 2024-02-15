import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        String string = br.readLine();

        int M = Integer.parseInt(br.readLine());

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            leftStack.push(string.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "L" :
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }

                    break;

                case "D" :
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }

                    break;

                case "B" :
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }

                    break;

                case "P" :
                    String character = st.nextToken();

                    leftStack.push(character.charAt(0));

                    break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }

        System.out.println(sb);
    }
}