import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[MAX_N];
        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(stk.nextToken());
            arr[i] = num;
        }

        int x, y, z;
        int val = 0;
        for(int i = 0; i < n - 2; i ++)
            for(int j = i + 1; j < n - 1; j ++)
                for(int k = j + 1; k < n; k ++) {
                    x = arr[i]; y = arr[j]; z = arr[k];
                    if(x + y + z <= m) val = Math.max(val, x + y + z);
                }

        bw.write(val + "\n");
        bw.flush();
        bw.close();
    }
}