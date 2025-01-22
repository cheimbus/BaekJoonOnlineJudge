import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static StringBuilder sb = new StringBuilder();
    public static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited1;
    public static boolean[] visited2;

    public static void dfs(int depth) {
        for(int i = 0; i < arr[depth].size(); i ++) {
            int val = arr[depth].get(i);
            if(!visited1[val]) {
                visited1[val] = true;
                sb.append(val + " ");
                dfs(val);
            }
        }
    }

    public static void bfs() {
        while(!q.isEmpty()) {
            int val = q.poll();
            for(int i = 0; i < arr[val].size(); i ++) {
                int val2 = arr[val].get(i);
                if(!visited2[val2]) {
                    sb.append(val2 + " ");
                    visited2[val2] = true;
                    q.add(val2);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        arr = new ArrayList[n + 1];
        visited1 = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        for(int i = 1; i <= n; i ++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i ++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        for(int i = 1; i <= n; i ++) {
            Collections.sort(arr[i]);
        }

        sb.append(k + " ");
        visited1[k] = true;
        dfs(k);
        sb.append("\n");

        sb.append(k + " ");
        visited2[k] = true;
        q.add(k);
        bfs();

        bw.write(sb.toString());
        bw.flush();
    }
}