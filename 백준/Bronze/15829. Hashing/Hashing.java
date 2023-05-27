import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        int pow = 1;

        for (int i = 0; i < L; i++) {
            answer += (long)(str.charAt(i) - 96) * pow;
            pow = pow * 31 % 1234567891;
        }

        bw.write(answer % 1234567891 + "");

        br.close();

        bw.flush();
        bw.close();
    }
}