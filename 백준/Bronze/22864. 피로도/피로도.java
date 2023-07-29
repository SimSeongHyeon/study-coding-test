import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int hour = 0;
        int peero = 0;
        int work = 0;

        if (A <= M) {
            while (hour < 24) {
                if (peero + A > M) {
                    peero -= C;
                    if (peero < 0) peero = 0;
                } else {
                    peero += A;
                    work += B;
                }
                hour++;
            }
        }
        
        System.out.println(work);
    }
}