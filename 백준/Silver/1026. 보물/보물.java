import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] A = new int[N];

        ArrayList<Integer> B = new ArrayList<>();

        int answer = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
           B.add(Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A);

        B.sort(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            answer += A[i] * B.get(i);
        }

        System.out.println(answer);
    }

}