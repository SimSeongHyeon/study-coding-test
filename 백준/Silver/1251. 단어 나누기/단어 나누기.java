import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (int i = 1; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                StringBuilder s1 = new StringBuilder(str.substring(0, i));
                StringBuilder s2 = new StringBuilder(str.substring(i, j));
                StringBuilder s3 = new StringBuilder(str.substring(j));
                stringArrayList.add(String.valueOf(s1.reverse()) + s2.reverse() + s3.reverse());
            }
        }

        Collections.sort(stringArrayList);

        System.out.println(stringArrayList.get(0));
    }
}