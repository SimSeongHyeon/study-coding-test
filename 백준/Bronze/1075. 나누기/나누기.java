import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int num = N / 100 * 100;

        while (num % F != 0) {
            num++;
        }

        if (num % 100 < 10) bw.write("0" + num % 100 + "");
        else bw.write(num % 100 + "");


        br.close();

        bw.flush();
        bw.close();
    }
}