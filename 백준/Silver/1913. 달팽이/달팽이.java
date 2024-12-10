import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        grid = new int[n][n];

        int nx = n / 2, ny = n / 2;
        int num = 1;
        int idx = 0;
        grid[nx][ny] = num;

        while(true) {
            nx += dx[idx];
            ny += dy[idx];

            if(!inRange(nx, ny)) break;

            if(idx != 3) {
                if(grid[nx + dx[idx + 1]][ny + dy[idx + 1]] == 0) idx ++;
            }
            else {
                if(grid[nx + dx[0]][ny + dy[0]] == 0) idx = 0;
            }

            grid[nx][ny] = ++num;
        }

        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                if(grid[i][j] == m) {
                    x = i + 1; y = j + 1;
                }
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(x + " " + y);

        bw.write(sb.toString());
        bw.flush();
    }
}