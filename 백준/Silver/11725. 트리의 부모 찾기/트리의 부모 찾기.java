import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static ArrayList<Integer>[] arr;
    public static Queue<Integer> q = new LinkedList<>();
    public static boolean[] visited;
    public static int[] p;

    public static void bfs() {
        while(!q.isEmpty()) {
            int val = q.poll();
            for(int i = 0; i < arr[val].size(); i ++) {
                int val2 = arr[val].get(i);
                if(!visited[val2]) {
                    visited[val2] = true;
                    q.add(val2);
                    p[val2] = val;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        p = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i ++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            arr[x].add(y);
            arr[y].add(x);
        }

        visited[1] = true;
        q.add(1);
        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i ++) {
            sb.append(p[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}