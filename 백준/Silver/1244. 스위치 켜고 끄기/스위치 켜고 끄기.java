import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] arr;

    public static boolean inRange(int x, int y) {
        return 0 <= x && 0 <= y && x < n && y < n;
    }

    public static void impl(int a, int b) {
        if(a == 1) {
            for(int i = b; i < n; i += b + 1) {
                int val = arr[i];
                if(val == 1) arr[i] = 0;
                else arr[i] = 1;
            }
        }
        else {
            int nb1 = b;
            int nb2 = b;
            while(inRange(nb1, nb2)) {
                int nx = arr[nb1];
                int ny = arr[nb2];
                if(nx != ny) break;
                else {
                    if(nx == 1 && ny == 1) {
                        arr[nb1] = 0;
                        arr[nb2] = 0;
                    }
                    else {
                        arr[nb1] = 1;
                        arr[nb2] = 1;
                    }
                }
                nb1 -= 1;
                nb2 += 1;
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
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            impl(a, b - 1);
        }

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        for(int i = 0; i < arr.length; i ++) {
            if(cnt == 20) {
                sb.append("\n");
                cnt = 0;
            }
            cnt ++;
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}