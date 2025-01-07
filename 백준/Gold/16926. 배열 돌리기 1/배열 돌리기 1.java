import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, r;
    public static int[][] grid;
    public static int[][] tmp;

    public static void change(int nx, int ny, int x, int y) {
        int val = 0;
        for(int i = x; i < nx; i ++) {
            val = grid[i][y];
            tmp[i + 1][y] = val;
        }

        tmp[nx][y + 1] = grid[nx][y];
        for(int i = y + 1; i < ny; i ++) {
            val = grid[nx][i];
            tmp[nx][i + 1] = val;
        }

        tmp[nx - 1][ny] = grid[nx][ny];
        for(int i = nx - 1; i > x; i --) {
            val = grid[i][ny];
            tmp[i - 1][ny] = val;
        }

        tmp[x][ny - 1] = grid[x][ny];
        for(int i = ny - 1; i > y; i --) {
            val = grid[x][i];
            tmp[x][i - 1] = val;
        }
    }

    public static void find() {
        int nx = n;
        int ny = m;
        int sx = 1;
        int sy = 1;

        while(nx >= sx + 1 && ny >= sy + 1) {
            change(nx, ny, sx, sy);
            nx -= 1;
            ny -= 1;
            sx ++;
            sy ++;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                grid[i][j] = tmp[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        r = Integer.parseInt(stk.nextToken());

        grid = new int[n + 1][m + 1];
        tmp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        while(r -- > 0) {
            find();
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= m; j ++) {
                sb.append(grid[i][j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}