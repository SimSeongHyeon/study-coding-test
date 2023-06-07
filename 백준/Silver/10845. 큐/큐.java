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
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    bw.write(pop() + "\n");
                    break;

                case  "size" :
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

    public static void push (int X) {
        ls.add(X);
    }

    public static int pop () {
        if(!ls.isEmpty()) {
            int popNum = ls.get(0);
            ls.remove(0);
            return popNum;
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