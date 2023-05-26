import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 1;
        int cnt = 0;

        while (cnt != N) {
            num++;
            if (Integer.toString(num).contains("666")) cnt++;
        }

        bw.write(num + "");

        br.close();

        bw.flush();
        bw.close();
    }
}