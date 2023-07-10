import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;
        int a = 0;

        for (int i = N.length() - 1; i >= 0; i--) {
            if (N.charAt(i) - '0' >= 17) {
                sum += (N.charAt(i) - '0' - 7) * Math.pow(B, a);
            }
            
            else {
                sum += (N.charAt(i) - '0') * Math.pow(B, a);
            }
            
            a++;
        }
        System.out.println(sum);
    }
}