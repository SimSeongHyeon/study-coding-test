import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();

        while (N > 0) {
            arrayList.add(N % 10);
            N /= 10;
        }

        arrayList.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (int i : arrayList) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}