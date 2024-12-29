import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr = new int[]{3, 5};
    public static int[] dp;
    public static int MAX_VAL = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        for(int i = 1; i <= n; i ++) {
            dp[i] = MAX_VAL;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 0; j < 2; j ++) {
                if(i - arr[j] >= 0) {
                    if(dp[i - arr[j]] == MAX_VAL) continue;
                    else dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        int ans = dp[n];
        if(ans == MAX_VAL) ans = -1;

        bw.write(ans + "");
        bw.flush();
    }
}