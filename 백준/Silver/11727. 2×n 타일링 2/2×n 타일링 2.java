import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new long[1001];
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= n; i ++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }

        bw.write(dp[n] + "");
        bw.flush();
    }
}
