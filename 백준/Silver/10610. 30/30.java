import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int[] answer = new int[N.length()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Character.getNumericValue(N.charAt(i));
        }

        Arrays.sort(answer);

        int sum = 0;

        for (int i = 1; i < answer.length; i++) {
            sum += answer[i];
        }

        StringBuilder sb = new StringBuilder();

        if (answer[0] == 0 && sum % 3 == 0) {
            for (int i = answer.length -1 ; i > 0; i--) {
                sb.append(answer[i]);
            }
            
            sb.append(answer[0]);

            System.out.println(sb);
        }

        else System.out.println("-1");
    }
}