import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}