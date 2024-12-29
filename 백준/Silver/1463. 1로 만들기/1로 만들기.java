import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[] dp;
    public static int MAX_VAL = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new long[1000001];

        for(int i = 4; i <= n; i ++) {
            dp[i] = MAX_VAL;
        }

        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= n; i ++) {
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        long ans = dp[n];

        bw.write(ans + "");
        bw.flush();
    }
}