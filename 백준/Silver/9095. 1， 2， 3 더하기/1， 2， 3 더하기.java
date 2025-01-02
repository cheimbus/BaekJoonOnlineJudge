import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static int n;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr = new int[]{1, 2, 3};
    public static void find(int val) {
        int[] dp = new int[val + 1];
        dp[0] = 1;

        for(int i = 1; i <= val; i ++) {
            for(int j = 0; j < 3; j ++) {
                if(i >= arr[j]) {
                    dp[i] += dp[i - arr[j]];
                }
            }
        }

        sb.append(dp[val]).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        while(n -- > 0) {
            int val = Integer.parseInt(br.readLine());
            find(val);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
