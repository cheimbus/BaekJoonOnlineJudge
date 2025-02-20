import java.util.*;
import java.io.*;

class Tuple {
    int x, y, t;
    boolean z;
    public Tuple(int x, int y, int t, boolean z) {
        this.x = x;
        this.y = y;
        this.t = t;
        this.z = z;
    }
}

public class Main {
    public static int n, m, k, ans = Integer.MAX_VALUE;
    public static int[][] grid;
    public static boolean[][][] visited;  // z 여부에 따라 방문 체크

    public static Queue<Tuple> q = new LinkedList<>();
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < m;
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Tuple tu = q.poll();
            int x = tu.x, y = tu.y, t = tu.t;
            boolean z = tu.z;

            if (x == n - 1 && y == m - 1) {
                ans = Math.min(ans, t);
                return;  // 최단 거리이므로 더 탐색할 필요 없음
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (inRange(nx, ny)) {
                    if (grid[nx][ny] == 1 && z && !visited[nx][ny][1]) {  
                        // 벽이지만, 특수 이동(z)이 가능할 경우
                        visited[nx][ny][1] = true;
                        q.add(new Tuple(nx, ny, t + 1, true));
                    } else if (grid[nx][ny] != 1 && !visited[nx][ny][z ? 1 : 0]) {
                        // 벽이 아닐 경우 일반 이동
                        visited[nx][ny][z ? 1 : 0] = true;
                        q.add(new Tuple(nx, ny, t + 1, z || grid[nx][ny] == 2));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m][2];  // z 여부에 따라 방문 체크

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        q.add(new Tuple(0, 0, 0, grid[0][0] == 2));
        visited[0][0][grid[0][0] == 2 ? 1 : 0] = true;

        bfs();

        StringBuilder sb = new StringBuilder();
        sb.append(ans <= k ? ans : "Fail");

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
