import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int answer = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))) break;
            answer++;
        }
        
        System.out.println(answer);
    }

    static boolean isPalindrome (String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;

        while (leftIdx <= rightIdx) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }

            leftIdx++;
            rightIdx--;
        }
        
        return true;
    }
}