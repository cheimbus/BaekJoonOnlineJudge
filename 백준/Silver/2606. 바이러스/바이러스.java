import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans;
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited;

    public static void dfs(int depth) {
        for(int i = 0; i < arr[depth].size(); i ++) {
            int val = arr[depth].get(i);
            if(!visited[val]) {
                visited[val] = true;
                ans ++;
                dfs(val);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        arr = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i ++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        visited[1] = true;
        dfs(1);

        bw.write(ans + "");
        bw.flush();
    }
}