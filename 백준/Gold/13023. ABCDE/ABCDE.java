import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> relationship;
    static boolean isFound = false;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        relationship = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            relationship.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());

            relationship.get(a).add(b);
            relationship.get(b).add(a);
        }

        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            findABCDERelationship(i, 1);

            if(isFound) {
                break;
            }
        }

        System.out.println(isFound ? 1 : 0);
    }

    static void findABCDERelationship(int node, int depth) {
        if (depth == 5) {
            isFound = true;
            return;
        }

        isVisited[node] = true;

        for (int adjacentNode : relationship.get(node)) {
            if (!isVisited[adjacentNode]) {
                findABCDERelationship(adjacentNode, depth + 1);

                if (isFound) {
                    return;
                }
            }
        }

        isVisited[node] = false;
    }

}