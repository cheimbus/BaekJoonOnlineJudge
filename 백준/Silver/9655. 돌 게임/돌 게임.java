import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;

        for(int i = 4; i <= n; i ++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        int ans = dp[n];
        StringBuilder sb = new StringBuilder();
        if(ans % 2 == 0) sb.append("CY");
        else sb.append("SK");

        bw.write(sb.toString());
        bw.flush();
    }
}