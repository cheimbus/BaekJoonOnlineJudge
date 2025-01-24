import java.util.*;
import java.io.*;

class Tuple {
    int x;
    int y;
    int z;
    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    public static int n, m;
    public static Queue<Tuple> q = new LinkedList<>();
    public static int[][] grid;
    public static boolean[][] visited;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};
    public static int[][] ans;

    public static boolean inRange(int x, int y) {
        return 1 <= x && 1 <= y && x <= n && y <= m && !visited[x][y] && grid[x][y] != 0;
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int val = ++ t.z;
            for(int i = 0; i < 4; i ++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if(inRange(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Tuple(nx, ny, val));
                    ans[nx][ny] = val;
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

        grid = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        ans = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int findX = 0;
        int findY = 0;
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if(grid[i][j] == 2) {
                    findX = i;
                    findY = j;
                }
            }
        }

        visited[findX][findY] = true;
        q.add(new Tuple(findX, findY, 0));

        bfs();

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                if(!visited[i][j] && grid[i][j] != 0) sb.append(-1 + " ");
                else sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}