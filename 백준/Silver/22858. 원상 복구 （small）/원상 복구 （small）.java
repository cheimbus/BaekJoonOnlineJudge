import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n, k;
    public static int[] arr;
    public static int[] arr2;

    public static void impl() {
        while(k -- > 0) {
            int[] tmp = new int[n + 1];

            for(int i = 1; i <= n; i ++) {
                tmp[arr2[i]] = arr[i];
            }
            arr = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        arr = new int[n + 1];
        arr2 = new int[n + 1];

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            arr2[i] = Integer.parseInt(stk.nextToken());
        }

        impl();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}