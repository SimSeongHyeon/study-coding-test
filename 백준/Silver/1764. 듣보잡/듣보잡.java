import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        ArrayList<String> stringArrayList = new ArrayList<>();

        for (String str : map.keySet()) {
            if (map.get(str) == 2) {
                stringArrayList.add(str);
            }
        }

        Collections.sort(stringArrayList);

        System.out.println(stringArrayList.size());

        for (String str : stringArrayList) {
            System.out.println(str);
        }
    }
}