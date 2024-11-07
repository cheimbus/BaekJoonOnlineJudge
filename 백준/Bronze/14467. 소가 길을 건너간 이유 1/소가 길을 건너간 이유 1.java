import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int MAX_N = 10;
        int[] arr = new int[MAX_N + 1];

        for(int i = 1; i <= MAX_N; i ++) {
            arr[i] = -1;
        }

        int cnt = 0;
        while(n -- > 0) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int d = Integer.parseInt(stk.nextToken());

            if(arr[x] == -1) arr[x] = d;
            else {
                if((arr[x] == 0 && d == 1) || arr[x] == 1 && d == 0) {
                    cnt ++;
                    arr[x] = d;
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}