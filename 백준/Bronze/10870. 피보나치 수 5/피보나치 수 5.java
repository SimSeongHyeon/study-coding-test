import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(Fib(n) + "");

        br.close();

        bw.flush();
        bw.close();
    }

    public static int Fib (int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        return Fib(n - 1) + Fib(n - 2);
    }
}