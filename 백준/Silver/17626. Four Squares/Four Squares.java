import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        dp = new int[50001];

        for(int i = 1; i <= 50000; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 1;
        dp[8] = 2;

        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j * j <= i; j ++) {
                if(i == j * j) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        bw.write(dp[n] + "");
        bw.flush();
    }
}
