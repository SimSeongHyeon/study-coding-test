import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = N; i >= 1; i--) {
            bw.write(i + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}