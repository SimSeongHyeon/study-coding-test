import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N > 3) {
            String num = String.valueOf(N);
            if (isGMnum(num)) {
                System.out.println(num);
                break;
            }
            else N--;
        }
    }

    public static boolean isGMnum (String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '4' && str.charAt(i) != '7') {
                break;
            }
            if (i == str.length() -1) return true;
        }
        return false;
    }
}

