import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        int sum = 0;

        for(byte value : br.readLine().getBytes()) {
            sum = sum + (value - '0');
        }

        bw.write(sum + "");

        br.close();

        bw.flush();
        bw.close();
    }
}