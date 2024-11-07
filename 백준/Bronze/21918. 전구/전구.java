import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 4000;
    public static int[] arr = new int[MAX_N + 1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i ++) {
            int num = Integer.parseInt(stk.nextToken());
            arr[i] = num;
        }

        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());

            if(a == 1) {
                arr[b] = c;
            }
            else if(a == 2) {
                for(int i = b; i <= c; i ++) {
                    if(arr[i] == 0) arr[i] = 1;
                    else arr[i] = 0;
                }
            }
            else if(a == 3) {
                for(int i = b; i <= c; i ++) {
                    arr[i] = 0;
                }
            }
            else if(a == 4) {
                for(int i = b; i <= c; i ++) {
                    arr[i] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}