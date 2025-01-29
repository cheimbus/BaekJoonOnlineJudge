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
    public static int n, m, cnt;
    public static char[][] grid;
    public static int[][] tmp;
    public static boolean[][] visited;
    public static Queue<Tuple> q = new LinkedList<>();
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < m && !visited[x][y] && grid[x][y] == '1';
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
                    tmp[nx][ny] = val;
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

        grid = new char[n][m];
        tmp = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i ++) {
            String s = br.readLine();
            for(int j = 0; j < m; j ++) {
                grid[i][j] = s.charAt(j);
            }
        }

        visited[0][0] = true;
        tmp[0][0] = 1;
        q.add(new Tuple(0, 0, 1));
        bfs();

        int val = tmp[n - 1][m - 1];

        bw.write(val + "");
        bw.flush();
    }
}