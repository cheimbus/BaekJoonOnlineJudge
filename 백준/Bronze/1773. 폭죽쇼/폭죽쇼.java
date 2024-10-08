import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n, c, cnt;
    public static int[] student;

    public static void firecracker() {
        for(int i = 1; i <= c; i ++) {
            boolean isFirecracker = false;
            for(int j = 0; j < n; j ++) {
                if(i % student[j] == 0) {
                    isFirecracker = true;
                    break;
                }
            }
            if(isFirecracker) cnt ++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        student = new int[n];

        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(br.readLine());
            student[i] = num;
        }

        firecracker();

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}