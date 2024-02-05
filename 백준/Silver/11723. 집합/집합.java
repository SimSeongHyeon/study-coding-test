import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> S = new HashMap<>();

    static void add(int x) {
        if (!S.containsKey(x)) {
            S.put(x, 0);
        }
    }

    static void remove(int x) {
            S.remove(x);
    }

    static void check(int x) {
        if (S.containsKey(x)) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    static void toggle(int x) {
        if (S.containsKey(x)) {
            S.remove(x);
        } else {
            S.put(x, 0);
        }
    }

    static void all() {
        S.clear();
        for (int i = 1; i < 21; i++) {
            S.put(i, 0);
        }
    }

    static void empty() {
        S.clear();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                add(x);
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                remove(x);
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                check(x);
            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                toggle(x);
            } else if (command.equals("all")) {
                all();
            } else if (command.equals("empty")) {
                empty();
            }
        }

        System.out.println(sb);
    }
}