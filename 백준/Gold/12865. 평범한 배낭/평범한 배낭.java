import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[k + 1];

        for(int i = 1; i <= n; i ++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr1[i] = a;
            arr2[i] = b;
        }
        int[] dp = new int[k + 1];

        for(int i = 1; i <= n; i ++) {
            for(int j = k; j >= arr1[i]; j --) {
                if(j - arr1[i] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - arr1[i]] + arr2[i]);
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= k; i ++) {
            ans = Math.max(ans, dp[i]);
        }
        bw.write(ans + "");
        bw.flush();
    }
}