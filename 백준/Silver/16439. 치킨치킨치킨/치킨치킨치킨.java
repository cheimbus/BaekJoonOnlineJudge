import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[][] grid;
    public static boolean[] visited;

    public static void dfs(int depth, int at) {
        if(depth == 3) {
            int val = 0;
            for(int i = 0; i < n; i ++) {
                int sum = 0;
                for(int j = 0; j < m; j ++) {
                    if(visited[j]) {
                        sum = Math.max(sum, grid[i][j]);
                    }
                }
                val += sum;
                ans = Math.max(ans, val);
            }
            return;
        }

        for(int i = at; i < m; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, at + 1);
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

        grid = new int[n][m];
        visited = new boolean[m];

        for(int i = 0; i < n; i ++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j ++) {
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(ans + "");
        bw.flush();
    }
}