import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] visited;

    public static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < arr.length; i ++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }
}