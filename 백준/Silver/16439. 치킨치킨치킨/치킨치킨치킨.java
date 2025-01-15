import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[][] grid;
    public static boolean[] visited;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void calc() {
        int sum = 0;

        for(int j = 0; j < n; j ++) {
            int val = 0;
            for(int k = 0; k < arr.size(); k ++) {
                int idx = arr.get(k);
                val = Math.max(val, grid[j][idx]);
            }
            sum += val;
        }
        ans = Math.max(ans, sum);
    }

    public static void dfs(int depth, int at) {
        if(depth == 3) {
            calc();
            return;
        }

        for(int i = at; i < m; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                arr.add(i);
                dfs(depth + 1, i);
                visited[i] = false;
                arr.remove(arr.size() - 1);
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
