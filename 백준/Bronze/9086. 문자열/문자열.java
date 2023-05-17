import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
        String str = new String(br.readLine());
        bw.write(str.charAt(0) + "" + str.charAt(str.length()-1) + "");
        bw.newLine();
        }

        br.close();

        bw.flush();
        bw.close();
    }
}