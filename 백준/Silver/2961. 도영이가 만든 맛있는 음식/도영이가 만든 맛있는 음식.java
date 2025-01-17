import java.io.*;
import java.util.*;

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] arr1;
    public static int[] arr2;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static int calc() {
        int val1 = 1;
        int val2 = 0;
        for(int i = 0; i < arr.size(); i ++) {
            int val = arr.get(i);
            int x = arr1[val];
            int y = arr2[val];

            val1 *= x;
            val2 += y;
        }
        int sum = val1 - val2;
        return Math.abs(sum);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            if(arr.size() != 0) {
                ans = Math.min(ans, calc());
            }
            return;
        }

        arr.add(depth);
        dfs(depth + 1);
        arr.remove(arr.size() - 1);
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new int[n];
        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr1[i] = a;
            arr2[i] = b;
        }

        dfs(0);

        bw.write(ans + "");
        bw.flush();
    }
}
