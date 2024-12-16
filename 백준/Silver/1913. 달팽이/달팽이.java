import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void impl() {
        int x = n / 2;
        int y = n / 2;
        int idx = 0;
        int num = 1;

        grid[x][y] = num;

        while(true) {
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            if(!inRange(nx, ny)) break;

            if(idx != 3) {
                if(grid[nx + dx[idx + 1]][ny + dy[idx + 1]] == 0) idx ++;
            }
            else if(grid[nx + dx[0]][ny + dy[0]] == 0) idx = 0;
            x = nx;
            y = ny;
            grid[nx][ny] = ++ num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        grid = new int[n][n];

        impl();

        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                sb.append(grid[i][j]).append(" ");
                if(m == grid[i][j]) {
                    x = i + 1;
                    y = j + 1;
                }
            }
            sb.append("\n");
        }
        sb.append(x + " ").append(y);
        bw.write(sb.toString());
        bw.flush();

    }
}