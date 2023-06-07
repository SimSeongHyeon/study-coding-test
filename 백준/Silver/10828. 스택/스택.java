import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> ls = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    push(X);
                    break;

                case "pop" :
                    bw.write(pop() + "\n");
                    break;

                case "size" :
                    bw.write(size() + "\n");
                    break;

                case "empty" :
                    bw.write(empty() + "\n");
                    break;

                case "top" :
                    bw.write(top() + "\n");
                    break;
            }

        }

        br.close();

        bw.flush();
        bw.close();
    }

    public static void push (int X) {
        ls.add(X);
    }

    public static int pop () {
        if (!ls.isEmpty()) {
            int num = ls.get(ls.size() - 1);
            ls.remove(ls.size() - 1);
            return num;
        }
        else return -1;
    }

    public static int size () {
        return ls.size();
    }

    public static int empty () {
        if (ls.isEmpty()) return 1;
        else return 0;
    }

    public static int top () {
        if (!ls.isEmpty()) return ls.get(ls.size() - 1);
        else return -1;
    }
}