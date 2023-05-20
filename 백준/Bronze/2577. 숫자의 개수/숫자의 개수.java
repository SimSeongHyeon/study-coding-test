import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int mul = A * B * C;

        int[] num = new int[10];

        while (mul != 0) {
            num[mul % 10]++;
            mul = mul / 10;
        }

        for (int i = 0; i < num.length; i++) {
            bw.write(num[i] + "\n");
        }


        br.close();

        bw.flush();
        bw.close();
    }
}