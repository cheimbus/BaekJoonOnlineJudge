import java.util.*;
import java.io.*;


public class Main {
    public static ArrayList<Integer>[] arr;
    public static boolean[] visited1;
    public static boolean[] visited2;
    public static int n, m, s;
    public static Queue<Integer> q = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        for(int i = 0; i < arr[depth].size(); i ++) {
            int x = arr[depth].get(i);
            if(!visited1[x]) {
                visited1[x] = true;
                sb.append(x + " ");
                dfs(x);
            }
        }
    }

    public static void bfs(int val) {
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int i = 0; i < arr[x].size(); i ++) {
                int val2 = arr[x].get(i);
                if(!visited2[val2]) {
                    visited2[val2] = true;
                    q.add(val2);
                    sb.append(val2 + " ");
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
        s = Integer.parseInt(stk.nextToken());

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

        visited1[s] = true;
        sb.append(s + " ");
        dfs(s);
        sb.append("\n");
        visited2[s] = true;
        q.add(s);
        sb.append(s + " ");
        bfs(s);

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
