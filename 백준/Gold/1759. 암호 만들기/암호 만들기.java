import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static boolean isValidPassword(char[] password) {
        boolean vowelFlag = false;
        boolean consonantFlag = false;
        int consonantCount = 0;

        for (char c : password) {
            if (!vowelFlag && isVowel(c)) {
                vowelFlag = true;
            }

            if ('a' <= c && c <= 'z' && !isVowel(c)) {
                consonantCount++;
            }

            if (!consonantFlag && consonantCount == 2) {
                consonantFlag = true;
            }

            if (vowelFlag && consonantFlag) {
                return true;
            }
        }

        return false;
    }

    static void backTracking(char[] alphabet, char[] password, int L, int length, int index) {
        if (length == L) {
            if (isValidPassword(password)) {
                System.out.println(password);
            }

            return;
        }

        for (int i = index; i < alphabet.length; i++) {
            password[length] = alphabet[i];

            backTracking(alphabet, password, L, length + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] password = new char[L];
        char[] alphabet = new char[C];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        backTracking(alphabet, password, L, 0, 0);
    }
}