import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] mod = new boolean[42];
        int[] num = new int[10];
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            num[i] = a;
            mod[num[i] % 42] = true;
        }

        for (int j = 0; j < mod.length; j++) {
            if(mod[j]) {
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
}