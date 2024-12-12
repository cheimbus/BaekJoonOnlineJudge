import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static int n, m, cnt;
    public static boolean[][] arr;

    public static void impl(int k, int l, int x) {
        if(k == 1) {
            arr[l - 1][x - 1] = true;
        }
        else if(k == 2) {
            arr[l - 1][x - 1] = false;
        }
        else if(k == 3) {
            boolean[] tmp = new boolean[20];
            for(int i = 0; i < 19; i ++) {
                tmp[i + 1] = arr[l - 1][i];
            }
            for(int i = 0; i < 20; i ++) {
                arr[l - 1][i] = tmp[i];
            }
        }
        else if(k == 4) {
            boolean[] tmp = new boolean[20];
            for(int i = 19; i >= 1; i --) {
                tmp[i - 1] = arr[l - 1][i];
            }
            for(int i = 0; i < 20; i ++) {
                arr[l - 1][i] = tmp[i];
            }
        }
    }

    public static void check() {
        Set<List<Boolean>> uniqueRows = new LinkedHashSet<>();
        for (boolean[] row : arr) {
            List<Boolean> rowList = new ArrayList<>();
            for (boolean value : row) {
                rowList.add(value);
            }
            uniqueRows.add(rowList);
        }
        cnt = uniqueRows.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        arr = new boolean[n][20];

        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(stk.nextToken());

            if(k == 1) {
                int i = Integer.parseInt(stk.nextToken());
                int x = Integer.parseInt(stk.nextToken());
                impl(k, i, x);
            }
            else if(k == 2) {
                int i = Integer.parseInt(stk.nextToken());
                int x = Integer.parseInt(stk.nextToken());
                impl(k, i, x);
            }
            else if(k == 3) {
                int i = Integer.parseInt(stk.nextToken());
                impl(k, i, 0);
            }
            else if(k == 4) {
                int i = Integer.parseInt(stk.nextToken());
                impl(k, i, 0);
            }
        }

        check();

        bw.write(cnt + "");
        bw.flush();
    }
}