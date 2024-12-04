import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static int[] tmp;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int currNum) {
        if(currNum == m) {
            for(int i = 0; i < tmp.length; i ++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp[currNum] = arr[i];
                dfs(currNum + 1);
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