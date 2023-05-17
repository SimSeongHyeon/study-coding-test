import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = System.in.read();
        System.out.println(a);

        br.close();

        bw.flush();
        bw.close();
    }
}