import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static int n, m;
    public static int[] arr;
    public static int[] tmp;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth, int at) {
        if(depth == m) {
            for(int i = 0; i < tmp.length; i ++) {
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for(int i = at; i < n; i ++) {
            if(before != arr[i]) {
                tmp[depth] = arr[i];
                before = arr[i];
                dfs(depth + 1, i);
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

        dfs(0, 0);

        bw.write(sb.toString());
        bw.flush();
    }
}