import java.util.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Map<Integer, Set<Integer>> likesMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];

        List<Integer> students = new ArrayList<>();
        for (int i = 0; i < N * N; i++) {
            int student = sc.nextInt();
            students.add(student);
            Set<Integer> likes = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                likes.add(sc.nextInt());
            }
            likesMap.put(student, likes);
        }

        for (int student : students) {
            placeStudent(student);
        }

        System.out.println(calculateSatisfaction());
    }

    static void placeStudent(int student) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    int likeCount = 0, emptyCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (board[nx][ny] == 0) {
                                emptyCount++;
                            } else if (likesMap.get(student).contains(board[nx][ny])) {
                                likeCount++;
                            }
                        }
                    }
                    pq.offer(new Position(i, j, likeCount, emptyCount));
                }
            }
        }
        Position bestPos = pq.poll();
        board[bestPos.x][bestPos.y] = student;
    }

    static int calculateSatisfaction() {
        int totalSatisfaction = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int student = board[i][j];
                int likeCount = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N && likesMap.get(student).contains(board[nx][ny])) {
                        likeCount++;
                    }
                }
                if (likeCount == 1) {
                    totalSatisfaction += 1;
                } else if (likeCount == 2) {
                    totalSatisfaction += 10;
                } else if (likeCount == 3) {
                    totalSatisfaction += 100;
                } else if (likeCount == 4) {
                    totalSatisfaction += 1000;
                }
            }
        }
        return totalSatisfaction;
    }

    static class Position implements Comparable<Position> {
        int x, y, likeCount, emptyCount;

        Position(int x, int y, int likeCount, int emptyCount) {
            this.x = x;
            this.y = y;
            this.likeCount = likeCount;
            this.emptyCount = emptyCount;
        }

        @Override
        public int compareTo(Position o) {
            if (this.likeCount != o.likeCount) {
                return o.likeCount - this.likeCount;
            }
            if (this.emptyCount != o.emptyCount) {
                return o.emptyCount - this.emptyCount;
            }
            if (this.x != o.x) {
                return this.x - o.x;
            }
            return this.y - o.y;
        }
    }
}
