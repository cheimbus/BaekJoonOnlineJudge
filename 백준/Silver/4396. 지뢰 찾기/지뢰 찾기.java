import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static char[][] grid;
    public static char[][] tmp;
    public static char[][] ans;
    public static boolean flag = false;
    public static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static boolean isBomb(int x, int y) {
        return grid[x][y] == '*';
    }

    public static void find(int x, int y, char val) {
        int cnt = 0;
        if(val == 'x') {
            for(int i = 0; i < 8; i ++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && isBomb(nx, ny)) {
                    cnt ++;
                }
                if(grid[x][y] == '*') flag = true;
            }
        }
        else cnt = -1;

        if(cnt >= 0) ans[x][y] = (char) (cnt + '0');
        else ans[x][y] = '.';
    }

    public static void check(int x, int y) {
        ans[x][y] = '*';
    }

    public static void impl() {
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                char val = tmp[i][j];
                find(i, j, val);
            }
        }

        if(flag) {
            for(int i = 0; i < n; i ++) {
                for(int j = 0; j < n; j ++) {
                    if(grid[i][j] == '*') {
                        check(i, j);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        grid = new char[n][n];
        tmp = new char[n][n];
        ans = new char[n][n];

        for(int i = 0; i < n; i ++) {
            char[] s = br.readLine().toCharArray();
            for(int j = 0; j < n; j ++) {
                grid[i][j] = s[j];
            }
        }

        for(int i = 0; i < n; i ++) {
            char[] s = br.readLine().toCharArray();
            for(int j = 0; j < n; j ++) {
                tmp[i][j] = s[j];
            }
        }

        impl();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j ++) {
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}