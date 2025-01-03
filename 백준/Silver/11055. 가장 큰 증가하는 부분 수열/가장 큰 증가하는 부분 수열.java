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
        arr = new int[1001];
        dp = new int[1001];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        for(int i = 1; i <= n; i ++) {
            dp[i] = arr[i];
            for(int j = i - 1; j >= 1; j --) {
                if(arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + arr[i]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i ++) {
            ans = Math.max(ans, dp[i]);
        }

        bw.write(ans + "");
        bw.flush();
    }
}
