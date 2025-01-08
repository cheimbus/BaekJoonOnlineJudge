import java.io.*;
import java.util.*;

public class Main {
    public static int n, s, cnt;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[] tmp;

    public static boolean possible() {
        int ans = 0;
        for(int i = 0; i < arr.size(); i ++) {
            ans += arr.get(i);
        }
        if(arr.size() == 0) return false;
        if(ans == s) return true;
        return false;
    }

    public static void dfs(int val) {
        if(val == n) {
            if(possible()) {
                cnt ++;
            }
            return;
        }

        arr.add(tmp[val]);
        dfs(val + 1);
        arr.remove(arr.size() - 1);
        dfs(val + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        s = Integer.parseInt(stk.nextToken());

        tmp = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            tmp[i] = Integer.parseInt(stk.nextToken());
        }

        dfs(0);

        bw.write(cnt + "");
        bw.flush();
    }
}