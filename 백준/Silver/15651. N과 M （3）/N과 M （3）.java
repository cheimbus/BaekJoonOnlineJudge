import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < arr.length; i ++) {
                sb.append(arr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i ++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[m];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }
}