import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[][] dp = new int[30][30];
    public static int findAbleSite(int n, int m) {

        if(dp[n][m] > 0) return dp[n][m];

        if(n == m || m == 0) return dp[n][m] = 1;

        return dp[n][m] = findAbleSite(n - 1, m - 1) + findAbleSite(n - 1, m);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < t; i ++) {
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());

            sb.append(findAbleSite(m, n)).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}