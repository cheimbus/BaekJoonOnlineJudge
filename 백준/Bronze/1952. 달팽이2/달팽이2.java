import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n, m, cnt;
    public static boolean[][] visited = new boolean[MAX_N + 1][MAX_N + 1];
    public static int[] dx = {0, 1, 0, -1}; // 동, 남, 서, 북
    public static int[] dy = {1, 0, -1, 0};

    public static boolean inRange(int x, int y) {
        return 1 <= x && x <= n && 1 <= y && y <= m;
    }

    public static boolean allDirectionsBlocked(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (inRange(nx, ny) && !visited[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    public static void move() {
        int dir = 0;
        visited[1][1] = true;

        int x = 1, y = 1, visitedCnt = 1;
        while (visitedCnt < n * m) {
            if (allDirectionsBlocked(x, y)) break;

            int nx = x + dx[dir], ny = y + dy[dir];

            if (!inRange(nx, ny) || visited[nx][ny]) {
                cnt++;
                dir = (dir + 1) % 4;
            } else {
                x = nx;
                y = ny;
                visited[x][y] = true;
                visitedCnt++;
            }
        }
    }

    public static void simulate() {
        move();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        simulate();

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
