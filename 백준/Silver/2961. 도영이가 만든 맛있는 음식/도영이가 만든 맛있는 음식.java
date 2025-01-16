import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int n, ans = Integer.MAX_VALUE;
    public static ArrayList<Pair> arr = new ArrayList<>();
    public static ArrayList<Pair> tmp = new ArrayList<>();

    public static boolean possible() {
        return tmp.size() != 0;
    }

    public static int calc() {
        int xVal = 1;
        int yVal = 0;
        for(int i = 0; i < tmp.size(); i ++) {
            int x = tmp.get(i).x;
            int y = tmp.get(i).y;

            xVal *= x;
            yVal += y;
        }
        int val = xVal - yVal;
        return Math.abs(val);
    }

    public static void dfs(int depth) {
        if(depth == n) {
            if(possible()) {
                ans = Math.min(ans, calc());
            }
            return;
        }

        tmp.add(arr.get(depth));
        dfs(depth + 1);
        tmp.remove(tmp.size() - 1);
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i ++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            arr.add(new Pair(x, y));
        }

        dfs(0);

        bw.write(ans + "");
        bw.flush();
    }
}
