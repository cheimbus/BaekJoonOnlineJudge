import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] tmp;
    public static int MAX_VAL = Integer.MIN_VALUE;
    public static int MIN_VAL = Integer.MAX_VALUE;
    public static int[] arr;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static int calc() {
        int val = tmp[0];
        int pos = 0;
        for(int i = 1; i < tmp.length; i ++) {
            if(list.get(pos) == 0) val += tmp[i];
            else if(list.get(pos) == 1) val -= tmp[i];
            else if(list.get(pos) == 2) val *= tmp[i];
            else val /= tmp[i];
            pos ++;
        }
        return val;
    }

    public static void dfs(int val) {
        if(val == m) {
            MAX_VAL = Math.max(MAX_VAL, calc());
            MIN_VAL = Math.min(MIN_VAL, calc());
            return;
        }

        for(int i = 0; i < 4; i ++) {
            if(arr[i] != 0) {
                arr[i] --;
                list.add(i);
                dfs(val + 1);
                list.remove(list.size() - 1);
                arr[i] ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        tmp = new int[n];
        arr = new int[4];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            tmp[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i ++) {
            int val = Integer.parseInt(stk.nextToken());
            arr[i] = val;
            m += val;
        }

        dfs(0);

        StringBuilder sb = new StringBuilder();
        sb.append(MAX_VAL).append("\n").append(MIN_VAL);
        bw.write(sb.toString());
        bw.flush();
    }
}