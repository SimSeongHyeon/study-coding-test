import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long cnt = 0;
        long i = 1;

        while (sum <= S) {
            sum += i;
            i++;
            cnt++;
        }

        System.out.println(cnt - 1);
    }
}