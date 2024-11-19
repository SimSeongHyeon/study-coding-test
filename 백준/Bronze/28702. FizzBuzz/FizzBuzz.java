import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;

        for (int i = 0; i < 3; i++) {
            String string = bufferedReader.readLine();

            if (string.charAt(0) == 'F' || string.charAt(0) == 'B') {
                continue;
            }

            num = Integer.parseInt(string);

            num += 3 - i;
        }

        if (num % 3 == 0) {
            if (num % 5 == 0) {
                System.out.println("FizzBuzz");
            } else {
                System.out.println("Fizz");
            }
        } else {
            if (num % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(num);
            }
        }
    }
}