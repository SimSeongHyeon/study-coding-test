import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append('<');

        int index = 0;

        while (N > 1) {
            index = (index + (K - 1)) % N;
            sb.append(list.remove(index)).append(", ");
            N--;
        }

        sb.append(list.remove()).append('>');

        bw.write(sb + "");

        br.close();

        bw.flush();
        bw.close();
    }
}