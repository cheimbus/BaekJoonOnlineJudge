import java.io.*;
import java.util.*;

public class Main {
    public static int MAX_VAL = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[21];
        int[] arr2 = new int[21];
        int[][] dp = new int[21][2];

        for(int i = 1; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr1[i] = a;
            arr2[i] = b;
        }

        int k = Integer.parseInt(br.readLine());

        dp[1][0] = arr1[1];
        dp[1][1] = MAX_VAL;
        dp[2][0] = Math.min(dp[1][0] + arr1[2], arr2[1]);
        dp[2][1] = MAX_VAL;
        dp[3][0] = Math.min(dp[2][0] + arr1[3], dp[1][0] + arr2[2]);
        dp[3][1] = k;

        for(int i = 4; i < n; i ++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr1[i], dp[i - 2][0] + arr2[i - 1]);
            dp[i][1] = Math.min(dp[i - 3][0] + k, Math.min(dp[i - 1][1] + arr1[i], dp[i - 2][1] + arr2[i - 1]));
        }

        int ans = MAX_VAL;
        for(int i = 0; i < 2; i ++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }

        bw.write(ans + "");
        bw.flush();
    }
}