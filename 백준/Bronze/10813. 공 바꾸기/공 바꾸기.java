import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 100;
    public static int n, m;
    public static int[] bucket = new int[MAX_N + 1];

    public static void changeBucket(int x, int y) {
        int[] tmpBucket = new int[MAX_N + 1];

        for(int i = 1; i <= n; i ++) {
            tmpBucket[i] = bucket[i];
        }

        int targetX = tmpBucket[x];
        int targetY = tmpBucket[y];
        tmpBucket[x] = targetY;
        tmpBucket[y] = targetX;

        for(int i = 1; i <= n; i ++) {
            bucket[i] = tmpBucket[i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        for(int i = 1; i <= n; i ++) {
            bucket[i] = i;
        }

        while(m -- > 0) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            changeBucket(x, y);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++) {
            sb.append(bucket[i] + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}