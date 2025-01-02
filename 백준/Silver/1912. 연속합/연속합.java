import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= n; i ++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(dp[i], ans);
        }
        bw.write(ans + "");
        bw.flush();
    }
}
