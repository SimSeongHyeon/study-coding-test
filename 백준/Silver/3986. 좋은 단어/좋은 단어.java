import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += isGood(br.readLine());
        }

        System.out.println(cnt);
    }

    static int isGood (String str) {
        Stack<Character> strings = new Stack<>();

        strings.push(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (strings.size() > 0 && strings.peek() == str.charAt(i)) strings.pop();

            else strings.push(str.charAt(i));
        }

        if (strings.empty()) return 1;
        else return 0;
    }
}