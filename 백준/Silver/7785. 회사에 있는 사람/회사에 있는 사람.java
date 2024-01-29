import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String status = st.nextToken();

            if (map.containsKey(name)) {
                map.remove(name);
            } else {
                map.put(name, status);
            }
        }

        ArrayList<String> workList = new ArrayList<>(map.keySet());

        workList.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();

        for (String str : workList) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);

    }
}