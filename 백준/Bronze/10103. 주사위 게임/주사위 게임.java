import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int diceChang = 0;
        int diceSang = 0;

        int scrChang = 100;
        int scrSang = 100;

        for (int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            diceChang = Integer.parseInt(st.nextToken());
            diceSang = Integer.parseInt(st.nextToken());

            if (diceChang > diceSang) scrSang -= diceChang;
            else if (diceChang < diceSang) scrChang -= diceSang;
        }

        System.out.println(scrChang);
        System.out.println(scrSang);
    }
}