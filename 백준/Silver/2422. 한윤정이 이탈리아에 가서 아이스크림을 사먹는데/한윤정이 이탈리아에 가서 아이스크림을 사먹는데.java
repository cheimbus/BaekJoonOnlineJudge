import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, cnt;
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();
    public static List<Integer> tmp = new ArrayList<>();

    public static boolean possible(int node) {
        for (int t : tmp) {
            if (graph[t].contains(node)) {
                return false;
            }
        }
        return true;
    }

    public static void dfs(int depth, int at) {
        if (depth == 3) {
            sb.append("\n");
            cnt++;
            return;
        }

        for (int i = at; i <= n; i++) {
            if (!visited[i] && possible(i)) {
                visited[i] = true;
                tmp.add(i);
                dfs(depth + 1, i + 1);
                tmp.remove(tmp.size() - 1);
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
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(0, 1);

        bw.write(cnt + "");
        bw.flush();
    }
}
