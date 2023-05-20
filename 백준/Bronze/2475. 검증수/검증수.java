import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[5];
        int sum = 0;

        for(int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            num[i] = num[i] * num[i];
            sum = sum + num[i];
        }
        bw.write(sum % 10 + "");

        br.close();

        bw.flush();
        bw.close();
    }
}