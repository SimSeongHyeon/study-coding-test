import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> fib = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            if (i == 0) fib.add(0);
            else if (i == 1) fib.add(1);
            else fib.add(fib.get(i - 2) + fib.get(i - 1));
        }

        bw.write(fib.get(n) + "");

        br.close();

        bw.flush();
        bw.close();
    }
}