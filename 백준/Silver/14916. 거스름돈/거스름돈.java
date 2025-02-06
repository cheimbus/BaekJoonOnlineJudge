import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        int[] arr = new int[]{2, 5};
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i ++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 1; i <= n; i ++) {
            for(int j = 1; j >= 0; j --) {
                if(i - arr[j] >= 0) {
                    if(dp[i - arr[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                }
            }
        }

        int val = dp[n];
        if(val == Integer.MAX_VALUE) val = -1;

        bw.write(val + "");
        bw.flush();
        br.close();
    }
}
