import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            double price = Double.parseDouble(bufferedReader.readLine());
            double discountedPrice = price * 0.8;
            System.out.printf("$%.2f\n", discountedPrice);
        }
    }
}