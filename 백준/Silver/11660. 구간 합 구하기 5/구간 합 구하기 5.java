import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] grid;
    public static int[][] dp;
    public static StringBuilder sb = new StringBuilder();

    public static void find(int x1, int y1, int x2, int y2) {
        int ans = 0;
        for(int i = x1; i <= x2; i ++) {
            ans += dp[i][y2] - dp[i][y1 - 1];
        }
        sb.append(ans + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        grid = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i = 1; i <= n; i ++) {
            dp[i][1] = grid[i][1];
            int val = grid[i][1];
            for(int j = 2; j <= n; j ++) {
                val += grid[i][j];
                dp[i][j] = val;
            }
        }

        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());
            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            find(x1, y1, x2, y2);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}