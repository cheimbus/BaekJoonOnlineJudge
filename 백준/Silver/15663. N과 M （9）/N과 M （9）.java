import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static int[] tmp;
    public static boolean[] visited;

    public static void dfs(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i = 0; i < n; i ++) {
            if(visited[i]) continue;

            if(before != arr[i]) {
                visited[i] = true;
                tmp[cnt] = arr[i];
                before = arr[i];
                dfs(cnt + 1);
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

        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        bw.write(sb.toString());
        bw.flush();
    }
}