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
            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back" :
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front" :
                    bw.write(pop_front() + "\n");
                    break;

                case "pop_back" :
                    bw.write(pop_back() + "\n");
                    break;

                case "size" :
                    bw.write(size() + "\n");
                    break;

                case "empty" :
                    bw.write(empty() + "\n");
                    break;

                case  "front" :
                    bw.write(front() + "\n");
                    break;

                case "back" :
                    bw.write(back() + "\n");
                    break;
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }

    public static void push_front (int X) {
        ls.add(X);

        for(int i = 0; i < ls.size() - 1; i++) {
            ls.add(ls.get(0));
            ls.remove(0);
        }
    }

    public static void push_back (int X) {
        ls.add(X);
    }

    public static int pop_front () {
        if (!ls.isEmpty()) {
            int popFrtNum = ls.get(0);
            ls.remove(0);
            return popFrtNum;
        }
        else return -1;
    }

    public static int pop_back () {
        if (!ls.isEmpty()) {
            int popBkNum = ls.get(ls.size() - 1);
            ls.remove(ls.size() - 1);
            return popBkNum;
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

    public static int front () {
        if (!ls.isEmpty()) return ls.get(0);
        else return -1;
    }

    public static int back () {
        if (!ls.isEmpty()) return ls.get(ls.size() - 1);
        else return -1;
    }
}
