import java.io.*;
import java.util.*;

public class Main {
    public static String s;
    public static int n, ans = Integer.MAX_VALUE;
    public static int[] arr1;
    public static String[] arr2;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean possible() {
        int[] a = new int[128];
        int[] b = new int[128];

        for(int i = 0; i < arr.size(); i ++) {
            String ss = arr2[arr.get(i)];
            for(int j = 0; j < ss.length(); j ++) {
                a[ss.charAt(j) - 'A'] ++;
            }
        }

        for(int i = 0; i < s.length(); i ++) {
            b[s.charAt(i) - 'A'] ++;
        }

        for(int i = 0; i < 128; i ++) {
            if(a[i] < b[i]) return false;
        }
        return true;
    }

    public static void calc() {
        int val = 0;
        for(int i = 0; i < arr.size(); i ++) {
            val += arr1[arr.get(i)];
        }
        ans = Math.min(ans, val);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            if(possible()) {
                calc();
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

        s = br.readLine();
        n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        arr2 = new String[n];

        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            String b = stk.nextToken();
            arr1[i] = a;
            arr2[i] = b;
        }

        dfs(0);

        int ans2 = ans == Integer.MAX_VALUE ? -1 : ans;
        bw.write(ans2 + "");
        bw.flush();
    }
}
