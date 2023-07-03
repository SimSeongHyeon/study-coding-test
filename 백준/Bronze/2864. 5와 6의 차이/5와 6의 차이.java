import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        String minA = "";
        String minB = "";

        String maxA = "";
        String maxB = "";

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '6' || A.charAt(i) == '5') {
                minA += "5";
                maxA += "6";
            }
            else {
                minA += A.charAt(i);
                maxA += A.charAt(i);
            }
        }

        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == '6' || B.charAt(i) == '5') {
                minB += "5";
                maxB += "6";
            }
            else {
                minB += B.charAt(i);
                maxB += B.charAt(i);
            }
        }
        int min = Integer.parseInt(minA) + Integer.parseInt(minB);
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);

        System.out.println(min + " " + max);
    }
}