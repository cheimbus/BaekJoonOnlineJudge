import java.io.*;
import java.util.*;

public class Main {
    public static int[][] grid;
    public static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        grid = new int[n + 1][n + 1];
        dp = new long[n + 1][n + 1];

        for(int i = 1; i <= n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp[1][1] = 1;

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j <= n; j ++) {
                int next = grid[i][j];
                if(next == 0) break;
                if(n >= next + j) dp[i][j + next] += dp[i][j];
                if(n >= next + i) dp[i + next][j] += dp[i][j];
            }
        }

        bw.write(dp[n][n] + "");
        bw.flush();
    }
}
