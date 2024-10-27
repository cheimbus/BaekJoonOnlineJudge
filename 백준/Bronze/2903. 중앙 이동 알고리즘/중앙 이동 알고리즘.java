import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static long ans;
    public static int d, num;

    public static void findDotCnt() {
        ans = (long) Math.pow((num + d), 2);
        num += d;
        d *= 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        d = 1;
        num = 2;
        while(n -- > 0) {
            findDotCnt();
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}