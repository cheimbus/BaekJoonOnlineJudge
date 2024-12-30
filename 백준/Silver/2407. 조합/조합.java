import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        BigInteger[][] dp = new BigInteger[101][101];
        for(int i = 0; i <= n; i ++) {
            for(int j = 0; j <= n; j ++) {
                dp[i][j] = BigInteger.valueOf(0);
            }
        }
        dp[0][0] = BigInteger.valueOf(1);

        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j <= i; j ++) {
                if(j == 0) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
            }
        }

        bw.write(dp[n][m] + "");
        bw.flush();
    }
}
