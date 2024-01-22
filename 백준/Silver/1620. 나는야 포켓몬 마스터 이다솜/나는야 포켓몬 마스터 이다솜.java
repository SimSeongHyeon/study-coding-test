import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> idxName = new HashMap<>();
        Map<String, Integer> nameIdx = new HashMap<>();

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            idxName.put(i, name);
            nameIdx.put(name, i);
        }

        for (int i = 1; i <= M; i++) {

            String str = br.readLine();

            if (49 <= str.charAt(0) && str.charAt(0) <= 57) {
                sb.append(idxName.get(Integer.parseInt(str))).append("\n");
            } else {
                sb.append(nameIdx.get(str)).append("\n");
            }
        }

        System.out.println(sb);
    }
}