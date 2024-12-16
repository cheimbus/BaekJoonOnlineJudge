import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[] arr;

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void impl(int x, int y) {
        if(x == 1) {
            for(int i = y; i < n; i += y + 1) {
                int val = arr[i];
                if(val == 1) {
                    arr[i] = 0;
                }
                else arr[i] = 1;
            }
        }
        else {
            int nx = y;
            int ny = y;

            while(inRange(nx, ny) && arr[nx] == arr[ny]) {
                if(arr[nx] == 1 && arr[ny] == 1) {
                    arr[nx] = 0;
                    arr[ny] = 0;
                }
                else {
                    arr[nx] = 1;
                    arr[ny] = 1;
                }
                nx -= 1;
                ny += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        m = Integer.parseInt(br.readLine());

        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            impl(x, y - 1);
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < n; i ++) {
            sb.append(arr[i]).append(" ");
            cnt ++;
            if(cnt == 20) {
                cnt = 0;
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

    }
}