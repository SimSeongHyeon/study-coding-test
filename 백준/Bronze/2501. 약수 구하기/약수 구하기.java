import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> ls = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) ls.add(i);
        }

        if (K > ls.size()) bw.write(0 +"");
        else bw.write(ls.get(K - 1) + "");


        br.close();

        bw.flush();
        bw.close();
    }
}