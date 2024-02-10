import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int lengthA = Integer.parseInt(st.nextToken());

        int lengthB = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < lengthA; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < lengthB; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        } //End Of Input

        Set<Integer> diffA = new HashSet<>(A);
        diffA.removeAll(B);

        Set<Integer> diffB = new HashSet<>(B);
        diffB.removeAll(A);

        System.out.println(diffA.size() + diffB.size());
    }
}
