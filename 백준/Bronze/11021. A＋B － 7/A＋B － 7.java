import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = Integer.parseInt(st.nextToken());

        for (int j = 1; j <= i; j++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int m = k + l;
            bw.write("Case #" + j + ": " + m);
            bw.newLine();
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
