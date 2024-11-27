import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for(int i = 0; i < 5; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int ans = 0;
        for(int i = 0; i < 5; i ++) {
            ans += arr[i] * arr[i];
        }

        bw.write(ans % 10 + "");
        bw.flush();
        br.close();
    }
}