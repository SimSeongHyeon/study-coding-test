import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String ox = br.readLine();
            int cnt = 0;
            int sum = 0;

            for(int j = 0; j < ox.length(); j++) {
                if (ox.charAt(j) ==  'O') {
                    cnt++;
                    sum = sum + cnt;
                }
                else if (ox.charAt(j) == 'X') {
                    cnt = 0;
                }
            }
            
            bw.write(sum + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}