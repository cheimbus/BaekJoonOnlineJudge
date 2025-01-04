import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        visited[1] = true;
        for(int i = 1; i <= n; i ++) {
            for(int j = i + 1; j <= n; j ++) {
                if(visited[i]) {
                    if((j - i) * (1 + Math.abs(arr[i] - arr[j])) <= k) visited[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(visited[n]) sb.append("YES");
        else sb.append("NO");

        bw.write(sb.toString());
        bw.flush();
    }
}