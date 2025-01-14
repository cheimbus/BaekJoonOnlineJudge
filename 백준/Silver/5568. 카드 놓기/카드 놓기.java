import java.io.*;
import java.util.*;

public class Main {
    public static int n, k, cnt;
    public static int[] arr;
    public static ArrayList<Integer> tmp = new ArrayList<>();
    public static boolean[] visited;
    public static TreeSet<Integer> tree = new TreeSet<>();

    public static void possible() {
        String s = "";
        for(int i = 0; i < tmp.size(); i ++) {
            s += tmp.get(i);
        }

        int val = Integer.parseInt(s);
        tree.add(val);
    }

    public static void dfs(int depth) {
        if(depth == k) {
            possible();
            return;
        }

        for(int i = 0; i < n; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp.add(arr[i]);
                dfs(depth + 1);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        arr = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        int ans = tree.size();

        bw.write(ans + "");
        bw.flush();
    }
}
